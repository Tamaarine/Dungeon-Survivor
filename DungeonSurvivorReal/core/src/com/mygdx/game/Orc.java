package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
    
    public Orc(Rectangle givenposition)
    {
        super(givenposition);
        
        monsterpicture=new Texture(Gdx.files.internal("monster.png"));
        
        up=new TextureRegion(monsterpicture,0,0,64,64);
        left=new TextureRegion(monsterpicture,0,64,64,64);
        down=new TextureRegion(monsterpicture,0,128,64,64);
        right=new TextureRegion(monsterpicture,0,192,64,64);
        
    }
    
    //The move method will be called every frame within the game in order to make the orc move
    public void move(float unitperframe)
    {
        this.setPosition(this.getPosition().x+unitperframe,this.getPosition().y);
    }
}
