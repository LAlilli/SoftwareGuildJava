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
public class CommonEndTest {
    
    private CommonEnd commonElement = new CommonEnd();
    
    public CommonEndTest() {
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
     * Test of commonEnd method, of class CommonEnd.
     */
    @Test
    public void testTrueLastElement() {
        int a[] = {1, 2, 3};
        int b[] = {7, 3};
        assertTrue(commonElement.commonEnd(a, b));
    }
    
    @Test
    public void testFalseElementMatch() {
        int a[] = {1, 2, 3};
        int b[] = {7, 3, 2};
        assertFalse(commonElement.commonEnd(a, b));
    }
    
    @Test
    public void testTrueFirstElement() {
        int a[] = {1, 2, 3};
        int b[] = {1, 3};
        assertTrue(commonElement.commonEnd(a, b));
    }
}
