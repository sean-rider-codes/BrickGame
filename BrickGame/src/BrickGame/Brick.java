package home03;
import java.awt.Graphics;
import javax.swing.JPanel; 
import java.awt.Rectangle;
import javax.swing.JApplet;
import java.awt.*;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author srider
 */

public class Brick
{
    private boolean destroyed;
    private int width;
    private int height;
    private Color brickColor;
    int xPos;
    int yPos;
    

    public Brick() 
    {   
       width = 60;
       height = 30;
       destroyed = false;
       brickColor = Color.blue;
       xPos = 0;
       yPos = 0;
    }
    
    public Brick ( int w, int h, int x, int y, Color c)
    {
        width = w;
        height = h;
        xPos = x;
        yPos = y;
        destroyed = false;
        brickColor = c;
    }
    
    public void drawBrick( Graphics g )
    {
        g.setColor(brickColor);
        g.fillRect(xPos, yPos, width, height);
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public Color getColor()
    {
        return brickColor;
    }
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getYPos()
    {
        return yPos;
    }
    
    Rectangle getRect()
    {
      return new Rectangle( xPos, yPos, width, height );
    }
    
    public boolean isDestroyed()
    {
        return destroyed;
    }
    
    public void setWidth( int w )
    {
        width = w;
    }
    
    public void setHeight ( int h )
    {
        height = h;
    }
    
    public void setColor ( Color c )
    {
        brickColor = c;
    }
    
    public void destroy()
    {
        destroyed = true;
        brickColor = Color.black;
    }
    
    public void setXPos( int x )
    {
        xPos = x;
    }
    
    public void setYPos( int y )
    {
        yPos = y;
    }
    
    public void resetBricks()
    {
        destroyed = false;
    }
    
    
    
    
}
