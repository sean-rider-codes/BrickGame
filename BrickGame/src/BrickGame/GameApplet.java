package home03;

import javax.swing.JApplet;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList; 
import javax.swing.Timer;

/**
 *
 * @author srider
 */

public class GameApplet extends JApplet
{  
    private Breakout game; 
    
    public void init()
    {
        setSize(600, 800);
        game = new Breakout();
        add(game); 
    }
    
    public void start()
    {
        game.start();
    }
   
}
