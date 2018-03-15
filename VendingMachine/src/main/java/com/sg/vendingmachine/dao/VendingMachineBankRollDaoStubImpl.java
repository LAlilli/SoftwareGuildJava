/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author LA-San
 */
public class VendingMachineBankRollDaoStubImpl implements VendingMachineBankRollDao {
  
    double machineMoney;
    
    public VendingMachineBankRollDaoStubImpl(){
        machineMoney = 4;
    }

    @Override
    public double getMachineBalance() throws VendingMachinePersistenceException {
        return machineMoney;
    }

    @Override
    public void addMachineBalance(double userMoney) throws VendingMachinePersistenceException {
        machineMoney += userMoney;
    }

    @Override
    public void writeBankRoll() throws VendingMachinePersistenceException {
        
    }
}
