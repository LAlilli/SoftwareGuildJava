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
public class Diff21Test {
    
    private Diff21 diff = new Diff21();
    
    public Diff21Test() {
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
     * Test of diff21 method, of class Diff21.
     */
    @Test
    public void testDiff23() {
        int expectedResult = 4;
        assertEquals(expectedResult, diff.diff21(23));
    } 
    
    @Test
    public void testDiff10() {
        int expectedResult = 11;
        assertEquals(expectedResult, diff.diff21(10));
    }
    
    @Test
    public void testDiff21() {
        int expectedResult = 0;
        assertEquals(expectedResult, diff.diff21(21));
    } 
}
