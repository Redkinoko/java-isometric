/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Entity;

import core.Data;
import core.manager.View.drawAction;
import java.awt.Color;

/**
 *
 * @author Red
 */
public class Element extends Button
{
    protected int realX;
    protected int realY;
    
    public Element()
    {
        super(0,0,0,0);
        realX = 0;
        realY = 0;
    }
    
    @Override
    public void load()
    {
        addPoint(realX + width/2, realY);
        addPoint(realX, realY - height/2);
        addPoint(realX - width/2, realY);
        addPoint(realX, realY + height/2);
    }
    
    @Override
    public void update()
    {
        setPoint(0, realX + width/2, realY);
        setPoint(1, realX, realY - height/2);
        setPoint(2, realX - width/2, realY);
        setPoint(3, realX, realY + height/2);
    }
    
    @Override
    public void draw(drawAction da)
    {
        super.draw(da);
    }

    public int getRealX() {
        return realX;
    }

    public void setRealX(int realX) {
        this.realX = realX;
    }

    public int getRealY() {
        return realY;
    }

    public void setRealY(int realY) {
        this.realY = realY;
    }
}
