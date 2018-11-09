/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager.View;

import core.Data;
import core.IGame;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Red
 */
public class View extends JPanel
{
    private List<IGame> elements;
    private int offSetX;
    private int offSetY;
    private JFrame frame;
    private ViewAction va;
    
    public View(List<IGame> elts)
    {
        super();
        frame   = new JFrame();
        frame.add(this);
        offSetX = 20;
        offSetY = 50;
        setFrameSize(Data.WIN_WIDTH, Data.WIN_HEIGHT);
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
        va = new ViewAction();
        elements = elts;
        this.setBackground(Color.DARK_GRAY);
    }
    
    private void setFrameSize(int width, int height)
    {
        frame.setSize(width + offSetX, height + offSetY);
        setSize(width,height);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        va.g = g;
        for(IGame e:elements)
        {
            e.draw(va);
        }
    }
    
    @Override
    public void show()
    {
        frame.setVisible(true);
    }
}
