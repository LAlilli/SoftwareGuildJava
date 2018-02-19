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
public class SleepingInTest {
    
    private SleepingIn sleep = new SleepingIn();
    
    public SleepingInTest() {
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
     * Test of canSleepIn method, of class SleepingIn.
     */
    @Test
    public void testWeekendTrue() {
        assertTrue(sleep.canSleepIn(false, false));
    } 
    
    @Test
    public void testWeekdayFalse() {
        assertFalse(sleep.canSleepIn(true, false));
    } 
    
    @Test
    public void testVacationTrue() {
        assertTrue(sleep.canSleepIn(false, true));
    } 
}
