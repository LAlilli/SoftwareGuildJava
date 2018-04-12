/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.BankRoll;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class VendingMachineBankRollDaoImpl implements VendingMachineBankRollDao {
    private double balance;
    public static final String BANKROLL_FILE = "bankroll.txt";

    @Override
    public double getMachineBalance() throws VendingMachinePersistenceException {
        loadBankRoll();
        return balance;
    }
    
    @Override
    public void addMachineBalance(double userMoney) throws VendingMachinePersistenceException {
        loadBankRoll();
        BankRoll newBalance = new BankRoll();
        newBalance.setMachineMoney(userMoney + newBalance.getMachineMoney());
        balance = newBalance.getMachineMoney();
        writeBankRoll();
    }
    
    private void loadBankRoll() throws VendingMachinePersistenceException{
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(BANKROLL_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                "-_- Could not load data into memory.", e);
        }
        
        while (scanner.hasNextDouble()) {
            try {
                // get the next line in the file
                balance = scanner.nextDouble();
                
            } catch (InputMismatchException e){
                System.out.println("-_- Data mismatch - unable to scan.");
            }
        }
        // close scanner
        scanner.close();
    }
    
    @Override
    public void writeBankRoll() throws VendingMachinePersistenceException{
        PrintWriter out;

        //try catch block in case not able to save info to file
        try {
            out = new PrintWriter(new FileWriter(BANKROLL_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save inventory data.", e);
        }

        //create variable to save money
        double machineBalance = this.getMachineBalance();
        out.println(machineBalance);
        out.flush();

        // Clean up
        out.close();
    }
}
