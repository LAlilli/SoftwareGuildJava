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
public class MischeviousChildrenTest {
    
    private MischeviousChildren children = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testBothSmilingTrue() {
        assertTrue(children.areWeInTrouble(true, true));
    }
    
    @Test
    public void testBothSmilingFalse() {
        assertTrue(children.areWeInTrouble(false, false));
    }
    
    @Test
    public void testASmilingTrue() {
        assertFalse(children.areWeInTrouble(true, false));
    }
    
    @Test
    public void testBSmilingTrue() {
        assertFalse(children.areWeInTrouble(false, true));
    }
}
