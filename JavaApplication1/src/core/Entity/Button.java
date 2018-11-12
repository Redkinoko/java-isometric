/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Entity;

import core.Data;
import core.IGame;
import core.manager.View.drawAction;
import java.awt.Color;
import java.awt.Polygon;

/**
 *
 * @author Red
 */
public class Button extends Polygon implements IGame
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean clicked;
    protected boolean selected;
    protected int     visibility;
    
    protected ColorSelect fillColor;
    protected ColorSelect edgeColor;
    
    public Button(int x_, int y_, int w, int h)
    {
        super();
        x          = x_;
        y          = y_;
        width      = w;
        height     = h;
        clicked    = false;
        selected   = false;
        visibility = Data.VISIBLE_FIRST;
        fillColor  = new ColorSelect(Color.GREEN, null);
        edgeColor  = new ColorSelect(Color.BLACK, Color.BLACK);
    }
    
    public void selected()
    {
        selected = true;
        fillColor.setSelected();
    }
    
    public void unselected()
    {
        selected = false;
        fillColor.setUnselected();
    }
    
    protected void setPoint(int i, int x, int y)
    {
        xpoints[i] = x;
        ypoints[i] = y;
    }
    
    @Override
    public void load()
    {
        addPoint(x,y);
        addPoint(x,y+height);
        addPoint(x+width,y+height);
        addPoint(x+width,y);
    }
    
    @Override
    public void update()
    {
        setPoint(0, x,y);
        setPoint(1, x,y+height);
        setPoint(2, x+width,y+height);
        setPoint(3, x+width,y);
    }
    
    @Override
    public void draw(drawAction da)
    {
        if(fillColor.tryToApply(da))
        {
            da.fillPolygon(xpoints, ypoints);
        }
        if(edgeColor.tryToApply(da))
        {
            da.drawPolygon(xpoints, ypoints);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public ColorSelect getFillColor() {
        return fillColor;
    }

    public void setFillColor(ColorSelect fillColor) {
        this.fillColor = fillColor;
    }

    public ColorSelect getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(ColorSelect edgeColor) {
        this.edgeColor = edgeColor;
    }
    
}
