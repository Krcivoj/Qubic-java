/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class Cube4Test {
    
    public Cube4Test() {
    }

    /**
     * Test of clear method, of class Cube4.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Cube4 instance = new Cube4();
        instance.clear();
        for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    for(int k=0; k<4; k++)
                        assertEquals(instance.value(i,j,k), ' ');
    }

    /**
     * Test of value method, of class Cube4.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        int i = 0;
        int j = 0;
        int k = 0;
        Cube4 instance = new Cube4();
        char expResult = ' ';
        char result = instance.value(i, j, k);
        assertEquals(expResult, result);
        instance.play(new Move(0,1,2), 'X');
        assertEquals(instance.value(0,1,2), 'X');
        instance.play(new Move(3,1,2), 'O');
        assertEquals(instance.value(3,1,2), 'O');
    }

    /**
     * Test of result method, of class Cube4.
     */
    @Test
    public void testResult() {
        System.out.println("result");
        Cube4 instance = new Cube4();
        Integer expResult = null;
        Integer result = instance.result();
        assertEquals(expResult, result);
        instance.play(new Move(0,0,0), 'X');
        instance.play(new Move(0,0,1), 'X');
        instance.play(new Move(0,0,2), 'X');
        assertEquals(expResult, instance.result());
        instance.play(new Move(0,0,3), 'X');
        assertEquals(500, (int)instance.result());
    }

    /**
     * Test of generate_moves method, of class Cube4.
     */
    @Test
    public void testGenerate_moves() {
        System.out.println("generate_moves");
        Cube4 instance = new Cube4();
        ArrayList<Move> expResult = new ArrayList<Move>();
        for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    for(int k=0; k<4; k++)
                        expResult.add(new Move(i,j,k));
        ArrayList<Move> result = instance.generate_moves();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Cube4.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Move move = new Move(1,1,1);
        Cube4 instance = new Cube4();
        boolean expResult = true;
        boolean result = instance.isValid(move);
        assertEquals(expResult, result);
        
        assertTrue(instance.isValid(new Move(2,2,2)));
        assertTrue(instance.isValid(new Move(3,3,3)));
        assertFalse(instance.isValid(new Move(-1,3,3)));
    }

    /**
     * Test of play method, of class Cube4.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Move move = new Move(1,3,1);
        char c = 'X';
        Cube4 instance = new Cube4();
        boolean expResult = true;
        boolean result = instance.play(move, c);
        assertEquals(expResult, result);
        assertEquals(instance.value(1,3,1), 'X');
    }

    /**
     * Test of unPlay method, of class Cube4.
     */
    @Test
    public void testUnPlay() {
        System.out.println("unPlay");
        Move move = new Move(0,1,2);
        Cube4 instance = new Cube4();
        instance.unPlay(move);
        assertEquals(instance.value(0,1,2), ' ');
        instance.play(move, 'X');
        assertEquals(instance.value(0,1,2), 'X');
        instance.unPlay(move);
        assertEquals(instance.value(0,1,2), ' ');
    }

    /**
     * Test of heuristic method, of class Cube4.
     */
    @Test
    public void testHeuristic() {
        System.out.println("heuristic");
        char player = 'X';
        char opponent = 'O';
        Cube4 instance = new Cube4();
        int expResult = 0;
        int result = instance.heuristic(player, opponent);
        assertEquals(expResult, result);
        instance.play(new Move(1,1,1), 'X');
        assertEquals(14, instance.heuristic(player, opponent));
        assertEquals(7, instance.heuristic('O', 'X'));
    }

    /**
     * Test of maxDepth method, of class Cube4.
     */
    @Test
    public void testMaxDepth() {
        System.out.println("maxDepth");
        Cube4 instance = new Cube4();
        int expResult = 6;
        int result = instance.maxDepth();
        assertEquals(expResult, result);
        instance.play(new Move(0,1,2), 'X');
        assertEquals(expResult, instance.maxDepth());
        instance.unPlay(new Move(0,1,2));
        assertEquals(expResult, instance.maxDepth());
    }

    /**
     * Test of print method, of class Cube4.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Cube4 instance = new Cube4();
        instance.print();
        instance.play(new Move(3,1,2), 'X');
        instance.print();
    }

    /**
     * Test of clone method, of class Cube4.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Cube4 instance = new Cube4();
        instance.play(new Move(3,1,2), 'X');
        Cube expResult = instance;
        Cube result = instance.clone();
        assertNotEquals(expResult, result);
        for(int i=0; i<4; i++)
                for(int j=0; j<4; j++)
                    for(int k=0; k<4; k++)
                        assertEquals(expResult.value(i,j,k), result.value(i,j,k));
    }
    
}
