/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager;

import core.manager.View.View;
import core.Data;
import core.IGame;
import core.manager.Manager;
import java.util.List;

/**
 *
 * @author Red
 */
public class DrawManager extends Manager
{
    private View view;
    public DrawManager(List<IGame> e)
    {
        super(e);
    }
    
    @Override
    protected void run()
    {
        if(view != null) view.repaint();
    }

    public void setView(View v)
    {
        view = v;
    }
}
