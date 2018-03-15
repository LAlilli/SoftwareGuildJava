/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachine;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LA-San
 */
public class VendingMachineInventoryDaoTest {
    
    private VendingMachineInventoryDao dao = new VendingMachineInventoryDaoFileImpl();
    
    public VendingMachineInventoryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws VendingMachinePersistenceException {
        List<VendingMachine> allItems = dao.getAllItems();
        for (VendingMachine item : allItems){
            dao.removeItem(item.getNumberOfItem(), item.getItemName(), item.getItemID());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of removeItem method, of class VendingMachineInventoryDao
     */
    @org.junit.Test
    public void testRemoveItem() throws Exception {
        VendingMachine item1 = new VendingMachine("B5");
        item1.setItemName("Crackers");
        item1.setItemCost(1.99);
        item1.setNumberOfItem(6);
        
        dao.addItem(item1.getItemID(), item1);
        
        VendingMachine item2 = new VendingMachine("A4");
        item2.setItemName("Roll-up");
        item2.setItemCost(0.99);
        item2.setNumberOfItem(10);
        
        dao.addItem(item2.getItemID(), item2);
        
        assertEquals(6, item1.getNumberOfItem());
        assertEquals(10, item2.getNumberOfItem());
        
        dao.removeItem(item1.getNumberOfItem(), item1.getItemName(), item1.getItemID());
        assertEquals(6, item1.getNumberOfItem());
        
        dao.removeItem(item2.getNumberOfItem(), item2.getItemName(), item2.getItemID());
        assertEquals(10, item2.getNumberOfItem());
    }

    /**
     * Test of add and get item method, of class VendingMachineInventoryDao.
     */
    @org.junit.Test
    public void testAddGetItem() throws Exception {
        VendingMachine item = new VendingMachine("B5");
        item.setItemName("Crackers");
        item.setItemCost(1.99);
        item.setNumberOfItem(6);
        
        dao.addItem(item.getItemID(), item);
        
        VendingMachine fromDao = dao.getItem(item.getItemID());
        
        assertEquals(item, fromDao);
    }
    
    /**
     * Test of ListAllItems method, of class VendingMachineInventoryDao.
     */
    @org.junit.Test
    public void testListItems() throws Exception {
        VendingMachine item1 = new VendingMachine("B5");
        item1.setItemName("Crackers");
        item1.setItemCost(1.99);
        item1.setNumberOfItem(6);
        
        dao.addItem(item1.getItemID(), item1);
        
        VendingMachine item2 = new VendingMachine("A4");
        item2.setItemName("Roll-up");
        item2.setItemCost(0.99);
        item2.setNumberOfItem(10);
        
        dao.addItem(item2.getItemID(), item2);
        
        assertEquals(10, dao.getAllItems().size());
    }
}
