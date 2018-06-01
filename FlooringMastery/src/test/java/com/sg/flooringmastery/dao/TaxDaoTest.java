/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
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
public class TaxDaoTest {
    
    private TaxDao dao = new TaxDaoFileImpl();
    
    public TaxDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        dao.loadTaxData();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidateUserTaxData() throws Exception {
        Tax onlyTaxData = new Tax();
        onlyTaxData.setState("OH");
        onlyTaxData.setStateTax(new BigDecimal(6.25));
        
        dao.validateUserTaxData(onlyTaxData.getState());
        
        assertEquals("OH", onlyTaxData.getState());
    }  
    
    @Test
    public void testSetStateTax() throws Exception {
        Tax onlyTaxData = new Tax();
        onlyTaxData.setState("OH");
        onlyTaxData.setStateTax(new BigDecimal(6.25));
        
        dao.setStateTax(onlyTaxData.getState());
        
        assertEquals(6.25, onlyTaxData.getStateTax().doubleValue(), 2);
    } 
}
