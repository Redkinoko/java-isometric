/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.manager;

import core.IGame;
import java.util.List;

/**
 *
 * @author Red
 */
public class UpdateManager extends Manager
{
    private List<IGame> elements;
    public UpdateManager(List<IGame> e)
    {
        super();
        elements    = e;
    }
    
    @Override
    protected void run()
    {
        for(IGame e:elements)
        {
            e.update();
        }
    }
    
}
