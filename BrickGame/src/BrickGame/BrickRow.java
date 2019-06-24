/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home03;
import home03.Brick;
import java.awt.*;
/**
 *
 * @author srider
 */
public class BrickRow 
{
    Brick [] row = new Brick[10];
    
    public BrickRow( int rowNumber, Color c )
    {
        for ( int i = 0; i < 10; i++)
        {
            for ( int z = 5; z <= 600; z += 60)
            {
               row[i] = new Brick( 50, 25, ((i * 60) + 5), (rowNumber + 35), c );
            }
        }
    }
    
    public Brick[] getRow()
    {
        return row;
    }
    
    public void drawRow( Graphics g )
    {
        for ( Brick r : this.getRow() )
        {
            r.drawBrick(g);
        }
    }
}
