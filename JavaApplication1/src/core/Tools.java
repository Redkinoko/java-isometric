package core;

/**
 *
 * @author Red
 */
public class Tools
{
    public static void print(String s)  { System.out.print(s);   }
    public static void println(String s){ System.out.println(s); }
    public static void println()        { System.out.println();  }
    public static double dist(int x1,int y1, int x2,int y2) { return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)); }
}
