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
public class PlayOutsideTest {
    
    private PlayOutside play = new PlayOutside();
    
    public PlayOutsideTest() {
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
     * Test of playOutside method, of class PlayOutside.
     */
    @Test
    public void testPlayOutside70() {
        assertTrue(play.playOutside(70, false));
    } 
    
    @Test
    public void testPlayOutside95True() {
        assertTrue(play.playOutside(95, true));
    }
    
    @Test
    public void testPlayOutside95False() {
        assertFalse(play.playOutside(95, false));
    }
}
