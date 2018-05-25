/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

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
public class VendingMachineBankRollDaoTest {
    
    private VendingMachineBankRollDao dao = new VendingMachineBankRollDaoImpl();
    
    public VendingMachineBankRollDaoTest() {
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
        dao = null;
        assertNull(dao);
    }

    /**
     * Test of getMachineBalance method, of class VendingMachineBankRollDao.
     */
    @Test
    public void testGetMachineBalance() throws Exception {
        double money = 0.0;
        
        double fromDao = dao.getMachineBalance();
        
        assertEquals(money, fromDao, 0.00);
    }
    
    /**
     * Test of getMachineBalance method, of class VendingMachineBankRollDao.
     */
    @Test
    public void testAddMachineBalance() throws Exception {
        double money = 0.0;
        
        dao.addMachineBalance(money);
        
        assertEquals(0.0, money, 0.00);
    }
}
