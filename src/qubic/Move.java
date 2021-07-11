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
public class Move {
    private int mLevel;
    private int mRow;
    private int mColumn;

    //KONSTRUKTORI
    public Move(){
        mLevel = 0;
        mRow = 0;
        mColumn = 0;
    }
    
    public Move(String line){
        String[] elements = line.split(",");
        mLevel = Integer.parseInt(elements[0]);
        mRow = Integer.parseInt(elements[1]);
        mColumn = Integer.parseInt(elements[2]);
    }
    
    public Move(int i, int j, int k){
        mLevel = i;
        mRow = j;
        mColumn = k;
    }
    //vracaju pripadnu varijablu clanicu
    public int level(){return mLevel;}
    public int row(){return mRow;}
    public int column(){return mColumn;}
    
    //pretvara Move u String
    //sluzi za ispis
    public String toString()
    {
        return mLevel + "," + mRow + "," + mColumn;
    }
}
