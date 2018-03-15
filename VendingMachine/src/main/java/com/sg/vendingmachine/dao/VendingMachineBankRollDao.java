/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.BankRoll;

/**
 *
 * @author LA-San
 */
public interface VendingMachineBankRollDao {
    double getMachineBalance() throws VendingMachinePersistenceException;
    
    void addMachineBalance(double userMoney) throws VendingMachinePersistenceException;

    void writeBankRoll() throws VendingMachinePersistenceException;
}
