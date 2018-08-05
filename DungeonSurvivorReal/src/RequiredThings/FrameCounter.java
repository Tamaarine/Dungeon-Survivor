//Class is not gonna be used

package RequiredThings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class FrameCounter implements Disposable
{
    SpriteBatch batch;
    BitmapFont font;
    OrthographicCamera camera;
    int counter;
    
    public FrameCounter()
    {
        batch=new SpriteBatch();
        font=new BitmapFont();
        camera=new OrthographicCamera();
        camera.setToOrtho(false,800,800);
        counter=0;
        
    }
    
    public void render()
    {
        //Getting deltatime and changing it to fps
        float deltatime=Gdx.graphics.getDeltaTime();
        int fps=(int)(1/deltatime);
        
        counter++;
        
        //This means to update the frame rate display
        if(counter==60)
        {
            //This clears the old frame rate display and then drawing the new one
            //Gdx.gl.glClearColor(0, 0,0.2f, 1);
            //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.begin();
            font.setColor(Color.GOLD);
            font.draw(batch,""+fps,0,800);
            batch.end();
            
            counter-=60;
            
            System.out.println("This is working");
        }
        else
        {
            System.out.println("Nothing should go here");
        }
        
       
    }
    
    
    @Override
    public void dispose() 
    {
        font.dispose();
        batch.dispose();
    }
    
}