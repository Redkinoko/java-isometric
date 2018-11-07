package core;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Red
 */
public class Map extends Element
{
    private Quad[][] ground;
    
    public Map(int x, int y, int w, int h, int qW, int qH)
    {
        super(x,y, w,h);
        ground = new Quad[w][h];
        for(int j=0 ; j<h ; j++)
        {
            for(int i=0 ; i<w ; i++)
            {
                ground[i][j] = new Quad(i*qW, j*qH, qW, qH);
                ground[i][j].setParent(this);
            }
        }
    }
    
    public void update()
    {
        for(int y=0 ; y<size.height ; y++)
        {
            for(int x=0 ; x<size.width ; x++)
            {
                ground[x][y].update();
            }
        }
    }
    
    @Override
    public void paint(Graphics g)
    {   
        if(visible)
        {
            for(int y=0 ; y<size.height ; y++)
            {
                for(int x=0 ; x<size.width ; x++)
                {
                    ground[x][y].paint(g);
                }
            }
        }
    }
    
}
