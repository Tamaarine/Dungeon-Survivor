package com.mygdx.game;

public class BeginningStage extends Environment
{
    public BeginningStage()
    {
        super();
        
        String layout[][]=new String[25][25];
        
        layout[0][0]="Grass1";
        layout[0][24]="Grass3";
        layout[24][0]="Grass7";
        layout[24][24]="Grass9";
        
        for(int i=1;i<24;i++)
        {
            layout[0][i]="Grass2";
            layout[i][0]="Grass4";
            layout[24][i]="Grass8";
            layout[i][24]="Grass6";
        }
        
        for(int r=1;r<24;r++)
        {
            for(int c=1;c<24;c++)
            {
                layout[r][c]="Grass5";
            }
        }
        
        setLayout(layout);
    }
    
    
}