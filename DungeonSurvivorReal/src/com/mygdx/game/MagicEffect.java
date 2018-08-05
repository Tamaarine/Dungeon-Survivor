package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MagicEffect
{
    private static Animation<TextureRegion> blueFlame;
    private static Animation fireSpin;
    
    public MagicEffect()
    {
        Texture blueFlameTemp=new Texture(Gdx.files.internal("blueflame.png"));
        Texture fireSpinTemp=new Texture(Gdx.files.internal("firespin.png"));
        
        TextureRegion blueFlameTemp2[][]=TextureRegion.split(blueFlameTemp, blueFlameTemp.getWidth()/7, blueFlameTemp.getHeight()/7);
        System.out.println("The number of col is "+blueFlameTemp2[0].length);
        System.out.println("The number of row is "+blueFlameTemp2.length);
        
        
        TextureRegion blueFlameFrame[]=new TextureRegion[49];
        int blueFlameCounter=0;
        
        for(int r=0;r<7;r++)
        {
            for(int c=0;c<7;c++)
            {
                blueFlameFrame[blueFlameCounter]=blueFlameTemp2[r][c];
                
                blueFlameCounter++;
            }
        }
        
        blueFlame=new Animation<TextureRegion>(1/49f,blueFlameFrame);
        
        TextureRegion fireSpinTemp2[][]=TextureRegion.split(fireSpinTemp, fireSpinTemp.getWidth()/8, fireSpinTemp.getHeight()/8);
        
        TextureRegion fireSpinFrame[]=new TextureRegion[64];
        int fireSpinCounter=0;
        
        for(int r=0;r<8;r++)
        {
            for(int c=0;c<8;c++)
            {
                fireSpinFrame[fireSpinCounter]=fireSpinTemp2[r][c];
                
                fireSpinCounter++;
            }
        }
        
        fireSpin=new Animation<TextureRegion>(1/64f,fireSpinFrame);
        
        
        
    }
    
    public Animation<TextureRegion> getBlueFlameAni()
    {
        return blueFlame;
    }
    
    public Animation<TextureRegion> getFireSpinAni()
    {
        return fireSpin;
    }
    
    
    
    
    
    
    
    
    
}