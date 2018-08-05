package RequiredThings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Disposable;

public class HealthBar implements Disposable
{
    //Necessary objects
    OrthographicCamera camera;
    SpriteBatch batch;
    BitmapFont font;
    ShapeRenderer shaper;
    
    private float health;
    
    
    public HealthBar(float givenHealth)
    {
        batch=new SpriteBatch();
        font=new BitmapFont(Gdx.files.internal("Font/goodfont.fnt"));
        camera=new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        shaper=new ShapeRenderer();
        
        health=givenHealth;
        
    }
    
    //This method will be responsible for drawing the Health bar
    public void displayHealth()
    {
        shaper.begin(ShapeType.Filled);
        //Drawing shape goes between here
        shaper.setColor(Color.RED);
        shaper.rect(0,750, health*2, 50);
        
        shaper.end();
        
        batch.begin();
        //Drawing goes between here
        font.draw(batch, ""+(int)(health),50, 800);
        
        
        
        batch.end();
        
        
        
        
    }
    
    
    //Accessor methods
    public float getHealth()
    {
        return health;
    }
    
    //Mutator methods
    public void setHealth(float givenHealth)
    {
        health=givenHealth;
    }
    
    
    
    
    @Override
    public void dispose() 
    {
        
    }
    
    
}