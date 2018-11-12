/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Entity;

import core.manager.View.drawAction;
import java.awt.Color;

/**
 *
 * @author Red
 */
public class ColorSelect
{
    private Color selected;
    private Color notSelected;
    private Color current;
    public ColorSelect(Color sel, Color notSel)
    {
        selected    = sel;
        notSelected = notSel;
        current     = notSel;
    }
    
    public Color get()
    {
        return current;
    }
    
    public boolean tryToApply(drawAction da)
    {
        if(current != null)
        {
            da.setColor(current);
            return true;
        }
        return false;
    }
    
    public void setSelected()
    {
        current = selected;
    }
    
    public void setUnselected()
    {
        current = notSelected;
    }
}
