package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Orc extends Monster
{
    //Private instance fields
    private Texture monsterpicture;
    
    //Public instance fields
    TextureRegion up;
    TextureRegion down;
    TextureRegion left;
    TextureRegion right;
    
    //Private instance fields
    private Animation<TextureRegion> WalkAniDown;
    private Animation<TextureRegion> WalkAniUp;
    private Animation<TextureRegion> WalkAniLeft;
    private Animation<TextureRegion> WalkAniRight;
    
    public Orc(Rectangle givenposition,int givenVelocity)
    {
        super(givenposition,givenVelocity);
        
        monsterpicture=new Texture(Gdx.files.internal("monster.png"));
        
        up=new TextureRegion(monsterpicture,0,0,64,64);
        left=new TextureRegion(monsterpicture,0,64,64,64);
        down=new TextureRegion(monsterpicture,0,128,64,64);
        right=new TextureRegion(monsterpicture,0,192,64,64);
        
        TextureRegion[] framesup=new TextureRegion[9];
        framesup[0]=new TextureRegion(monsterpicture,0,512,64,64);
        framesup[1]=new TextureRegion(monsterpicture,64,512,64,64);
        framesup[2]=new TextureRegion(monsterpicture,128,512,64,64);
        framesup[3]=new TextureRegion(monsterpicture,192,512,64,64);
        framesup[4]=new TextureRegion(monsterpicture,256,512,64,64);
        framesup[5]=new TextureRegion(monsterpicture,320,512,64,64);
        framesup[6]=new TextureRegion(monsterpicture,384,512,64,64);
        framesup[7]=new TextureRegion(monsterpicture,448,512,64,64);
        framesup[8]=new TextureRegion(monsterpicture,512,512,64,64);
        WalkAniUp=new Animation<TextureRegion>(0.11f,framesup);
        
        TextureRegion[] framesleft=new TextureRegion[9];
        framesleft[0]=new TextureRegion(monsterpicture,0,576,64,64);
        framesleft[1]=new TextureRegion(monsterpicture,64,576,64,64);
        framesleft[2]=new TextureRegion(monsterpicture,128,576,64,64);
        framesleft[3]=new TextureRegion(monsterpicture,192,576,64,64);
        framesleft[4]=new TextureRegion(monsterpicture,256,576,64,64);
        framesleft[5]=new TextureRegion(monsterpicture,320,576,64,64);
        framesleft[6]=new TextureRegion(monsterpicture,384,576,64,64);
        framesleft[7]=new TextureRegion(monsterpicture,448,576,64,64);
        framesleft[8]=new TextureRegion(monsterpicture,512,576,64,64);
        WalkAniLeft=new Animation<TextureRegion>(0.11f,framesleft);
        
        TextureRegion[] framesright=new TextureRegion[9];
        framesright[0]=new TextureRegion(monsterpicture,0,704,64,64);
        framesright[1]=new TextureRegion(monsterpicture,64,704,64,64);
        framesright[2]=new TextureRegion(monsterpicture,128,704,64,64);
        framesright[3]=new TextureRegion(monsterpicture,192,704,64,64);
        framesright[4]=new TextureRegion(monsterpicture,256,704,64,64);
        framesright[5]=new TextureRegion(monsterpicture,320,704,64,64);
        framesright[6]=new TextureRegion(monsterpicture,384,704,64,64);
        framesright[7]=new TextureRegion(monsterpicture,448,704,64,64);
        framesright[8]=new TextureRegion(monsterpicture,512,704,64,64);
        WalkAniRight=new Animation<TextureRegion>(0.11f,framesright);
        
        TextureRegion[] framesdown=new TextureRegion[9];
        framesdown[0]=new TextureRegion(monsterpicture,0,640,64,64);
        framesdown[1]=new TextureRegion(monsterpicture,64,640,64,64);
        framesdown[2]=new TextureRegion(monsterpicture,128,640,64,64);
        framesdown[3]=new TextureRegion(monsterpicture,192,640,64,64);
        framesdown[4]=new TextureRegion(monsterpicture,256,640,64,64);
        framesdown[5]=new TextureRegion(monsterpicture,320,640,64,64);
        framesdown[6]=new TextureRegion(monsterpicture,384,640,64,64);
        framesdown[7]=new TextureRegion(monsterpicture,448,640,64,64);
        framesdown[8]=new TextureRegion(monsterpicture,512,640,64,64);
        WalkAniDown=new Animation<TextureRegion>(0.11f,framesdown);
    }
    
    //The move method will be called every frame within the game in order to make the orc move
    public void move(float unitperframe)
    {
        this.setPosition(this.getPosition().x+unitperframe,this.getPosition().y);
    }
    
    //Accessor methods
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
