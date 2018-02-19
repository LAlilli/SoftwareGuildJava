/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.functionalunittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LA-San
 */
public class ParrotTroubleTest {
    
    private ParrotTrouble parrot = new ParrotTrouble();
    
    public ParrotTroubleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parrotTrouble method, of class ParrotTrouble.
     */
    @Test
    public void testTalkingTroubleTrue() {
        assertTrue(parrot.parrotTrouble(true, 6));
    }   
    
    @Test
    public void testTalkingTroubleFalse() {
        assertFalse(parrot.parrotTrouble(true, 7));
    }
    
    @Test
    public void testNoTalking() {
        assertFalse(parrot.parrotTrouble(false, 6));
    }
}
