package core;


import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Red
 */
public class Quad extends Element
{
    private Point[] corners;
    
    public Quad(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        corners = new Point[4];
        for(int i=0 ; i<corners.length ; i++)
        {
            corners[i] = new Point(0,0);
        }
    }
    
    @Override
    public void load()
    {
        
    }
    public static double count = 0;
    public static int sens = 1;
    @Override
    public void update()
    {
        int w = size.width;
        int h = size.height;
        int w_2 = size.width/2;
        int h_2 = size.height/2;
        int cX = this.getPaintX()+w/2;
        int cY = this.getPaintY()+h/2;
        
        int dist = (int)Math.floor(Tools.dist(0, 0, w_2, h_2))+1;
        double rad = Math.PI/4;
        
        double rot = sens*count*Math.PI/4;

        corners[0].x = cX + rotateX(dist, 3*rad + rot);
        corners[0].y = cY + rotateY(dist, 3*rad + rot);
        
        corners[1].x = cX + rotateX(dist, 5*rad + rot);
        corners[1].y = cY + rotateY(dist, 5*rad + rot);
        
        corners[2].x = cX + rotateX(dist, 7*rad + rot);
        corners[2].y = cY + rotateY(dist, 7*rad + rot);
        
        corners[3].x = cX + rotateX(dist, rad + rot);
        corners[3].y = cY + rotateY(dist, rad + rot);
        count += 0.0003f;
        
    }
    
    public int rotateX(int w, double rad)
    {
        return (int)(w * Math.cos(rad));
    }
    
    public int rotateY(int h, double rad)
    {
        return (int)(h * Math.sin(rad));
    }
    
    public void rotate(Point p, double rad)
    {
        p.x = (int)(p.x * Math.cos(rad));
        p.y = (int)(p.y * Math.sin(rad));
    }
    
    @Override
    public void paint(Graphics g)
    {
        if(visible)
        {
            drawLine(g, corners[0], corners[1]);
            drawLine(g, corners[1], corners[2]);
            drawLine(g, corners[2], corners[3]);
            drawLine(g, corners[3], corners[0]);
        }
    }
}
