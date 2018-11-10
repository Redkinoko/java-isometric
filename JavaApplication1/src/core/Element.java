/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.manager.View.drawAction;
import java.awt.Color;
import java.awt.Polygon;

/**
 *
 * @author Red
 */
public class Element implements IGame
{
    public Polygon top;
    public Polygon base;
    
    public Polygon right;
    public Polygon left;
    
    public int realX;
    public int realY;
    
    public int x;
    public int y;
    public int z;
    public int width;
    public int height;
    public int depth;
    public boolean isClicked;
    public boolean isSelected;
    
    public Color fillColor;
    public Color shapeColor;
    public Color selectShapeColor;
    public Color currentShapeColor;
    public Color selectFillColor;
    public Color currentFillColor;
    
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
        base  = new Polygon();
        top   = new Polygon();
        right = new Polygon();
        left  = new Polygon();
        fillColor         = Color.WHITE;
        selectFillColor   = Color.GREEN;
        currentFillColor  = fillColor;
        shapeColor        = Color.DARK_GRAY;
        selectShapeColor  = Color.GREEN;
        currentShapeColor = shapeColor;
        isClicked         = false;
        isSelected        = false;
    }
    
    public void selected()
    {
        isSelected   = true;
        //currentShapeColor = selectShapeColor;
        currentFillColor  = selectFillColor;
    }
    
    public void unselected()
    {
        isSelected   = false;
        //currentShapeColor = shapeColor;
        currentFillColor  = fillColor;
    }
    
    @Override
    public void load()
    {
        base.addPoint(realX + width/2, realY);
        base.addPoint(realX, realY - height/2);
        base.addPoint(realX - width/2, realY);
        base.addPoint(realX, realY + height/2);
        for(int i=0 ; i<base.npoints ; i++)
        {
            top.addPoint(base.xpoints[i], base.ypoints[i]);
        }
        right.addPoint(top.xpoints[0], base.ypoints[0]);
        right.addPoint(top.xpoints[3], base.ypoints[3]);
        right.addPoint(base.xpoints[3], base.ypoints[3]);
        right.addPoint(base.xpoints[0], base.ypoints[0]);
        
        left.addPoint(top.xpoints[3], base.ypoints[3]);
        left.addPoint(top.xpoints[2], base.ypoints[2]);
        left.addPoint(base.xpoints[2], base.ypoints[2]);
        left.addPoint(base.xpoints[3], base.ypoints[3]);
    }
    
    @Override
    public void update()
    {        
        base.xpoints[0] = realX + width/2;
        base.ypoints[0] = realY;
        base.xpoints[1] = realX;
        base.ypoints[1] = realY - height/2;
        base.xpoints[2] = realX - width/2;
        base.ypoints[2] = realY;
        base.xpoints[3] = realX;
        base.ypoints[3] = realY + height/2;
        
        top.xpoints[0] = realX + width/2;
        top.ypoints[0] = realY - depth;
        top.xpoints[1] = realX;
        top.ypoints[1] = realY - height/2 - depth;
        top.xpoints[2] = realX - width/2;
        top.ypoints[2] = realY - depth;
        top.xpoints[3] = realX;
        top.ypoints[3] = realY + height/2 - depth;
        
        right.xpoints[0] = top.xpoints[0];
        right.ypoints[0] = top.ypoints[0];
        right.xpoints[1] = top.xpoints[3];
        right.ypoints[1] = top.ypoints[3];
        right.xpoints[2] = base.xpoints[3];
        right.ypoints[2] = base.ypoints[3];
        right.xpoints[3] = base.xpoints[0];
        right.ypoints[3] = base.ypoints[0];
        
        left.xpoints[0] = top.xpoints[3];
        left.ypoints[0] = top.ypoints[3];
        left.xpoints[1] = top.xpoints[2];
        left.ypoints[1] = top.ypoints[2];
        left.xpoints[2] = base.xpoints[2];
        left.ypoints[2] = base.ypoints[2];
        left.xpoints[3] = base.xpoints[3];
        left.ypoints[3] = base.ypoints[3];
    }
    
    public void reset()
    {
        isClicked = false;
    }
    
    @Override
    public void draw(drawAction v)
    {
        //BASE
        /*
        v.setColor(currentFillColor);
        v.fillPolygon(base);
        */
        v.setColor(currentFillColor);
        v.fillPolygon(left);
        v.fillPolygon(right);
        v.setColor(currentShapeColor);
        //
        v.drawLine(base.xpoints[0], base.ypoints[0], top.xpoints[0], top.ypoints[0]);
        v.drawLine(base.xpoints[2], base.ypoints[2], top.xpoints[2], top.ypoints[2]);
        v.drawLine(base.xpoints[3], base.ypoints[3], top.xpoints[3], top.ypoints[3]);
        //TOP
        v.setColor(currentFillColor);
        v.fillPolygon(top);
        v.setColor(currentShapeColor);
        v.drawPolygon(top);
        /*
        v.setColor(currentFillColor);
        v.fillPolygon(base);
        */
        v.setColor(Color.LIGHT_GRAY);
        v.drawPolygon(base);
    }
}
