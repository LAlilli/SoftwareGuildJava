/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.ProductDaoFileImplStub;
import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LA-San
 */
public class ProductServiceLayerTest {
    
    private ProductServiceLayer service;
    
    public ProductServiceLayerTest() {
        ProductDao dao = new ProductDaoFileImplStub();
        
        service = new ProductServiceLayerImpl(dao);
    }
    
    @BeforeClass
    public static void setUpClass() {
        Product product = new Product("Wood");
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
    public void testSetMaterialCosta() throws Exception {
        BigDecimal cost = new BigDecimal("1.25");
        BigDecimal laborCost = new BigDecimal("1.50");
        
        Product product = new Product("Wood");
        product.setCostPerSqFoot(cost);
        product.setLaborCostPerSqFoot(laborCost);
        
        service.setMaterialCost(product.getProductType());
    }
    
    @Test
    public void testSetLaborCost() throws Exception {
        BigDecimal cost = new BigDecimal("1.25");
        BigDecimal laborCost = new BigDecimal("1.50");
        
        Product product = new Product("Wood");
        product.setCostPerSqFoot(cost);
        product.setLaborCostPerSqFoot(laborCost);
        
        service.setLaborCost(product.getProductType());
    }
}
