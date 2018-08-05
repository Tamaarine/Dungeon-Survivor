package com.mygdx.game;

import RequiredThings.MyInputProcessor;
import Actors.Orc;
import Actors.MainCharacter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import java.util.ArrayList;

public class GameScreen implements Screen {
    //Required varaible
    DungeonSurvivor game;
    SpriteBatch batch;
    OrthographicCamera camera;
    BitmapFont font;
    ShapeRenderer shape;
    MagicEffect effect;
    
    //Counters
    int counter;
    int framePast;
    int framerate;
    
    //Characters
    MainCharacter princess;
    ArrayList<Orc> orcmonster;
    
    //Textures
    private Texture bg1;
    private Texture bg2;
    
    //Toggle booleans
    private boolean hitbox;
    private boolean fps;
    
    //Orc frame time counter
    float forCorrectDrawing;
    
    //For sound effects
    Sound oof;
    Music heartBeat;
    
    //Input processor
    MyInputProcessor inputProcessor;
    
    //TileSets
    TileSet tiles;
    
    //Stage
    BeginningStage layout;
    
    //Extra backgrounds
    String extraBg[][];
    
    public GameScreen(DungeonSurvivor game) 
    {
        this.game = game;
        princess = new MainCharacter("Chara",0,0);
        batch = game.batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,800);
        counter=0;
        orcmonster=new ArrayList<Orc>();
        shape=new ShapeRenderer();
        font=new BitmapFont(Gdx.files.internal("Font/verdana72.fnt"));
        framePast=43;
        framerate=(int)(1/Gdx.graphics.getDeltaTime());
        forCorrectDrawing=0;
        effect=new MagicEffect();
        tiles=new TileSet();
        layout=new BeginningStage();
        extraBg=new String[25][25];
        
        extraBg[5][5]="Chest";
        
        //Instantiating textures
        bg1=new Texture(Gdx.files.internal("Image/bg1.png"));
        bg2=new Texture(Gdx.files.internal("Image/bg2.jpg"));
        
        hitbox=false;
        fps=false;
        
        orcmonster.add(new Orc(new Rectangle(50,34,64,64),35));
        orcmonster.add(new Orc(new Rectangle(150,34,64,64),80));
        orcmonster.add(new Orc(new Rectangle(250,34,64,64),60));
        orcmonster.add(new Orc(new Rectangle(350,34,64,64),90));
        
        oof=Gdx.audio.newSound(Gdx.files.internal("Sound/oof.mp3"));
        heartBeat=Gdx.audio.newMusic(Gdx.files.internal("Sound/heartracing.mp3"));
        
