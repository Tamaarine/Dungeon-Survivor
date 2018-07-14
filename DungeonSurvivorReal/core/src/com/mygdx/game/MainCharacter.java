package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MainCharacter
{
    //Public instance fields
    TextureRegion left;
    TextureRegion right;
    TextureRegion up;
    TextureRegion down;
    Rectangle position;
    
    //Private instance fields
    private int health;
    private Texture characterTexture;
    
    public MainCharacter(String gender,int startingx,int startingy)
    {
        health=100;
        
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
        
        
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int givenhealth)
    {
        health=givenhealth;
    }
    
    
}