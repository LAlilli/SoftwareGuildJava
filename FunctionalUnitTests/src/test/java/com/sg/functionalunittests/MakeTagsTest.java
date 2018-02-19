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
public class MakeTagsTest {
    
    private MakeTags tags = new MakeTags();
    
    public MakeTagsTest() {
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

    @Test
    public void testIYay() {
        String expectedResult = "<i>Yay</i>";
        assertEquals(expectedResult, tags.makeTags("i", "Yay"));
    }
    
    @Test
    public void testIHello() {
        String expectedResult = "<i>Hello</i>";
        assertEquals(expectedResult, tags.makeTags("i", "Hello"));
    }
    
    @Test
    public void testCiteYay() {
        String expectedResult = "<cite>Yay</cite>";
        assertEquals(expectedResult, tags.makeTags("cite", "Yay"));
    }
}
