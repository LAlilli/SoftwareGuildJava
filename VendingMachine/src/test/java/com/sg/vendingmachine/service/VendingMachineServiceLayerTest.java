/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineBankRollDao;
import com.sg.vendingmachine.dao.VendingMachineBankRollDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineInventoryDao;
import com.sg.vendingmachine.dao.VendingMachineInventoryDaoStubImpl;
import com.sg.vendingmachine.dto.VendingMachine;
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
public class VendingMachineServiceLayerTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerTest() {
        VendingMachineInventoryDao dao = new VendingMachineInventoryDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
        VendingMachineBankRollDao bankrollDao = new VendingMachineBankRollDaoImpl();
        
        service = new VendingMachineServiceLayerImpl(dao, auditDao, bankrollDao);
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
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, service.getAllItems().size());
    }

    /**
     * Test of addItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testAddItem() throws Exception {
        VendingMachine item = new VendingMachine("A1");
        item.setItemName("Snickers");
        item.setItemCost(1.99);
        item.setNumberOfItem(10);
        
        service.addItem(item);
    }
    
    /**
     * Test of getItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
        VendingMachine item = service.getItem("B5");
        assertNull(item);
    }
    
    /**
     * Test of removeItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testRemoveItem() throws Exception {
        VendingMachine item = service.removeItem(1, "Crackers", "B5");
        assertEquals(6, 6);
    }
}
