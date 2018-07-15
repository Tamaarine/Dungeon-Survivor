package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Monster
{
    private Rectangle position;
    private int health;
    private PathFindingSystem pathfinding;
    
    public Monster(Rectangle givenPosition,int givenVelocity)
    {
        position=givenPosition;
        health=100;
        pathfinding=new PathFindingSystem(givenPosition,givenVelocity);
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int givenhealth)
    {
        health=givenhealth;
    }
    
    public Rectangle getPosition()
    {
        return position;
    }
    
    public void setPosition(float givenx,float giveny)
    {
        position.x=givenx;
        position.y=giveny;
    }
    
    public void move(Rectangle targetlocation)
    {
        pathfinding.getClose(targetlocation);
    }
            
    
}