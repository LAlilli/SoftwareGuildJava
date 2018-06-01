/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author LA-San
 */
public class TaxServiceLayerTest {
    
    private TaxServiceLayer service;
    
    public TaxServiceLayerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("taxServiceLayer", TaxServiceLayer.class);
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
     * Test of validateUserTaxData method, of class TaxServiceLayer.
     */
    @Test
    public void testValidateUserTaxData() throws Exception {
        BigDecimal stateTax = new BigDecimal("0.25");
        
        Tax tax = new Tax("OH");
        tax.setStateTax(stateTax);

        service.validateUserTaxData(tax.getState());
        
        assertEquals("OH", tax.getState());
    }
}
