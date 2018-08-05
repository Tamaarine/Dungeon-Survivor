package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

public class TileSet
{
    private ArrayList<Tile> tiles;
    
    public TileSet()
    {
        tiles=new ArrayList<Tile>();
        
        Texture tilePng=new Texture(Gdx.files.internal("tileset.png"));
        
        //This tile set is for the grass
        TextureRegion grass1=new TextureRegion(tilePng,0,192,16,16);
        TextureRegion grass2=new TextureRegion(tilePng,16,192,16,16);
        TextureRegion grass3=new TextureRegion(tilePng,32,192,16,16);
        TextureRegion grass4=new TextureRegion(tilePng,0,208,16,16);
        TextureRegion grass5=new TextureRegion(tilePng,16,160,16,16);
        TextureRegion grass6=new TextureRegion(tilePng,32,208,16,16);
        TextureRegion grass7=new TextureRegion(tilePng,0,224,16,16);
        TextureRegion grass8=new TextureRegion(tilePng,16,224,16,16);
        TextureRegion grass9=new TextureRegion(tilePng,32,224,16,16);
        
        Tile tile1=new Tile(grass1,"Grass1");
        Tile tile2=new Tile(grass2,"Grass2");
        Tile tile3=new Tile(grass3,"Grass3");
        Tile tile4=new Tile(grass4,"Grass4");
        Tile tile5=new Tile(grass5,"Grass5");
        Tile tile6=new Tile(grass6,"Grass6");
        Tile tile7=new Tile(grass7,"Grass7");
        Tile tile8=new Tile(grass8,"Grass8");
        Tile tile9=new Tile(grass9,"Grass9");
        
        //This tile set is for treasures
        TextureRegion chest=new TextureRegion(tilePng,160,16,16,16);
        
        Tile tile10=new Tile(chest,"Chest");
        
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        tiles.add(tile4);
        tiles.add(tile5);
        tiles.add(tile6);
        tiles.add(tile7);
        tiles.add(tile8);
        tiles.add(tile9);
        tiles.add(tile10);
        
    }
    
    public Tile findTile(String desireTile)
    {
        Tile output=tiles.get(0);
        
        int length=tiles.size();
        
        for(int i=0;i<length;i++)
        {
            Tile currentTile=tiles.get(i);
            
            if(currentTile.getName().equals(desireTile))
            {
                output=currentTile;
            }
        }
        
        return output;
    }
    
    
}