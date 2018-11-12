package core;

import core.Entity.Button;
import core.Entity.Element;
import core.controls.MouseController;
import core.manager.View.drawAction;
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
    private List<Element> elements;
    private List<Integer> first;
    private List<Integer> second;
    private List<Integer> third;
    
    public Board(List<Element> e) 
    {
        elements = e;
        x        = Data.WIN_WIDTH_2-Data.WIN_HEIGHT/2;
        y        = Data.WIN_HEIGHT_2-Data.WIN_HEIGHT/2;
        width    = Data.WIN_HEIGHT;
        height   = Data.WIN_HEIGHT;
        origin   = new Element();
        origin.setRealX(x+width/2);
        origin.setRealY(y+height-Data.STEP.height/2);
        origin.setWidth(Data.STEP.width);
        origin.setHeight(Data.STEP.height);
        first   = new ArrayList();
        second  = new ArrayList();
        third   = new ArrayList();
    }
    
    public void sortByPlan()
    {
        first.clear();
        second.clear();
        third.clear();
        for(int i=(elements.size()-1) ; i>=0 ; i--)
        {
            switch(elements.get(i).getVisibility())
            {
                case Data.VISIBLE_FIRST:
                    first.add(i);
                    break;
                case Data.VISIBLE_SECOND:
                    second.add(i);
                    break;
                case Data.VISIBLE_THIRD:
                    third.add(i);
                    break;
                default:
                    break;
            }
        }
    }
    
    @Override
    public void load()
    {
        Button b = new Button(x,y, Data.STEP.width/2, Data.STEP.width/2);
        //elements.add(b);
        for(int i=0 ; i<10 ; i++)
        {
            for(int j=0 ; j<10 ; j++)
            {
                elements.add(createGridElement(i,j));
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
        sortByPlan();
        for(Element e:elements)
        {
            e.update();
        }
    }
    
    @Override
    public void draw(drawAction v)
    {
        for(Integer i:third)
        {
            elements.get(i).draw(v);
        }
        for(Integer i:second)
        {
            elements.get(i).draw(v);
        }
        for(Integer i:first)
        {
            elements.get(i).draw(v);
        }
    }
    
    public int getRealX(int x, int y)
    {
        return origin.getRealX() + Data.STEP.width/2*(x-y);
    }
    
    public int getRealY(int x, int y)
    {
        return origin.getRealY() - (Data.STEP.height*x) + (Data.STEP.height/2*(x-y));
    }
    
    public Element createGridElement(int x, int y)
    {
        Element e = new Element();
        e.setRealX(getRealX(x,y));
        e.setRealY(getRealY(x,y));
        e.setVisibility(Data.VISIBLE_FIRST);
        e.setX(x);
        e.setY(y);
        e.setWidth(Data.STEP.width);
        e.setHeight(Data.STEP.height);
        return e;
    }
    
}
