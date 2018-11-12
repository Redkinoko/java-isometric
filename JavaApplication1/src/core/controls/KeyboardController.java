/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controls;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author Red
 */
public class KeyboardController implements AWTEventListener
{
    @Override
    public void eventDispatched(AWTEvent event)
    {
        if(event instanceof KeyEvent)
        {
            KeyEvent evt = (KeyEvent) event;
            switch (evt.getID())
            {
                case KeyEvent.KEY_TYPED:
                    System.out.println("key: " + evt.getKeyChar());
                    break;
                case KeyEvent.KEY_PRESSED:
                    break;
                case KeyEvent.KEY_RELEASED:
                    break;
            }
        }
    }
    
}
