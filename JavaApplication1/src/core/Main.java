package core;

import core.controls.MouseController;
import core.manager.DrawManager;
import core.manager.IManager;
import core.manager.Core;
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
        Core core = new Core();
        core.run();
    }
}
