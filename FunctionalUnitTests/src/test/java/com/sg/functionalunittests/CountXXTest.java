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
public class CountXXTest {
    
    private CountXX xx = new CountXX();
    
    public CountXXTest() {
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
     * Test of countXX method, of class CountXX.
     */
    @Test
    public void testCountXX1() {
        String expectedResult = "abcxx";
        assertEquals(expectedResult, xx.countXX("xx"), 1);
    }
    
    @Test
    public void testCountXX2() {
        String expectedResult = "xxx";
        assertEquals(expectedResult, xx.countXX("xxx"), 2);
    }
    
    @Test
    public void testCountXX3() {
        String expectedResult = "xxxx";
        assertEquals(expectedResult, xx.countXX("xxxx"), 3);
    }
}
