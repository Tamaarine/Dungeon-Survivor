package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;


public class IntroScreen implements Screen
{
    private DungeonSurvivor game;
    private OrthographicCamera camera;
    private Texture startpicture;
    private SpriteBatch batch;
    private Texture intro;
    private Texture[] start;
    private Texture[] quit;
    
    //Music
    private Music intromusic;
    
    private boolean moveon;
    private boolean quitgame;
    
    
    public IntroScreen(DungeonSurvivor game)
    {
        this.game=game;
        batch=new SpriteBatch();
        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,800);
        startpicture=new Texture(Gdx.files.internal("title.png"));
        intro=new Texture(Gdx.files.internal("Image/gametitle.png"));
        intromusic=Gdx.audio.newMusic(Gdx.files.internal("Music/monster.mp3"));
        
        start=new Texture[2];
        quit=new Texture[2];
        
        //Unrpessed:190 x 49
        //Pressed 190 x 45
        start[0]=new Texture(Gdx.files.internal("Image/startunpressed.png"));
        start[1]=new Texture(Gdx.files.internal("image/startpressed.png"));
        quit[0]=new Texture(Gdx.files.internal("Image/quitunpressed.png"));
        quit[1]=new Texture(Gdx.files.internal("Image/quitpressed.png"));
        
        intromusic.play();
        intromusic.setLooping(true);
        
        moveon=false;
        quitgame=false;
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float f) 
    {
        moveOn();
        quit();
        
        Gdx.gl.glClearColor(0, 0,0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        
        batch.begin();
        
        //Drawings goes between these two lines
        batch.draw(intro,0,0);
        batch.draw(startpicture,0,1000);
        
        if((Gdx.input.getX()>305&&Gdx.input.getX()<305+190)&&(Gdx.input.getY()>375&&Gdx.input.getY()<375+49)&&Gdx.input.justTouched())
        {
            batch.draw(start[1],800/2-190/2,800/2-49/2);
            moveon=true;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
        {
            batch.draw(start[1],800/2-190/2,800/2-49/2);
            moveon=true;
        }
        else
        {
            batch.draw(start[0],800/2-190/2,800/2-49/2);
        }
        
        if((Gdx.input.getX()>305&&Gdx.input.getX()<305+190)&&(Gdx.input.getY()>434&&Gdx.input.getY()<434+49)&&Gdx.input.justTouched())
        {
            batch.draw(quit[1],800/2-190/2,317);
            quitgame=true;
        }
        else
        {
            batch.draw(quit[0],800/2-190/2,317);
            
        }
        
        //Orc orc=new Orc(new Rectangle(0,0,64,64));
        MainCharacter prince=new MainCharacter("Charaa",0,0);
        batch.draw(prince.down,0,0,128,128);
        
        batch.end();
        
    }

    public void moveOn()
    {
        if(moveon)
        {
            game.setScreen(new GameScreen(game));
            intromusic.stop();
        }
    }
    
    public void quit()
    {
        if(quitgame)
        {
            System.exit(0);
        }
    }
    
    @Override
    public void resize(int i, int i1) {
       
    }

    @Override
    public void pause() {
       
    }

    @Override
    public void resume() {
       
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void dispose() 
    {
        intromusic.dispose();
        intro.dispose();
        
        for(Texture texture:quit)
        {
            texture.dispose();
        }
        
        for(Texture texture:start)
        {
            texture.dispose();
        }
        
        startpicture.dispose();
        
        
        
    }
    
    
}