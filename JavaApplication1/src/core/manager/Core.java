/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager;

import core.Board;
import core.Element;
import core.IGame;
import core.controls.MouseController;
import core.manager.View.View;
import core.manager.View.drawAction;
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
    public MouseController mouse;
    public DrawManager   drawer;
    public UpdateManager updater;
    public View          view;
    public drawAction    da;
    public Board         board;
    
    public Core()
    {
        items    = new ArrayList();
        elements = new ArrayList();
        drawer   = new DrawManager(items);
        updater  = new UpdateManager(items);
        mouse    = new MouseController(elements);
        board    = new Board(mouse, elements);
        da       = new drawAction();
        view     = new View(da, mouse, items);
    }
    
    public void run()
    {
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
