/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager;

import core.Board;
import core.Entity.Element;
import core.IGame;
import core.controls.KeyboardController;
import core.controls.MouseController;
import core.manager.View.View;
import core.manager.View.drawAction;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class Core
{
    public List<IGame>   items;
    public List<Element> elements;
    public KeyboardController keyboard;
    public MouseController mouse;
    public DrawManager   drawer;
    public UpdateManager updater;
    public View          view;
    public drawAction    da;
    public Board         board;
    
    public Core()
    {
        items       = new ArrayList();
        elements    = new ArrayList();
        
        drawer      = new DrawManager();
        updater     = new UpdateManager(items);
        
        board       = new Board(elements);
        da          = new drawAction();
        view        = new View(da, items);
        
        keyboard    = new KeyboardController();
        mouse       = new MouseController(elements, view);
    }
    
    public void run()
    {
        Toolkit.getDefaultToolkit().addAWTEventListener(mouse,    AWTEvent.MOUSE_EVENT_MASK);
        Toolkit.getDefaultToolkit().addAWTEventListener(mouse,    AWTEvent.MOUSE_MOTION_EVENT_MASK);
        Toolkit.getDefaultToolkit().addAWTEventListener(keyboard, AWTEvent.KEY_EVENT_MASK);
        items.add(board);
        drawer.setView(view);
        view.load();
        loadAll();
        startAll();
        view.show();
    }
    
    public void loadAll()
    {
        for(IGame i:items)
        {
            i.load();
        }
    }
    
    public void startAll()
    {
        drawer.start();
        updater.start();
    }
    
    public void stopAll()
    {
        drawer.stop();
        updater.stop();
    }
}
