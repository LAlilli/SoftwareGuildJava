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
public class SameFirstLastTest {
    
    private SameFirstLast same = new SameFirstLast();
    
    public SameFirstLastTest() {
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
     * Test of sameFirstLast method, of class SameFirstLast.
     */
    @Test
    public void testSameFirstLastFalse() {
        assertFalse(same.sameFirstLast(new int[] {1, 2, 3}));
    } 
    
    @Test
    public void testSameFirstLastTrue1() {
        assertTrue(same.sameFirstLast(new int[] {1, 2, 3, 1}));
    }
    
    @Test
    public void testSameFirstLastTrue2() {
        assertTrue(same.sameFirstLast(new int[] {1, 2, 1}));
    } 
}
