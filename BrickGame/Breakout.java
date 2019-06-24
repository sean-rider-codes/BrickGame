package home03;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel; 
import javax.swing.Timer;

/**
 *
 * @author srider
 */

public class Breakout extends JPanel implements KeyListener
{   
    private Breakout game;
    
    private final BrickRow[] brickSet = new BrickRow[6];
    
    private final BrickRow firstRow = new BrickRow( -30, Color.red );
    
    private final BrickRow secondRow = new BrickRow( 5, Color.orange );
    
    private final BrickRow thirdRow = new BrickRow( 40, Color.yellow );
    
    private final BrickRow fourthRow = new BrickRow( 75, Color.green );
    
    private final BrickRow fifthRow = new BrickRow( 110, Color.cyan );
    
    private final BrickRow sixthRow = new BrickRow( 145, Color.magenta );
    
    private final Paddle paddle = new Paddle();
    
    private final Ball ball = new Ball();
    
    private final Text gameText = new Text();
    
    
    
    @Override
    protected void paintComponent(Graphics g)
    {
            g.setColor(Color.black);
        
            g.fillRect(0, 0, 620, 845);
        
            firstRow.drawRow(g);
        
            secondRow.drawRow(g);
        
            thirdRow.drawRow(g);
        
            fourthRow.drawRow(g);
        
            fifthRow.drawRow(g);
        
            sixthRow.drawRow(g);
        
            paddle.drawPaddle(g);
        
            ball.drawBall(g);
        
            gameText.drawText(g);
    }
    
    private void updateGameState()
    {
        ball.move( gameText );
        
        ball.checkCollisions( paddle, firstRow.getRow() );
        
        ball.checkCollisions( paddle, secondRow.getRow() );
        
        ball.checkCollisions( paddle, thirdRow.getRow() );
        
        ball.checkCollisions( paddle, fourthRow.getRow() );
        
        ball.checkCollisions( paddle, fifthRow.getRow() );
        
        ball.checkCollisions( paddle, sixthRow.getRow() ); 
        
        if ( gameText.getNumberOfLives() == 0 )
        {
            //noLives = true;
            game.setupGame();
        }
    }
        
    private void setupGame()
    {
        gameText.setLives(3);
        
        //noLives = false;
        
        ball.reset();
        
        paddle.reset();
        
        for ( Brick j : firstRow.getRow())
        {
            j.resetBricks();
        }
        
        for ( Brick j : secondRow.getRow())
        {
            j.resetBricks();
        }
        
        for ( Brick j : thirdRow.getRow())
        {
            j.resetBricks();
        }
        
        for ( Brick j : fourthRow.getRow())
        {
            j.resetBricks();
        }
        
        for ( Brick j : fifthRow.getRow())
        {
            j.resetBricks();
        }
        
        for ( Brick j : sixthRow.getRow())
        {
            j.resetBricks();
        }
    }
    
    private void handleInput(KeyEvent e)
    {
        int keyPressed = e.getKeyCode();
        
        if (keyPressed == 37)
        {
            //left
             paddle.move( paddle.xPos - 10 );
             
             if ( ball.getIsMoving() == false )
             {
                ball.setXDir(0);
                ball.setYDir(-2);
             }
        }
        
        if (keyPressed == 39)
        {
            //right
            paddle.move( paddle.xPos + 10 );
            
            if ( ball.getIsMoving() == false )
             {
                ball.setXDir(0);
                ball.setYDir(-2);
             }
        }
    }
    
    // Game Functionality begins here 
    
    public Breakout()
    {
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this); 
        
        framesPerSecond = 60; 
        delayBetweenFrames = 1000 / framesPerSecond; 

        setupGame();
    }
    
    public void start()
    {
        // Setup a Timer to update the game state and redraw the screen. 
        animationTimer = new Timer(delayBetweenFrames, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {              
                updateGameState();
                repaint();
            }
        });
        
        animationTimer.setRepeats(true);
        animationTimer.start();
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        handleInput(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        // Do Nothing on Key Release
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        handleInput(e);
    }
    
    private final int     framesPerSecond;
    private final int     delayBetweenFrames;  
    private Timer         animationTimer; 
}
