/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    /**
     * Test of id method, of class Player.
     */
    @Test
    public void testId() {
        System.out.println("id");
        Player instance = new Player('X');
        char expResult = 'X';
        char result = instance.id();
        assertEquals(expResult, result);
    }

    /**
     * Test of hint method, of class Player.
     */
    @Test
    public void testHint() {
        System.out.println("hint");
        Cube cube = new Cube3();
        Player instance = new Player('X');
        Move expResult = new Move(1,1,1);
        Move result = instance.hint(cube);
        assertEquals(expResult, result);
        cube.play(new Move(1,2,1), 'O');
        result = instance.hint(cube);
        assertEquals(expResult, result);
        
        cube.play(new Move(0,0,0), 'X');
        cube.play(new Move(0,0,1), 'X');
        assertEquals(new Move(0,0,2), instance.hint(cube));
        assertEquals(new Move(0,0,2), new Player('O').hint(cube));
    }
    
}
