/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager.View;

import core.Data;
import core.Entity.Element;
import core.IGame;
import core.controls.MouseController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Red
 */
public class View extends JPanel
{
    private List<IGame> drawables;
    private int offSetX;
    private int offSetY;
    private JFrame frame;
    private drawAction viewAction;
    
    public View(drawAction va, List<IGame> draws)
    {
        super();
        viewAction = va;
        drawables  = draws;
        offSetX    = 20;
        offSetY    = 50;
        frame      = new JFrame();
    }
    
    private void setFrameSize(int width, int height)
    {
        frame.setSize(width + offSetX, height + offSetY);
        setSize(width,height);
    }
    
    public void load()
    {
        frame.add(this);
        frame.addWindowListener(
            new java.awt.event.WindowAdapter()
            {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent)
                {
                    java.lang.System.exit(0);
                }
            }
        );
        setFrameSize(Data.WIN_WIDTH, Data.WIN_HEIGHT);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        viewAction.g = g;
        for(IGame d:drawables)
        {
            d.draw(viewAction);
        }
    }
    
    @Override
    public void show()
    {
        frame.setVisible(true);
    }
}
