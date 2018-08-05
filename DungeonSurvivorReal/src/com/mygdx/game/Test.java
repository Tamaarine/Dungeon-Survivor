package com.mygdx.game;

import Actors.MainCharacter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends Game
{
    SpriteBatch batch;
    MainCharacter princess;
    OrthographicCamera camera;

    @Override
    public void create() 
    {
       camera=new OrthographicCamera();
        batch=new SpriteBatch();
        princess=new MainCharacter("Chara",0,0);
        camera.setToOrtho(false,800,800);
    }
    
    public void render()
    {
        Gdx.gl.glClearColor(0, 0,0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        float dealtatime=Gdx.graphics.getDeltaTime();
        
        batch.begin();
        //This means that the user is holding down the left button so we have to move the character to the left
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            if(princess.position.x+18.5>=0)
            {
                princess.position.x-=200*dealtatime;
            }
        }
        //Finally this means that the user is holding down the right button thus we have to move the chracter to the right
        
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            if(princess.position.x+45.5<=800)
            {
                princess.position.x+=200*dealtatime;
            }
        }
        //This means that the user is holding down the up button so we have to move the character up
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            if(princess.position.y+50<=800)
            {
                princess.position.y+=200*dealtatime;
            }
        }
        //This means that the user is holding down the down button so we have to move the character down
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            if(princess.position.y>=0)
            {
                princess.position.y-=200*dealtatime;
            }
        }
        
        batch.draw(princess.down,princess.position.x,princess.position.y);
        batch.end();
    }
}