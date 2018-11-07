package core;


import core.Map;
import java.awt.Point;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;

/**
 *
 * @author Red
 */
public class Main
{
    public static final int WIN_WIDTH     = 800;
    public static final int WIN_HEIGHT    = 600;
    public static final int WIN_WIDTH_2   = WIN_WIDTH/2;
    public static final int WIN_HEIGHT_2  = WIN_HEIGHT/2;
    public static final int QUAD_WIDTH    = 32;
    public static final int QUAD_HEIGHT   = 32;
    public static void main(String[] args) throws InterruptedException
    {
        int mapW = 10;
        int mapH = 10;
        int mapX = WIN_WIDTH_2  - QUAD_WIDTH*mapW/2;
        int mapY = WIN_HEIGHT_2 - QUAD_HEIGHT*mapH/2;
        Map map = new Map(mapX,mapY, mapW,mapH, QUAD_WIDTH,QUAD_HEIGHT);
        Panel panel = new Panel();
        JFrame window = new JFrame();
        
        
        window.setSize(WIN_WIDTH, WIN_HEIGHT);
        window.add(panel);
        panel.setSize(WIN_WIDTH, WIN_HEIGHT);
        panel.add(map);
        panel.load();
        window.setVisible(true);
        while(window.isVisible() && window.isActive()) { sleep(16); panel.update(); panel.repaint(); }
        exit(0);
    }
}
