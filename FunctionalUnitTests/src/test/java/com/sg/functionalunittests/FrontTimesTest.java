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
public class FrontTimesTest {
    
    FrontTimes times = new FrontTimes();
    
    public FrontTimesTest() {
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
     * Test of frontTimes method, of class FrontTimes.
     */
    @Test
    public void test2Chocoloate() {
        String expectedResult = "ChoCho";
        assertEquals(expectedResult, times.frontTimes("Chocolate", 2));
    }
    
    @Test
    public void test3Chocoloate() {
        String expectedResult = "ChoChoCho";
        assertEquals(expectedResult, times.frontTimes("Chocolate", 3));
    }
    
    @Test
    public void testAbc() {
        String expectedResult = "AbcAbcAbc";
        assertEquals(expectedResult, times.frontTimes("Abc", 3));
    }
}
