/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachine;
import java.util.List;

/**
 *
 * @author LA-San
 */
public interface VendingMachineInventoryDao {
    
    VendingMachine addItem(String itemID, VendingMachine allItems) throws VendingMachinePersistenceException;
    
    List<VendingMachine> getAllItems() throws VendingMachinePersistenceException;
    
    VendingMachine removeItem(int numberOfItem, String itemName, String itemID) throws VendingMachinePersistenceException;
    
    VendingMachine getItem(String itemID) throws VendingMachinePersistenceException;
}
