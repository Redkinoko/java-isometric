/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controls;

import core.Element;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

/**
 *
 * @author Red
 */
public class MouseController extends MouseAdapter
{
    private List<Element> elements;
    public MouseController(List<Element> elts)
    {
        elements = elts;
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        for(Element elt:elements)
        {
            if(elt.base.contains(e.getPoint()))
            {
                elt.isClicked = true;
            }
        }
    }
}
