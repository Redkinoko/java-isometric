/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager;

import core.Data;
import core.IGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Red
 */
public abstract class Manager implements ActionListener, IManager
{
    protected Timer timer;
    protected List<IGame> elements;
    
    public Manager(List<IGame> e)
    {
        timer = new Timer(Data.TICK, this);
        elements = e;
    }
    
    public void start()
    {
        timer.start();
    }

    public void stop()
    {
        timer.stop();
    }
    
    protected abstract void run();
    
    @Override  
    public void actionPerformed(ActionEvent e)
    {
        run();
    }

}
