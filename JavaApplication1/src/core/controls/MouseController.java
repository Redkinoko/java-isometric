/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controls;

import core.Entity.Element;
import core.Entity.Element;
import core.Tools;
import core.manager.View.View;
import java.awt.AWTEvent;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Red
 */
public class MouseController implements AWTEventListener
{
    private List<Element> elements;
    private View view;
    private Element pressed;
    private Element current;
    private Element released;
    
    public MouseController(List<Element> elts, View v)
    {
        elements = elts;
        view = v;
        pressed  = null;
        released = null;
        current  = null;
    }
    
    @Override
    public void eventDispatched(AWTEvent event)
    {
        if(event instanceof MouseEvent)
        {
            MouseEvent evt = (MouseEvent)event;
            evt = SwingUtilities.convertMouseEvent(evt.getComponent(), evt, view);
            switch(evt.getID())
            {
                case MouseEvent.MOUSE_PRESSED:
                    pressed = null;
                    pressed(evt);
                    break;
                case MouseEvent.MOUSE_RELEASED:
                    //released = null;
                    //released(evt);
                    break;
                case MouseEvent.MOUSE_DRAGGED:
                    current = null;
                    dragged(evt);
                    break;
                case MouseEvent.MOUSE_WHEEL:
                    break;
            }
        }
    }
    
    private void resetSelected()
    {
        for(Element e:elements)
        {
            e.unselected();
        }
    }
    
    private void pressed(MouseEvent evt)
    {
        for(Element e:elements)
        {
            if(e.contains(evt.getPoint()))
            {
                if(e.isSelected())
                {
                    e.unselected();
                }
                else
                {
                    pressed = e;
                    e.selected();
                }
            }
        }
        if(pressed == null)
        {
            resetSelected();
        }
    }
    
    private void released(MouseEvent evt)
    {
        for(Element e:elements)
        {
            if(e.contains(evt.getPoint()))
            {
                released = e;
                //e.selected();
            }
        }
    }
    
    private void dragged(MouseEvent evt)
    {
        for(Element e:elements)
        {
            if(e.contains(evt.getPoint()))
            {
                current = e;
                e.selected();
            }
            else if(e != pressed && e != current)
            {
                e.unselected();
            }
        }
        if(current != null && pressed != null && current != pressed)
        {
            int x = pressed.getX() - current.getX();
            int y = pressed.getY() - current.getY();
            int aX = Math.abs(x);
            int aY = Math.abs(y);
            for(Element e:elements)
            {
                for(int j=0 ; j<=aX ; j++)
                {
                    for(int i=0 ; i<=aY ; i++)
                    {
                        if(e != current)
                        {
                            if(y>=0)
                            {
                                if(e.getY() == current.getY()+i)
                                {
                                    if(x>=0 && e.getX() == current.getX()+j)
                                    {
                                        e.selected();
                                    }
                                    else if(x<=0 && e.getX() == current.getX()-j)
                                    {
                                        e.selected();
                                    }
                                }
                            }
                            else if(y<=0)
                            {
                                if(e.getY() == current.getY()-i)
                                {
                                    if(x>=0 && e.getX() == current.getX()+j)
                                    {
                                        e.selected();
                                    }
                                    else if(x<=0 && e.getX() == current.getX()-j)
                                    {
                                        e.selected();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
