package core;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Red
 */
public class Element implements IGame
{
    protected Point origin;
    protected Dimension size;
    protected Dimension offSet;
    protected Element parent;
    
    protected boolean visible;
    protected boolean dead;
    
    public Element(int w, int h)
    {
        origin  = new Point(0,0);
        size    = new Dimension(w,h);
        visible = true;
        dead    = false;
        offSet  = new Dimension(0,0);
    }
    
    public Element(int x, int y, int w, int h)
    {
        origin  = new Point(x,y);
        size    = new Dimension(w,h);
        visible = true;
        dead    = false;
        offSet  = new Dimension(0,0);
    }
    
    protected int getPaintX()
    {
        if(parent == null) return origin.x + offSet.width;
        return parent.origin.x + parent.offSet.width + origin.x + offSet.width;
    }
    
    protected int getPaintY()
    {
        if(parent == null) return origin.y + offSet.height;
        return parent.origin.y + parent.offSet.height + origin.y + offSet.height;
    }
    
    public Point getCenter()
    {
        return new Point(origin.x+size.width/2, origin.y+size.height/2);
    }
    
    @Override
    public void load()
    {
        
    }
    
    @Override
    public void update()
    {
        
    }

    @Override
    public void paint(Graphics g)
    {
        if(visible)
        {
            
        }
    }
    
    public void drawLine(Graphics g, Point p1, Point p2)
    {
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
    
    public void paintCenter(Graphics g)
    {
        g.drawRect(origin.x+size.width/2, origin.y+size.height/2, 1,1);
    }
    
    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Dimension getOffSet() {
        return offSet;
    }

    public void setOffSet(Dimension offSet) {
        this.offSet = offSet;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }
}
