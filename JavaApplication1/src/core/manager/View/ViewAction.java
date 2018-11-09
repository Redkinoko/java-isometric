/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Red
 */
public class ViewAction
{
    public Graphics g;
    public ViewAction()
    {
        
    }
    
    public void drawLine(Point p1, Point p2)
    {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
    
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        g.drawLine(x1, y1, x2, y2);
    }
    
    
    public void drawPoint(int x, int y)
    {
        g.drawRect(x, y, 1, 1);
    }
    
    public void drawRect(int x, int y, int width, int height)
    {
        g.drawRect(x, y, width, height);
    }

    public void fillPolygon(int[] x, int[] y)
    {
        g.fillPolygon(x, y, x.length);
    }
    
    public void setColor(Color c)
    {
        g.setColor(c);
    }
}
