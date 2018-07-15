package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class PathFindingSystem
{
    private Rectangle mylocation;
    private int unitPerSecond;
    
    public PathFindingSystem(Rectangle givenmylocation,int givenVelocity)
    {
        mylocation=givenmylocation;
        unitPerSecond=givenVelocity;
        
    }
    
    //This is where the hard work of finding location and moving will be
    public void getClose(Rectangle targetLocation)
    {
        //Getting the delta time
        float deltaTime=Gdx.graphics.getDeltaTime();
        
        float myX=mylocation.x;
        float myY=mylocation.y;
        
        float targetX=targetLocation.x;
        float targetY=targetLocation.y;
        
        //Case 1
        if(myX>targetX&&myY<targetY)
        {
            //This case we decrease x and increase y
            mylocation.x-=deltaTime*unitPerSecond;
            mylocation.y+=deltaTime*unitPerSecond;
        }
        else if(myX<targetX&&myY<targetY)
        {
            //This case we increase x and increase y
            mylocation.x+=deltaTime*unitPerSecond;
            mylocation.y+=deltaTime*unitPerSecond;
        }
        else if(myX>targetX&&myY>targetY)
        {
            //This case we decrease x and y
            mylocation.x-=deltaTime*unitPerSecond;
            mylocation.y-=deltaTime*unitPerSecond;
        }
        else if(myX<targetX&&myY>targetY)
        {
            //This case we eincrease x and decrease y
            mylocation.x+=deltaTime*unitPerSecond;
            mylocation.y-=deltaTime*unitPerSecond;
        }
        
        
        
        
    }
}