package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import RequiredThings.HealthBar;

public class MainCharacter
{
    //Public instance fields
    public TextureRegion left;
    public TextureRegion right;
    public TextureRegion up;
    public TextureRegion down;
    public Rectangle position;
    Animation WalkAniUp;
    Animation WalkAniDown;
    Animation WalkAniLeft;
    Animation WalkAniRight;
    
    //Private instance fields
    private HealthBar health;
    private Texture characterTexture;
    
    public MainCharacter(String gender,int startingx,int startingy)
    {
        health=new HealthBar(100);
        
        characterTexture=new Texture(Gdx.files.internal("princess.png"));
        up=new TextureRegion(characterTexture,0,0,64,64);
        left=new TextureRegion(characterTexture,0,64,64,64);
        down=new TextureRegion(characterTexture,0,128,64,64);
        right=new TextureRegion(characterTexture,0,192,64,64);
        
        position=new Rectangle();
        position.height=50;
        position.width=27;
        position.x=startingx;
        position.y=startingy;
        
        TextureRegion[] framesup=new TextureRegion[9];
        framesup[0]=new TextureRegion(characterTexture,0,512,64,64);
        framesup[1]=new TextureRegion(characterTexture,64,512,64,64);
        framesup[2]=new TextureRegion(characterTexture,128,512,64,64);
        framesup[3]=new TextureRegion(characterTexture,192,512,64,64);
        framesup[4]=new TextureRegion(characterTexture,256,512,64,64);
        framesup[5]=new TextureRegion(characterTexture,320,512,64,64);
        framesup[6]=new TextureRegion(characterTexture,384,512,64,64);
        framesup[7]=new TextureRegion(characterTexture,448,512,64,64);
        framesup[8]=new TextureRegion(characterTexture,512,512,64,64);
        WalkAniUp=new Animation<TextureRegion>(0.11f,framesup);
        
        TextureRegion[] framesleft=new TextureRegion[9];
        framesleft[0]=new TextureRegion(characterTexture,0,576,64,64);
        framesleft[1]=new TextureRegion(characterTexture,64,576,64,64);
        framesleft[2]=new TextureRegion(characterTexture,128,576,64,64);
        framesleft[3]=new TextureRegion(characterTexture,192,576,64,64);
        framesleft[4]=new TextureRegion(characterTexture,256,576,64,64);
        framesleft[5]=new TextureRegion(characterTexture,320,576,64,64);
        framesleft[6]=new TextureRegion(characterTexture,384,576,64,64);
        framesleft[7]=new TextureRegion(characterTexture,448,576,64,64);
        framesleft[8]=new TextureRegion(characterTexture,512,576,64,64);
        WalkAniLeft=new Animation<TextureRegion>(0.11f,framesleft);
        
        TextureRegion[] framesright=new TextureRegion[9];
        framesright[0]=new TextureRegion(characterTexture,0,704,64,64);
        framesright[1]=new TextureRegion(characterTexture,64,704,64,64);
        framesright[2]=new TextureRegion(characterTexture,128,704,64,64);
        framesright[3]=new TextureRegion(characterTexture,192,704,64,64);
        framesright[4]=new TextureRegion(characterTexture,256,704,64,64);
        framesright[5]=new TextureRegion(characterTexture,320,704,64,64);
        framesright[6]=new TextureRegion(characterTexture,384,704,64,64);
        framesright[7]=new TextureRegion(characterTexture,448,704,64,64);
        framesright[8]=new TextureRegion(characterTexture,512,704,64,64);
        WalkAniRight=new Animation<TextureRegion>(0.11f,framesright);
        
        TextureRegion[] framesdown=new TextureRegion[9];
        framesdown[0]=new TextureRegion(characterTexture,0,640,64,64);
        framesdown[1]=new TextureRegion(characterTexture,64,640,64,64);
        framesdown[2]=new TextureRegion(characterTexture,128,640,64,64);
        framesdown[3]=new TextureRegion(characterTexture,192,640,64,64);
        framesdown[4]=new TextureRegion(characterTexture,256,640,64,64);
        framesdown[5]=new TextureRegion(characterTexture,320,640,64,64);
        framesdown[6]=new TextureRegion(characterTexture,384,640,64,64);
        framesdown[7]=new TextureRegion(characterTexture,448,640,64,64);
        framesdown[8]=new TextureRegion(characterTexture,512,640,64,64);
        WalkAniDown=new Animation<TextureRegion>(0.11f,framesdown);
        
        WalkAniUp.setPlayMode(PlayMode.NORMAL);
        WalkAniDown.setPlayMode(PlayMode.NORMAL);
        WalkAniLeft.setPlayMode(PlayMode.NORMAL);
        WalkAniRight.setPlayMode(PlayMode.NORMAL);
    }
    
    public void setHealth(int givenHealth)
    {
        health.setHealth(givenHealth);
    }
    
    public void displayHealth()
    {
        health.displayHealth();
    }
    
    public void takeDamage(float damageOverFrame)
    {
        health.setHealth(health.getHealth()-damageOverFrame);
    }
    
    public float getHealth()
    {
        return health.getHealth();
    }
    
    public Animation<TextureRegion> getWalkAniUp()
    {
        return WalkAniUp;
    }
    
    public Animation<TextureRegion> getWalkAniDown()
    {
        return WalkAniDown;
    }
    
    public Animation<TextureRegion> getWalkAniLeft()
    {
        return WalkAniLeft;
    }
    
    public Animation<TextureRegion> getWalkAniRight()
    {
        return WalkAniRight;
    }
    
}