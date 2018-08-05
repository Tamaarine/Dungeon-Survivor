package RequiredThings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class PathFindingSystem
{
    private Rectangle mylocation;
    private int unitPerSecond;
    private int intdirection;
    
    
    public PathFindingSystem(Rectangle givenmylocation,int givenVelocity)
    {
        mylocation=givenmylocation;
        unitPerSecond=givenVelocity;
        intdirection=0;
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
        
        //This means that the monster is literally on top of the player thus we don't do anything
        if(!(isWithinTolerableRangeX(targetLocation)||isWithinTolerableRangeY(targetLocation)))
        {
            //Case 1
            if(myX>targetX&&myY<targetY)
            {
                //This case we decrease x and increase y
                mylocation.x-=deltaTime*unitPerSecond;
                mylocation.y+=deltaTime*unitPerSecond;
                intdirection=0;
            }
            //Case 2
            else if(myX<targetX&&myY<targetY)
            {
                //This case we increase x and increase y
                mylocation.x+=deltaTime*unitPerSecond;
                mylocation.y+=deltaTime*unitPerSecond;
                intdirection=0;
            }
            //Case 3
            else if(myX>targetX&&myY>targetY)
            {
                //This case we decrease x and y
                mylocation.x-=deltaTime*unitPerSecond;
                mylocation.y-=deltaTime*unitPerSecond;
                intdirection=1;
            }
            //Case 4
            else if(myX<targetX&&myY>targetY)
            {
                //This case we eincrease x and decrease y
                mylocation.x+=deltaTime*unitPerSecond;
                mylocation.y-=deltaTime*unitPerSecond;
                intdirection=1;
            }
        }
        else if(isWithinTolerableRangeX(targetLocation)&&isWithinTolerableRangeY(targetLocation))
        {
            return;
        }
        //This means that in the x-axis is within tolerable range therefore we either only move up or down
        else if(isWithinTolerableRangeX(targetLocation))
        {
            //Case 1
            if(myY<targetY)
            {
                mylocation.y+=deltaTime*unitPerSecond;
            }
            //Case 2
            else if(myY>targetY)
            {
                mylocation.y-=deltaTime*unitPerSecond;
            }
        }
        //Then this means that in the y-axis it is within tolerable range already thus we only move left or right
        else if(isWithinTolerableRangeY(targetLocation))
        {
            //Case 1
            if(myX>targetX)
            {
                mylocation.x-=deltaTime*unitPerSecond;
            }
            else if(myX<targetX)
            {
                mylocation.x+=deltaTime*unitPerSecond;
            }
            
            System.out.println("Tolerable");
        }
        
        
    }
    
    public int getIntDirection()
    {
        return intdirection;
    }
    
    public boolean isWithinTolerableRangeX(Rectangle targetLocation)
    {
        boolean output=false;
        
        float myX=mylocation.x;
        float targetX=targetLocation.x;
        
        if(Math.abs(myX-targetX)<=0.5)
        {
            output=true;
        }
        
        return output;
        
    }
    
    public boolean isWithinTolerableRangeY(Rectangle targetLocation)
    {
        boolean output=false;
        
        float myY=mylocation.y;
        float targetY=targetLocation.y;
        
        if(Math.abs(myY-targetY)<=0.5)
        {
            output=true;
        }
        
        return output;
    }
}