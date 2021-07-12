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
public class Cube3Test {
    
    public Cube3Test() {
    }

    /**
     * Test of clear method, of class Cube3.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Cube3 instance = new Cube3();
        instance.clear();
        for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    for(int k=0; k<3; k++)
                        assertEquals(instance.value(i,j,k), ' ');
    }

    /**
     * Test of value method, of class Cube3.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        int i = 0;
        int j = 0;
        int k = 0;
        Cube3 instance = new Cube3();
        char expResult = ' ';
        char result = instance.value(i, j, k);
        assertEquals(expResult, result);
        instance.play(new Move(0,1,2), 'X');
        assertEquals(instance.value(0,1,2), 'X');
        instance.play(new Move(2,1,2), 'O');
        assertEquals(instance.value(2,1,2), 'O');
    }

    /**
     * Test of result method, of class Cube3.
     */
    @Test
    public void testResult() {
        System.out.println("result");
        Cube3 instance = new Cube3();
        Integer expResult = null;
        Integer result = instance.result();
        assertEquals(expResult, result);
        instance.play(new Move(0,0,0), 'X');
        instance.play(new Move(0,0,1), 'X');
        assertEquals(expResult, instance.result());
        instance.play(new Move(0,0,2), 'X');
        assertEquals(500, (int)instance.result());
    }

    /**
     * Test of generate_moves method, of class Cube3.
     */
    @Test
    public void testGenerate_moves() {
        System.out.println("generate_moves");
        Cube3 instance = new Cube3();
        ArrayList<Move> expResult = new ArrayList<Move>();
        for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    for(int k=0; k<3; k++)
                        expResult.add(new Move(i,j,k));
        ArrayList<Move> result = instance.generate_moves();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Cube3.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        Move move = new Move(1,1,1);
        Cube3 instance = new Cube3();
        boolean expResult = true;
        boolean result = instance.isValid(move);
        assertEquals(expResult, result);
        
        assertTrue(instance.isValid(new Move(2,2,2)));
        assertFalse(instance.isValid(new Move(3,3,3)));
    }

    /**
     * Test of play method, of class Cube3.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Move move = new Move(1,1,1);
        char c = 'X';
        Cube3 instance = new Cube3();
        boolean expResult = true;
        boolean result = instance.play(move, c);
        assertEquals(expResult, result);
        assertEquals(instance.value(1,1,1), 'X');

    }

    /**
     * Test of unPlay method, of class Cube3.
     */
    @Test
    public void testUnPlay() {
        System.out.println("unPlay");
        Move move = new Move(0,1,2);
        Cube3 instance = new Cube3();
        instance.unPlay(move);
        assertEquals(instance.value(0,1,2), ' ');
        instance.play(move, 'X');
        assertEquals(instance.value(0,1,2), 'X');
        instance.unPlay(move);
        assertEquals(instance.value(0,1,2), ' ');
    }

    /**
     * Test of heuristic method, of class Cube3.
     */
    @Test
    public void testHeuristic() {
        System.out.println("heuristic");
        char player = 'X';
        char opponent = 'O';
        Cube3 instance = new Cube3();
        int expResult = 0;
        int result = instance.heuristic(player, opponent);
        assertEquals(expResult, result);
        instance.play(new Move(1,1,1), 'X');
        assertEquals(instance.heuristic(player, opponent), 26);
        assertEquals(instance.heuristic('O', 'X'), 13);
    }

    /**
     * Test of maxDepth method, of class Cube3.
     */
    @Test
    public void testMaxDepth() {
        System.out.println("maxDepth");
        Cube3 instance = new Cube3();
        int expResult = 27;
        int result = instance.maxDepth();
        assertEquals(expResult, result);
        instance.play(new Move(0,1,2), 'X');
        assertEquals(26, instance.maxDepth());
        instance.unPlay(new Move(0,1,2));
        assertEquals(27, instance.maxDepth());
    }

    /**
     * Test of print method, of class Cube3.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Cube3 instance = new Cube3();
        instance.print();
        instance.play(new Move(0,1,2), 'X');
        instance.print();
    }

    /**
     * Test of clone method, of class Cube3.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Cube3 instance = new Cube3();
        instance.play(new Move(0,1,2), 'X');
        Cube expResult = instance;
        Cube result = instance.clone();
        assertNotEquals(expResult, result);
        for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    for(int k=0; k<3; k++)
                        assertEquals(expResult.value(i,j,k), result.value(i,j,k));
    }
    
}
