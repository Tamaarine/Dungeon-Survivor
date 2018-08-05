package com.mygdx.game;

public abstract class Environment
{
    private String layout[][];
    
    public Environment()
    {
        layout=new String[25][25];
    }
    
    public String getTileName(int row,int col)
    {
        return layout[row][col];
    }
    
    public void setLayout(String givenLayout[][])
    {
        layout=givenLayout;
    }
    
    public String[][] getLayout()
    {
        return layout;
    }
}
