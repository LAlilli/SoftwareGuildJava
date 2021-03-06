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
public class CanHazTableTest {
    
    CanHazTable table = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void testYes() {
        int expectedResult = 2;
        assertEquals(expectedResult, table.canHazTable(5, 10));
    }
    
    @Test
    public void testNo() {
        int expectedResult = 0;
        assertEquals(expectedResult, table.canHazTable(5, 2));
    }
    
    @Test
    public void testMaybe() {
        int expectedResult = 1;
        assertEquals(expectedResult, table.canHazTable(5, 5));
    }
}
