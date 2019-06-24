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

public class Paddle extends Brick

{
    public Paddle()
    {
        super();
        this.setWidth(100);
        this.setHeight(20);
        this.setColor(Color.white);
        this.setXPos(300);
        this.setYPos(700);
    }
    
    public void move( int a )
    {
        if ( xPos > 0 && xPos < 500 )
        {
            this.setXPos(a);
        }
        else if ( xPos >= 500 )
        {
            this.setXPos( 499 );
        }
        else if ( xPos <= 0 )
        {
            this.setXPos(1);
        }
    }
    
    public void drawPaddle( Graphics g )
    {
        g.setColor(Color.white);
        g.fillRect(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }
    
    public void reset()
    {
        xPos = 300;
        yPos = 700;
    }
}
