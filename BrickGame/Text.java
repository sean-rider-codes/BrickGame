package home03;
import java.awt.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author srider
 */

public class Text 
{
    private int numberOfLives;
    private final String gameOver = "Game Over!";
    private final boolean noLives = false;
    
    /**
     *
     */
    public void Text()
    {
        numberOfLives = 3;
    }
    
    public String getLives()
    {
         return "Lives: " + numberOfLives;       
    }
    
    public int getNumberOfLives()
    {
        return numberOfLives;
    }
    
    public void setLives( int x )
    {
        numberOfLives = x;
    }
    
    public void lifeLost()
    {
        numberOfLives = numberOfLives - 1;
    }
    
    public String getGameOver()
    {
         return gameOver;       
    }
    
    public void drawText( Graphics g )
    {
        g.drawString( this.getLives(), 10, 795 );
        if ( noLives == true )
        {
            g.setColor(Color.yellow);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString(gameOver, 225, 400);
        }
    }
    
    public void drawGameOver( Graphics g )
    {
        g.setColor(Color.yellow);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString(gameOver, 225, 400);
    }
    
    public void reset()
    {
        numberOfLives = 3;
    }
}
