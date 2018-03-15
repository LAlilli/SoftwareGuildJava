/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.VendingMachine;
import java.util.List;

/**
 *
 * @author LA-San
 */
public interface VendingMachineServiceLayer {

    void addItem(VendingMachine allItems) throws VendingMachinePersistenceException;
    
    List<VendingMachine> getAllItems() throws VendingMachinePersistenceException;
    
    VendingMachine removeItem(int numberOfItem, String itemName, String itemID) throws VendingMachinePersistenceException;
    
    VendingMachine getItem(String itemName) throws VendingMachinePersistenceException;
    
    void insertCoin(double userMoney) throws VendingMachinePersistenceException;
    
    VendingMachine selectItem(String itemID) throws VendingMachinePersistenceException;
    
    double getMachineBalance() throws VendingMachinePersistenceException;
}
