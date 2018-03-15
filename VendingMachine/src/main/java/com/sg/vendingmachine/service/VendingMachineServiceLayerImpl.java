/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineBankRollDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingMachine;
import java.util.List;
import com.sg.vendingmachine.dao.VendingMachineInventoryDao;

/**
 *
 * @author LA-San
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    VendingMachineInventoryDao dao;
    
    private VendingMachineAuditDao auditDao;
    
    private VendingMachineBankRollDao bankrollDao;
   
    public VendingMachineServiceLayerImpl(VendingMachineInventoryDao dao, VendingMachineAuditDao auditDao, VendingMachineBankRollDao bankrollDao) {
        this.dao = dao;
        this.auditDao = auditDao;
        this.bankrollDao = bankrollDao;
    }
    
    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public VendingMachine removeItem(int numberOfItem, String itemName, String itemID) throws VendingMachinePersistenceException {
        VendingMachine removedItem = dao.removeItem(numberOfItem, itemName, itemID);
        // Write to audit log
        auditDao.writeAuditEntry(numberOfItem + " of " + itemName + " REMOVED.");
        return dao.removeItem(numberOfItem, itemName, itemID);
    }

    @Override
    public void addItem(VendingMachine allItems) throws VendingMachinePersistenceException {
        if (dao.getItem(allItems.getItemID()) != null) {
            System.out.println("Error - item already exists.");
        }

        dao.addItem(allItems.getItemID(), allItems);

        auditDao.writeAuditEntry(
            "Item " + allItems.getItemID() + " Added.");
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        return dao.getItem(itemID);
    }

    @Override
    public void insertCoin(double userMoney) throws VendingMachinePersistenceException {
        bankrollDao.addMachineBalance(userMoney);
        bankrollDao.writeBankRoll();
    }

    @Override
    public VendingMachine selectItem(String itemID) throws VendingMachinePersistenceException {        
        return dao.getItem(itemID);
    }

    @Override
    public double getMachineBalance() throws VendingMachinePersistenceException {
        double userChange = bankrollDao.getMachineBalance();
        
        return userChange;
    }
}
