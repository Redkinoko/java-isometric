/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Entity;

import core.manager.View.drawAction;
import java.awt.Polygon;

/**
 *
 * @author Red
 */
public class Element3D extends Element
{
    public Polygon base;
    public Polygon right;
    public Polygon left;
    public int z;
    public int depth;
    
    public Element3D()
    {
        super();
        base  = new Polygon();
        right = new Polygon();
        left  = new Polygon();
        z = 0;
        depth  = 0;
    }
    
    @Override
    public void load()
    {
        super.load();
    }
    
    @Override
    public void update()
    {
        super.update();
    }
    
    @Override
    public void draw(drawAction da)
    {
        super.draw(da);
    }
}
