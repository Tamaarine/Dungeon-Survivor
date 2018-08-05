package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile
{
    private TextureRegion tile;
    private String name;
    
    public Tile(TextureRegion givenTile,String givenName)
    {
        tile=givenTile;
        name=givenName;
    }
    
    public TextureRegion getTile()
    {
        return tile;
    }
    
    public String getName()
    {
        return name;
    }
    
}