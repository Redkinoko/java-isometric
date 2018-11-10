package core;

import core.controls.MouseController;
import core.manager.DrawManager;
import core.manager.Core;
import core.manager.View.drawAction;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

/**
 *
 * @author Red
 */
public class Board implements IGame
{
    public static final Dimension STEP = new Dimension(Data.QUAD_SIZE, Data.QUAD_SIZE/2);
    private int x;
    private int y;
    private int width;
    private int height;
    private Element origin;
    private List<Element> elements;
    private MouseController mouse;
    
    public Board(MouseController m, List<Element> e) 
    {
        mouse    = m;
        elements = e;
        x        = Data.WIN_WIDTH_2-Data.WIN_HEIGHT/2;
        y        = Data.WIN_HEIGHT_2-Data.WIN_HEIGHT/2;
        width    = Data.WIN_HEIGHT;
        height   = Data.WIN_HEIGHT;
        origin   = new Element();
        origin.realX = x+width/2;
        origin.realY = y+height-STEP.height/2;
        origin.x = 0;
        origin.y = 0;
        origin.z = 0;
        origin.width  = STEP.width;
        origin.height = STEP.height;
    }

    @Override
    public void load()
    {
        elements.add(origin);
        for(int i=0 ; i<10 ; i++)
        {
            for(int j=0 ; j<10 ; j++)
            {
                elements.add(getElementByAxis(i,j,0));
            }
        }
        for(Element i:elements)
        {
            i.load();
        }
    }

    @Override
    public void update() 
    {
        for(Element e:elements)
        {
            e.update();
            if(e.isClicked)
            {
                if(e.isSelected)
                {
                    //TEST
                    e.depth += 10;
                    //TEST
                    e.unselected();
                }
                else
                {
                    e.selected();
                }
            }
            e.reset();
        }
    }
    
    @Override
    public void draw(drawAction v)
    {
        
        v.setColor(Color.red);
        v.drawPoint(origin.realX, origin.realY);
        
        for(int i=(elements.size()-1) ; i>=0 ; i--)
        {
            elements.get(i).draw(v);
        }
    }
    
    public Element getElementByAxis(int x, int y, int z)
    {
        Element e = new Element();
        e.realX  = origin.realX + STEP.width/2*(x-y);
        e.realY  = origin.realY - (STEP.height*x) + (STEP.height/2*(x-y));
        e.x      = x;
        e.y      = y;
        e.z      = z;
        e.width  = STEP.width;
        e.height = STEP.height;
        return e;
    }
    
}
