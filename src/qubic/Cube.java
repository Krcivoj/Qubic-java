/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

import java.util.ArrayList;
/**
 *
 * @author Krci
 */
public interface Cube {
    //cisti kocku
    public void clear();
    //vraca vrijednost koja se nalazi na poziciji (i,j,k)
    public char value(int i, int j, int k);
    //ako je završno stanje vrača vrijednost, inače null
    public Integer result();
    //ova funkcija generira sve moguće poteze na tabli, sprema ih u vektor
    public ArrayList<Move> generate_moves(); 
    //odigra potez Move sa znakom char
    public boolean play(Move move,char c);
    //odigra potez unazad
    public void unPlay(Move move);
    //heuristicka funkcija
    public int heuristic(char player,char opponent);
    //vraca optimalnu dubinu minmax
    public int maxDepth();
    //iscrtava kocku u terminalu
    public void print();
    //klonira kocku
    public Cube clone();
}
