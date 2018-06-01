/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
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
public class ProductDaoTest {
    
    private ProductDao dao = new ProductDaoFileImpl();
    
    public ProductDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
       dao.loadProductData();
    }
    
    @After
    public void tearDown() {

    }

    @Test
    public void testValidateUserProductData() throws Exception {
        Product onlyProductData = new Product();
        onlyProductData.setProductType("Wood");
        onlyProductData.setCostPerSqFoot(new BigDecimal(2.25));
        onlyProductData.setLaborCostPerSqFoot(new BigDecimal(2.10));
        
        dao.validateUserProductData(onlyProductData.getProductType());
        
        assertEquals("Wood", onlyProductData.getProductType());
    }
    
    @Test
    public void testReadMaterialCost() throws Exception {
        Product onlyProductData = new Product();
        onlyProductData.setProductType("Wood");
        onlyProductData.setCostPerSqFoot(new BigDecimal(5.15));
        onlyProductData.setLaborCostPerSqFoot(new BigDecimal(4.75));
        
        dao.readMaterialCostByProductType(onlyProductData.getProductType());

        assertEquals(5.15, onlyProductData.getCostPerSqFoot().doubleValue(),2);
    }
    
    @Test
    public void testReadLaborCost() throws Exception {
        Product onlyProductData = new Product();
        onlyProductData.setProductType("Wood");
        onlyProductData.setCostPerSqFoot(new BigDecimal(5.15));
        onlyProductData.setLaborCostPerSqFoot(new BigDecimal(4.75));
        
        dao.readLaborCostByProductType(onlyProductData.getProductType());
        
        assertEquals(4.75, onlyProductData.getLaborCostPerSqFoot().doubleValue(), 2);
    }
}
