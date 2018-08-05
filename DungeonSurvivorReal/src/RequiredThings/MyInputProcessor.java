package RequiredThings;

import Actors.MainCharacter;
import Actors.Orc;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class MyInputProcessor implements InputProcessor
{
    MainCharacter princess;
    float dealtatime;
    Sound oof;
    ArrayList<Orc> orcmonster;
    
    public MyInputProcessor(MainCharacter givenPrincess,float givenDealta,Sound givenSound,ArrayList<Orc> orcmonsters)
    {
        princess=givenPrincess;
        dealtatime=givenDealta;
        oof=givenSound;
        orcmonster=orcmonsters;
    }
    
    public boolean keyDown(int keycode)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z))
        {
            if(!(princess.getHealth()<=0))
            {
                princess.takeDamage(dealtatime*100);
                oof.play();
            }
        }
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.C))
        {
            //I want to generate up to 4 orcs each time
            for(int i=0;i<4;i++)
            {
                int randomx=(int)(Math.random()*737);
                int randomy=(int)(Math.random()*737);
                
                int randomspeed=(int)(Math.random()*201+50);
                
                orcmonster.add(new Orc(new Rectangle(randomx,randomy,64,64),randomspeed));
            }
            

        }
        
        return true;
    }
    
    public boolean keyUp(int keycode)
    {
        return false;
    }
    
    public boolean keyTyped(char character)
    {
        return false;
    }
    
    public boolean touchDown(int x,int y,int pointer,int button)
    {
        return false;
    }
    
    public boolean touchUp(int x,int y,int pointer,int button)
    {
        return false;
    }
    
    public boolean touchDragged(int x,int y,int pointer)
    {
        return false;
    }
    
    public boolean mouseMoved(int x,int y)
    {
        return false;
    }
    
    public boolean scrolled(int amount)
    {
        return false;
    }
    
}