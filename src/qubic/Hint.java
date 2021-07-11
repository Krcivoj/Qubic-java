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
public class Hint implements Runnable{
    private Cube cube;
    private Player player;
    private Gui gui;
    
    Hint(Cube cube, Player player, Gui gui){
        this.cube = cube;
        this.player = player;
        this.gui = gui;
    }
    
    @Override 
    public void run () {
        Move hint = player.hint(cube);
        
        gui.setHint(hint);
    }
    
}
