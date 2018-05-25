/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import java.math.BigDecimal;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class TaxDaoFileImpl implements TaxDao {
    
    public static final String TAX_FILE = "C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\data\\Taxes.txt";
    public static final String DELIMITER = ",";
    private Map<String, Tax> taxData = new HashMap<>();

    @Override
    public void loadTaxData() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load tax data into memory.", e);
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

            
            Tax tax = new Tax(currentTokens[0]);
            // Set the remaining values on tax manually
            tax.setStateTax(new BigDecimal(currentTokens[1]));

            taxData.put(tax.getState(), tax);
        } catch (InputMismatchException e){
                System.out.println("-_- Data mismatch - unable to scan.");
            }

        }
        // close scanner
        scanner.close();
    }

    @Override
    public boolean validateUserTaxData(String state) throws FlooringMasteryPersistenceException {
        return taxData.containsKey(state.toUpperCase());
    }
    
    @Override
    public BigDecimal setStateTax(String state) throws FlooringMasteryPersistenceException {
        Tax tax = taxData.get(state.toUpperCase());
        
        return tax.getStateTax();
    }
}
