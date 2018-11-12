/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Dimension;

/**
 *
 * @author Red
 */
public class Data
{
    public static final int WIN_WIDTH    = 800;
    public static final int WIN_HEIGHT   = 600;
    public static final int WIN_WIDTH_2  = WIN_WIDTH/2;
    public static final int WIN_HEIGHT_2 = WIN_HEIGHT/2;
    public static final int QUAD_SIZE    = 64;
    public static final int SEC_TO_MS    = 1000;
    public static final int N_FRAME      = 60;
    public static final int TICK         = SEC_TO_MS/N_FRAME;
    public static final int VISIBLE_HIDE   = 0;
    public static final int VISIBLE_FIRST  = 1;
    public static final int VISIBLE_SECOND = 2;
    public static final int VISIBLE_THIRD  = 3;
    public static final Dimension STEP = new Dimension(Data.QUAD_SIZE, Data.QUAD_SIZE/2);
}
