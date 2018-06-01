/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Product;
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
public class ProductServiceLayerTest {
    
    private ProductServiceLayer service;
    
    public ProductServiceLayerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("productServiceLayer", ProductServiceLayer.class);
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
    public void testSetMaterialCost() throws Exception {
        BigDecimal cost = new BigDecimal("1.25");
        BigDecimal laborCost = new BigDecimal("1.50");
        
        Product product = new Product("Wood");
        product.setCostPerSqFoot(cost);
        product.setLaborCostPerSqFoot(laborCost);
        
        service.setMaterialCost(product.getProductType());
        
        assertEquals(1.25, product.getCostPerSqFoot().doubleValue(), 2);
    }
    
    @Test
    public void testSetLaborCost() throws Exception {
        BigDecimal cost = new BigDecimal("1.25");
        BigDecimal laborCost = new BigDecimal("1.50");
        
        Product product = new Product("Wood");
        product.setCostPerSqFoot(cost);
        product.setLaborCostPerSqFoot(laborCost);
        
        service.setLaborCost(product.getProductType());
        
        assertEquals(1.5, product.getLaborCostPerSqFoot().doubleValue(), 2);
    }
}
