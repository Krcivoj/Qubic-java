/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

/**
 *
 * @author Krci
 */
public class Computer implements Runnable {
    Gui gui;
    
    Computer (Gui gui){
        this.gui = gui;
    }
    
    @Override 
    public void run () {
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        while(gui.pomoc == null){
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        gui.hint.doClick();
        gui.hintGrid.doClick();
    }
}
