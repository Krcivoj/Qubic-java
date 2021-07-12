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
        while (true){
            while(app.igra == null){
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

            try
            {
                if(winner != null){
                    if(winner.id() == 'X') app.obradiKraj(1);
                    else if (winner.id() == 'O') app.obradiKraj(-1);

                }
                else{
                    app.obradiKraj(0);
                }
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
