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
public class FirstLast6Test {
    
    private FirstLast6 firstLast = new FirstLast6();
    
    public FirstLast6Test() {
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
     * Test of firstLast6 method, of class FirstLast6.
     */
    @Test
    public void testLast6True() {
        assertTrue(firstLast.firstLast6(new int[] {1, 2, 6}));
    }
    
    @Test
    public void testFirst6True() {
        assertTrue(firstLast.firstLast6(new int[] {6, 1, 2, 3}));
    }
    
    @Test
    public void testFirstLast6False() {
        assertFalse(firstLast.firstLast6(new int[] {13, 6, 1, 2, 3}));
    }
}
