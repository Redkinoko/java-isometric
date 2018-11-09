/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.manager.View.ViewAction;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class Element implements IGame
{
    List<Point> extrems;
    int[] innerX;
    int[] innerY;
    
    public int realX;
    public int realY;
    
    public int x;
    public int y;
    public int z;
    public int width;
    public int height;
    public int depth;
    
    public Element()
    {
        realX = 0;
        realY = 0;
        x = 0;
        y = 0;
        z = 0;
        width  = 0;
        height = 0;
        depth  = 0;
        extrems = new ArrayList();
        innerX  = new int[4];
        innerY  = new int[4];
    }

    public void load()
    {
        extrems.add(new Point(realX + width/2, realY));
        extrems.add(new Point(realX,           realY - height/2));
        extrems.add(new Point(realX - width/2, realY));
        extrems.add(new Point(realX,           realY + height/2));
        
        innerX[0] = extrems.get(0).x-1;
        innerY[0] = extrems.get(0).y;
        innerX[1] = extrems.get(1).x;
        innerY[1] = extrems.get(1).y+1;
        innerX[2] = extrems.get(2).x+1;
        innerY[2] = extrems.get(2).y;
        innerX[3] = extrems.get(3).x;
        innerY[3] = extrems.get(3).y-1;
    }
    
    public void update()
    {
        extrems.get(0).x = realX + width/2;
        extrems.get(1).y = realY - height/2;
        extrems.get(2).x = realX - width/2;
        extrems.get(3).y = realY + height/2;
        
        innerX[0] = extrems.get(0).x-1;
        innerY[0] = extrems.get(0).y;
        innerX[1] = extrems.get(1).x;
        innerY[1] = extrems.get(1).y+1;
        innerX[2] = extrems.get(2).x+1;
        innerY[2] = extrems.get(2).y;
        innerX[3] = extrems.get(3).x;
        innerY[3] = extrems.get(3).y-1;
    }
    
    public void draw(ViewAction v)
    {
        
        v.setColor(Color.LIGHT_GRAY);
        v.fillPolygon(innerX, innerY);
        
        v.setColor(Color.GRAY);
        v.drawPoint(realX, realY);
        v.drawLine(extrems.get(0), extrems.get(1));
        v.drawLine(extrems.get(1), extrems.get(2));
        v.drawLine(extrems.get(2), extrems.get(3));
        v.drawLine(extrems.get(3), extrems.get(0));
    }
}
