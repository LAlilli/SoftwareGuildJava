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
public class SumDoubleTest {
    
    private SumDouble sum = new SumDouble();
    
    public SumDoubleTest() {
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
     * Test of sumDouble method, of class SumDouble.
     */
    @Test
    public void testSumDoubleDiff1() {
        int expectedSum = 3;
        assertEquals(expectedSum, sum.sumDouble(1, 2));
    } 
    
    @Test
    public void testSumDoubleDiff2() {
        int expectedSum = 5;
        assertEquals(expectedSum, sum.sumDouble(3, 2));
    }
    
    @Test
    public void testSumDoubleSame() {
        int expectedSum = 8;
        assertEquals(expectedSum, sum.sumDouble(2, 2));
    }
}
