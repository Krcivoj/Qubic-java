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
public class Pair<T1,T2> {
    public T1 first;
    public T2 second;
    
    public Pair (){}
    public Pair (T1 a, T2 b){
        first = a;
        second = b;
    }
}
