package core;

import core.manager.DrawManager;
import core.manager.IManager;
import core.manager.UpdateManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        List<IManager> managers = new ArrayList();
        List<IGame> items       = new ArrayList();
        UpdateManager um        = new UpdateManager(items);
        DrawManager   dm        = new DrawManager(items);
        managers.add(um);
        managers.add(dm);
        Board board = new Board();
        items.add(board);
        
        for(IGame i:items)
        {
            i.load();
        }
        for(IManager m:managers)
        {
            m.start();
        }
        dm.show();
    }
}
