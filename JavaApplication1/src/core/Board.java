package core;

import core.manager.DrawManager;
import core.manager.View.ViewAction;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class Board implements IGame
{
    private int x;
    private int y;
    private int width;
    private int height;
    private Element origin;
    public static final Dimension step = new Dimension(Data.QUAD_SIZE, Data.QUAD_SIZE/2);
    private List<IGame> elements;
    
    public Board() 
    {
        x      = Data.WIN_WIDTH_2-Data.WIN_HEIGHT/2;
        y      = Data.WIN_HEIGHT_2-Data.WIN_HEIGHT/2;
        width  = Data.WIN_HEIGHT;
        height = Data.WIN_HEIGHT;
        origin = new Element();
        origin.realX = x+width/2;
        origin.realY = y+height-step.height/2;
        origin.x = 0;
        origin.y = 0;
        origin.z = 0;
        origin.width  = step.width;
        origin.height = step.height;
        elements = new ArrayList();
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
        for(IGame i:elements)
        {
            i.load();
        }
    }

    @Override
    public void update() 
    {
        for(IGame e:elements)
        {
            e.update();
        }
    }
    
    @Override
    public void draw(ViewAction v)
    {
        
        v.setColor(Color.red);
        v.drawPoint(origin.realX, origin.realY);
        
        for(IGame e:elements)
        {
            e.draw(v);
        }
    }
    
    public Element getElementByAxis(int x, int y, int z)
    {
        Element e = new Element();
        e.realX  = origin.realX + step.width/2*(x-y);
        e.realY  = origin.realY - (step.height*x) + (step.height/2*(x-y));
        e.x      = x;
        e.y      = y;
        e.z      = z;
        e.width  = step.width;
        e.height = step.height;
        return e;
    }
    
}
