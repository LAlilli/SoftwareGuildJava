/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class VendingMachineInventoryDaoStubImpl implements VendingMachineInventoryDao {
    VendingMachine onlyItem;
    List<VendingMachine> allItems = new ArrayList<>();
    
    public VendingMachineInventoryDaoStubImpl(){
        onlyItem = new VendingMachine("A1");
        onlyItem.setItemName("Snickers");
        onlyItem.setItemCost(1.99);
        onlyItem.setNumberOfItem(10);
        
        allItems.add(onlyItem);
    }

    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        return allItems;
    }

    @Override
    public VendingMachine removeItem(int numberOfItem,String itemName, String itemID) throws VendingMachinePersistenceException {
        if (itemID.equals(onlyItem.getItemID())){
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public VendingMachine addItem(String itemID, VendingMachine allItems) throws VendingMachinePersistenceException {
        if (itemID.equals(onlyItem.getItemID())){
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        if (itemID.equals(onlyItem.getItemID())){
            return onlyItem;
        } else {
            return null;
        }
    }
}