        float dealtatime=Gdx.graphics.getDeltaTime();
        inputProcessor=new MyInputProcessor(princess,dealtatime,oof,orcmonster);
        Gdx.input.setInputProcessor(inputProcessor);
        
        
    }
    
    @Override
    public void show() 
    {
        
    }
    
    @Override
    public void render(float delta) 
    {
        //Necessary things
        Gdx.gl.glClearColor(0, 0,0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        
        //Getting the delta time
        float dealtatime=Gdx.graphics.getDeltaTime();
        forCorrectDrawing+=dealtatime;
        framePast=framePast+1;
        
        batch.begin();
        
        //Drawing the background of the game
        drawBackground();
        
        //Calling the method that handles the drawing for the character
        handleDrawingCharacter(dealtatime);
        
        handleAllOtherButtonPress(dealtatime);
        
        handleDrawingMonster();
        
        drawFrameRate(dealtatime);
        
        Animation<TextureRegion> blueFlame=effect.getBlueFlameAni();
        blueFlame.setPlayMode(Animation.PlayMode.LOOP);
        
        Animation<TextureRegion> fireSpin=effect.getFireSpinAni();
        fireSpin.setPlayMode(Animation.PlayMode.LOOP);
        
        batch.draw(blueFlame.getKeyFrame(forCorrectDrawing),0,100,200,200);
        batch.draw(fireSpin.getKeyFrame(forCorrectDrawing), 0, 200,200,200);
        
        batch.end();
        
        if(orcmonster.size()>0)
        {
            if(princess.position.overlaps(orcmonster.get(0).getPosition()))
            {
                System.out.println("BOOPM THE PRINCESS GETS MURDERED");
                oof.play();
                if(!(princess.getHealth()<=0))
                {
                    princess.takeDamage(dealtatime*5);

                }

            }
        }
        
        
        for(int i=0;i<orcmonster.size();i++)
        {
            if(orcmonster.get(i).getPosition().overlaps(new Rectangle(0,100,200,200)))
            {
                orcmonster.remove(i);
            }
        }
        
        //This is drawing the hitboxes
        shape.begin(ShapeRenderer.ShapeType.Line);
        
        drawingHitBox();
        
        shape.end();
        
        princess.displayHealth();
        
    }
    
    @Override
    public void resize(int width, int height) 
    {
        
    }
    
    @Override
    public void pause() 
    {
        
    }
    
    @Override
    public void resume() 
    {
        
    }
    
    @Override
    public void hide() 
    {
        
    }
    
    @Override
    public void dispose() 
    {
        
    }
    
    //Checking none of the movement keys are pressed
    public boolean nothingPressed()
    {
        //False means that there is something pressed
        boolean output=false;
        
        if(!(Gdx.input.isKeyPressed(Input.Keys.UP)||Gdx.input.isKeyPressed(Input.Keys.DOWN)||Gdx.input.isKeyPressed(Input.Keys.LEFT)||Gdx.input.isKeyPressed(Input.Keys.RIGHT)))
        {
            //This means that none of the movement keys are pressed thus the output is true that nothing is pressed
            output=true;
        }
        
        return output;
    }
    
    //Putting all the things that handles the drawing for the character here
    public void handleDrawingCharacter(float dealtatime)
    {
        //This means that the user is holding down the left button so we have to move the character to the left
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            if(princess.position.x+18.5>=0)
            {
                princess.position.x-=200*dealtatime;
                counter=2;
            }
        }
        
        //Finally this means that the user is holding down the right button thus we have to move the chracter to the right
        
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            if(princess.position.x+45.5<=800)
            {
                princess.position.x+=200*dealtatime;
                counter=3;
            }
        }

        //This means that the user is holding down the up button so we have to move the character up
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if(princess.position.y+50<=800)
            {
                princess.position.y+=200*dealtatime;
                counter=0;
            }
        }

        //This means that the user is holding down the down button so we have to move the character down
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            if(princess.position.y>=0)
            {
                princess.position.y-=200*dealtatime;
                counter=1;
            }
        }
        
        //This means that the user is holding down the left button and shift so we have to move the character to the left
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&&Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
        {
             if(princess.position.x+18.5>=0)
            {
                princess.position.x-=300*dealtatime;
                counter=2;
            }
        }
        
        //Finally this means that the user is holding down the right button and shift thus we have to move the chracter to the right
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
        {
            if(princess.position.x+45.5<=800)
            {
                princess.position.x+=300*dealtatime;
                counter=3;
            }
        }
        //This means that the user is holding down the up button and shift so we have to move the character up
        if(Gdx.input.isKeyPressed(Input.Keys.UP)&&Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
        {
            if(princess.position.y+50<=800)
            {
                princess.position.y+=300*dealtatime;
                counter=0;
            }
        }
        //This means that the user is holding down the down button and shift so we have to move the character down
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
        {
            if(princess.position.y>=0)
            {
                princess.position.y-=300*dealtatime;
                counter=1;
            }
        }
        
        if(nothingPressed())
        {
            if(counter==1)
            {
                batch.draw(princess.down, princess.position.x, princess.position.y);
            }
            else if(counter==0)
            {
                batch.draw(princess.up, princess.position.x, princess.position.y);
            }
            else if(counter==2)
            {
                batch.draw(princess.left, princess.position.x, princess.position.y);
            }
            else if(counter==3)
            {
                batch.draw(princess.right, princess.position.x, princess.position.y);
            }
        }
        else
        {
            if(counter==1)
            {
                batch.draw(princess.getWalkAniDown().getKeyFrame(forCorrectDrawing,true),princess.position.x,princess.position.y);
            }
            else if(counter==0)
            {
                batch.draw(princess.getWalkAniUp().getKeyFrame(forCorrectDrawing, true),princess.position.x,princess.position.y);
            }
            else if(counter==2)
            {
                batch.draw(princess.getWalkAniLeft().getKeyFrame(forCorrectDrawing,true),princess.position.x,princess.position.y);
            }
            else if(counter==3)
            {
                batch.draw(princess.getWalkAniRight().getKeyFrame(forCorrectDrawing,true),princess.position.x,princess.position.y);
            }
        }
    }
    
    public void handleAllOtherButtonPress(float dealtatime)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {
            hitbox=!hitbox;
        }
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.W))
        {
            fps=!fps;
        }
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.X))
        {
            princess.setHealth(100);
        }
    }
    
    //This method will be handling drawing the activation of hit boxes
    public void drawingHitBox()
    {
        if(hitbox)
        {
            shape.rect(princess.position.x+18.5f,princess.position.y,princess.position.width,princess.position.height);
            
            for(Orc oneorc:orcmonster)
            {
                shape.rect(oneorc.getPosition().x, oneorc.getPosition().y, oneorc.getPosition().width, oneorc.getPosition().height);
            }
        }
        
    }
    
    //This method will be handling the drawing of all of the monsters
    public void handleDrawingMonster()
    {
        for(Orc oneorc:orcmonster)
        {
            TextureRegion currentKeyFrameUp=oneorc.getWalkAniUp().getKeyFrame(forCorrectDrawing,true);
            TextureRegion currentKeyFrameDown=oneorc.getWalkAniDown().getKeyFrame(forCorrectDrawing,true);
            
            //This means that the orc is going up thus we draw the animation going up
            if(oneorc.getPathFinding().getIntDirection()==0)
            {
                
                oneorc.move(princess.position);
                batch.draw(currentKeyFrameUp,oneorc.getPosition().x,oneorc.getPosition().y);
            }
            else
            {
                oneorc.move(princess.position);
                batch.draw(currentKeyFrameDown,oneorc.getPosition().x,oneorc.getPosition().y);
            }
            
        }
    }
    
    //Drawing the frame rate as requested
    public void drawFrameRate(float dealtatime)
    {
        if(framePast==44)
        {
            framePast=framePast-44;
            framerate=(int)(1/dealtatime);
            
            if(fps)
            {
                font.getData().setScale(0.9f);
                font.draw(batch, ""+framerate, 500, 800);
            }
        }
        //This means that we aren't updating the frame rate yet therefore we just draw the one we currently have in stored
        else
        {
            if(fps)
            {
                font.draw(batch, ""+framerate,500, 800);
            }
        }
    }
    
    //This method will be handling drawing the background of the game
    public void drawBackground()
    {
        Tile grass1=tiles.findTile("Grass1");
        Tile grass2=tiles.findTile("Grass2");
        Tile grass3=tiles.findTile("Grass3");
        Tile grass4=tiles.findTile("Grass4");
        Tile grass5=tiles.findTile("Grass5");
        Tile grass6=tiles.findTile("Grass6");
        Tile grass7=tiles.findTile("Grass7");
        Tile grass8=tiles.findTile("Grass8");
        Tile grass9=tiles.findTile("Grass9");
        
        Tile chest=tiles.findTile("Chest");
        
        for(int r=0;r<25;r++)
        {
            for(int c=0;c<25;c++)
            {
                //This makes sure that it have some tiles in the spot we are at before drawing
                if(layout.getLayout()[r][c]!=null)
                {
                    if(layout.getTileName(r,c).equals("Grass1"))
                    {
                        batch.draw(grass1.getTile(),c*32,768-(r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass2"))
                    {
                        batch.draw(grass2.getTile(),c*32,768-(r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass3"))
                    {
                        batch.draw(grass3.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass4"))
                    {
                        batch.draw(grass4.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass5"))
                    {
                        batch.draw(grass5.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass6"))
                    {
                        batch.draw(grass6.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass7"))
                    {
                        batch.draw(grass7.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass8"))
                    {
                        batch.draw(grass8.getTile(),c*32,(768-r*32),32,32);
                    }
                    else if(layout.getTileName(r,c).equals("Grass9"))
                    {
                        batch.draw(grass9.getTile(),c*32,(768-r*32),32,32);
                    }
                }
            }
        }
        
        for(int r=0;r<25;r++)
        {
            for(int c=0;c<25;c++)
            {
                //This makes sure that it have some tiles in the spot we are at before drawing
                if(extraBg[r][c]!=null)
                {
                    if(extraBg[r][c].equals("Chest"))
                    {
                        batch.draw(chest.getTile(),c*32,(768-r*32),32,32);
                        System.out.println("True");
                    }
                }
            }
        }
    }
}
