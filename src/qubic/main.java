/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

/**
 *
 * @author User
 */
public class main {
    /**
     * @param args the command line arguments
     */
    //Application logic
    public static void main(String[] args) {
        Gui app = new Gui();
        app.pozovi();
        /**
        System.out.println("------IGRA QUBIC ZAPOCINJE------\n");
        Qubic game = new Qubic();**/
        while(Gui.igra == null){
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        Player winner = app.igra.play();
        System.out.println("-----IGRA JE GOTOVA!-----");
        if(winner != null){
            System.out.println("POBIJEDIO JE: " + winner.id());
        }
        else{
            System.out.println("IGRA JE ZAVRSILA NERIJESENO!");
        }
    }
}
