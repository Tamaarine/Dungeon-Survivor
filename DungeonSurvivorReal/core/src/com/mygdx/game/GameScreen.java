package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;

public class GameScreen implements Screen {
    //Required varaible
    DungeonSurvivor game;
    SpriteBatch batch;
    OrthographicCamera camera;
    BitmapFont font;
    ShapeRenderer shape;
    
    //Counters
    int counter;
    int framePast;
    int framerate;
    
    //Characters
    MainCharacter princess;
    Orc orcmonster[];
    
    //Textures
    private Texture bg1;
    private Texture bg2;
    
    //Toggle booleans
    private boolean hitbox;
    private boolean fps;
    
    //Orc frame time counter
    float forCorrectDrawing;
    
    public GameScreen(DungeonSurvivor game) {
        this.game = game;
        princess = new MainCharacter("Chara",0,0);
        batch = game.batch;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,800);
        counter=0;
        orcmonster=new Orc[4];
        shape=new ShapeRenderer();
        font=new BitmapFont(Gdx.files.internal("Font/verdana72.fnt"));
        framePast=28;
        framerate=(int)(1/Gdx.graphics.getDeltaTime());
        forCorrectDrawing=0;
        
        //Instantiating textures
        bg1=new Texture(Gdx.files.internal("Image/bg1.png"));
        bg2=new Texture(Gdx.files.internal("Image/bg2.jpg"));
        
        hitbox=false;
        fps=false;
        
        orcmonster[0]=new Orc(new Rectangle(50,34,64,64),35);
        orcmonster[1]=new Orc(new Rectangle(150,34,64,64),80);
        orcmonster[2]=new Orc(new Rectangle(250,34,64,64),60);
        orcmonster[3]=new Orc(new Rectangle(350,34,64,64),90);
        
        
    }
    
    @Override
    public void show() 
    {
        
    }
    
    @Override
    public void render(float delta) 
    {
        //Gdx.gl.glClearColor(0, 0,0.2f, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //Getting the delta time
        float dealtatime=Gdx.graphics.getDeltaTime();
        forCorrectDrawing+=dealtatime;
        
        //This means that a frame have pasted
        framePast=framePast+1;
        
        //Updating the camera
        camera.update();
        
        batch.begin();
        
        //Drawing goes here
        
        //Drawing the background of the game
        batch.draw(bg2,0,0,800,800);
        
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
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {
            hitbox=!hitbox;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W))
        {
            fps=!fps;
        }
        
        if(counter==0)
        {
            batch.draw(princess.up,princess.position.x,princess.position.y);
        }
        else if(counter==1)
        {
            batch.draw(princess.down,princess.position.x,princess.position.y);
        }
        else if(counter==2)
        {
            batch.draw(princess.left,princess.position.x,princess.position.y);
        }
        else if(counter==3)
        {
            batch.draw(princess.right,princess.position.x,princess.position.y);
        }
        
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
        
        if(princess.position.overlaps(orcmonster[0].getPosition()))
        {
            System.out.println("BOOPM THE PRINCESS GETS MURDERED");
            princess.takeDamage(dealtatime*5);
        }
        
        //Drawing out the frame rate here, and it repeats every 30 frame or half a second updating the frame rate
        if(framePast==29)
        {
            framePast=framePast-59;
            framerate=(int)(1/dealtatime);
            font.getData().setScale(0.9f);
            font.draw(batch, ""+framerate, 500, 800);
            
        }
        //This means that we aren't updating the frame rate yet therefore we just draw the one we currently have in stored
        else
        {
            font.draw(batch, ""+framerate,500, 800);
        }
        
        
        batch.end();
        
        shape.begin(ShapeRenderer.ShapeType.Line);
        
        if(hitbox)
        {
            shape.rect(princess.position.x+18.5f,princess.position.y,princess.position.width,princess.position.height);
            
            for(Orc oneorc:orcmonster)
            {
                shape.rect(oneorc.getPosition().x, oneorc.getPosition().y, oneorc.getPosition().width, oneorc.getPosition().height);
            }
        }
        
        shape.end();
        
        princess.displayHealth();
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z))
        {
            if(!(princess.getHealth()<0))
            {
                princess.takeDamage(dealtatime*5);
            }
            
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.X))
        {
            System.out.println("X is pressed");
        }
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
}
