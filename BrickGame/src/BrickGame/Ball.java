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

public class Ball extends Brick
{
    private int xdir;
    private int ydir;
    private boolean isMoving;
    
    public Ball()
    {
        super();
        this.setWidth(20);
        this.setHeight(20);
        this.setColor(Color.white);
        this.setXPos(300);
        this.setYPos(500);
        xdir = 0;
        ydir = 0;
        isMoving = true;
    }
    
    public void drawBall( Graphics g )
    {
        g.setColor(Color.white);
        g.fillOval(this.getXPos(), this.getYPos(), this.getWidth(), this.getHeight());
    }
    
    public void toggleBallMotion( boolean b )
    {
        isMoving = b;
    }
    
    public boolean getIsMoving()
    {
        return isMoving;
    }
    
    public void move( Text t )
    {
            if ( xdir == 0 && ydir == 0)
            {
                isMoving = false;
            }
            
            else
            {
                isMoving = true;
            }
            
            xPos += xdir;
            yPos += ydir;
        
            if ( xPos <= 0 ) 
            {
                setXDir(3);
            }

            if ( xPos >= 590 ) 
            {
                setXDir(-3);
            }

            if ( yPos <= 0 ) 
            {
                setYDir(3);
            }
            
            if ( yPos >= 790 )
            {
                xPos = 300;
                yPos = 500;
                xdir = 0;
                ydir = 0;
                t.lifeLost();
            }
    }
    
    public void checkCollisions( Paddle p, Brick[] b )
    {
        if (( this.getRect()).intersects(p.getRect())) 
        {
            int paddleLeft = (int)p.getRect().getMinX();
            
            int ballLeft = (int)this.getRect().getMinX();

            int LeftSide = paddleLeft + 33;
            
            int RightSide = paddleLeft + 66;

            if (ballLeft < LeftSide) 
            {
                this.setXDir(-1);
                this.setYDir(-2);
            }

            else if (ballLeft >= LeftSide && ballLeft < RightSide) 
            {
                this.setXDir(0);
                this.setYDir(-2);
            }

            else if (ballLeft >= RightSide ) 
            {
                this.setXDir(1);
                this.setYDir(-2);
            }
        }
        
        for (int i = 0; i < 10; i++) 
        {
            if ((this.getRect()).intersects(b[i].getRect())) 
            {
                int ballLeft = (int)this.getRect().getMinX();
                
                int ballHeight = (int)this.getRect().getHeight();
                
                int ballWidth = (int)this.getRect().getWidth();
                
                int ballTop = (int)this.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                
                Point pointTop = new Point(ballLeft, ballTop - 1);
                
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!b[i].isDestroyed()) 
                {
                    if (b[i].getRect().contains(pointRight)) 
                    {
                        this.setXDir(-1 + this.getXDir());
                    }

                    else if (b[i].getRect().contains(pointLeft)) 
                    {
                        this.setXDir(1 + this.getXDir());
                    }

                    if (b[i].getRect().contains(pointTop)) 
                    {
                        this.setYDir(2);
                    }

                    else if (b[i].getRect().contains(pointBottom)) 
                    {
                        this.setYDir(-2);
                    }

                    b[i].destroy();
                }
            }
        }
    }
    
    public void reset() 
    {
      xPos = 230;
      yPos = 355;
      xdir = 0;
      ydir = 0;
      isMoving = false;
    }

    public void setXDir(int x)
    {
      xdir = x;
    }

    public void setYDir(int y)
    {
      ydir = y;
    }

    public int getYDir()
    {
      return ydir;
    }
    
    public int getXDir()
    {
        return xdir;
    }
}
