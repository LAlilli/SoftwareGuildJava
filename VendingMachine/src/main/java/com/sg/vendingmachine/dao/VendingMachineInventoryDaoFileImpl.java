/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class VendingMachineInventoryDaoFileImpl implements VendingMachineInventoryDao {
    
    private Map<String, VendingMachine> vendingMachine = new HashMap<>();
    public static final String VENDINGMACHINE_FILE = "vendingMachineItems.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        loadVendingMachine();
        return new ArrayList<VendingMachine>(vendingMachine.values());
    }

    @Override
    public VendingMachine removeItem(int numberOfItem, String itemName, String itemID) throws VendingMachinePersistenceException {
        loadVendingMachine();
        VendingMachine item = vendingMachine.get(itemID);
        
        //iterate through hashmap and subtract number of item only if greater than 0
        Iterator i = vendingMachine.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry pair = (Map.Entry)i.next();
            if(pair.getKey().equals(item.getItemID()) && item.getNumberOfItem() > 0){
                item.setNumberOfItem(numberOfItem - 1);
            }
        }
        
        writeVendingMachine();
        return item;
    }

    @Override
    public VendingMachine addItem(String itemID, VendingMachine allItems) throws VendingMachinePersistenceException {
        VendingMachine newItem = vendingMachine.put(itemID, allItems);
        writeVendingMachine();
        return newItem;
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        loadVendingMachine();
	return vendingMachine.get(itemID);
    }
    
    private void loadVendingMachine() throws VendingMachinePersistenceException{
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(VENDINGMACHINE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;
        
        while (scanner.hasNextLine()) {
            try {
                // get the next line in the file
                currentLine = scanner.nextLine();
                // break up the line into tokens
                currentTokens = currentLine.split(DELIMITER);

                VendingMachine currentItem = new VendingMachine(currentTokens[0]);
                // Set the remaining vlaues on vendinmachine inventory manually
                currentItem.setItemName(currentTokens[1]);
                currentItem.setItemCost(Double.parseDouble(currentTokens[2]));
                currentItem.setNumberOfItem(Integer.parseInt(currentTokens[3]));

                // Put current iteminto the map using itemID as the key
                vendingMachine.put(currentItem.getItemID(), currentItem);   
            } catch (InputMismatchException e){
                System.out.println("-_- Data mismatch - unable to scan.");
            }
        }
        // close scanner
        scanner.close();
    }
    
    private void writeVendingMachine() throws VendingMachinePersistenceException{
        PrintWriter out;

        //try catch block in case not able to save info to file
        try {
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save item data.", e);
        }

        //create inventory list to save items with delimiter
        List<VendingMachine> vendingMachineList = this.getAllItems();
        for (VendingMachine currentItem : vendingMachineList) {
            // write the item object to the file
            out.println(currentItem.getItemID() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemCost() + DELIMITER
                    + currentItem.getNumberOfItem());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
