/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Qubic {
    //kocka na kojoj se igra
    private Cube mCube;
    //polje od dva igrača
    private Player[] mPlayers = { new Player('X'), new Player('O')};
    
    //stvara uvijete za početak igre
    public Qubic(int gameType)
    {
        //System.out.println("Odaberite verziju igre:");
        //System.out.println("Za igru na kocki 3X3X3 odaberite 3");
        //System.out.println("Za igru na kocki 4X4X4 odaberite 4");
        //System.out.println("Vas odabir: ");
        
        //int gameType;
        //Scanner myInput = new Scanner( System.in );
        //gameType = myInput.nextInt();
        //System.out.println("\n\n");
        if(gameType == 3){
            mCube= new Cube3();
            //System.out.println("----IGRA KRIZIC-KRUZIC U 3D NA 3X3X3 KOCKI ZAPOCINJE----\n");
        }
        else{
            mCube= new Cube4();
            //System.out.println("----IGRA KRIZIC-KRUZIC U 3D NA 4X4X4 KOCKI ZAPOCINJE----\n");
        }
    }

    //implementira logiku igre
    public Player play()
    {
        Player winner = null;
        Integer result;
        int playerOnMove = 0;
        
        //mCube.print();
        result = mCube.result();
        while(result == null){
            playerOnMove %= 2;
            mPlayers[playerOnMove].play(mCube);
            mCube.print();
            playerOnMove++;
            result = mCube.result();
        }
        
        if(result == 500)
            winner = mPlayers[0];
        
        else if (result == -500)
            winner = mPlayers[1];
        return winner;
    }   
}
