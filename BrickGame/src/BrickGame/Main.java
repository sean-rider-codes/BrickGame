/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package home03;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author srider
 */
public class Main 
{
    public static void main(String[] args)
    {
        startApplet();
    }
    
    public static void startApplet()
    {
       JFrame frame = new JFrame(); 
       frame.setSize(620, 845);
       
       final JApplet applet = new GameApplet(); 
       
       frame.getContentPane().add(applet);
       frame.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               applet.stop();
               applet.destroy();
               System.exit(0);
           }
       });
       
       applet.init();
       applet.start();
       frame.setVisible(true);
    }
}
