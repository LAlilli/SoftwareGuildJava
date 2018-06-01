/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class ProductDaoFileImpl implements ProductDao {
    
    public static final String PRODUCT_FILE = "C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\data\\Products.txt";
    public static final String DELIMITER = ",";
    private Map<String, Product> productData = new HashMap<>();

    @Override
    public void loadProductData() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(PRODUCT_FILE)));
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

            
            Product product = new Product(currentTokens[0]);
            // Set the remaining vlaues on product manually
            product.setCostPerSqFoot(new BigDecimal(currentTokens[1]));
            product.setLaborCostPerSqFoot(new BigDecimal(currentTokens[2]));

            productData.put(product.getProductType(), product);
        } catch (InputMismatchException e){
                System.out.println("-_- Data mismatch - unable to scan.");
            }

        }
        // close scanner
        scanner.close();
    }

    @Override
    public boolean validateUserProductData(String productType) throws FlooringMasteryPersistenceException {
        return productData.containsKey(productType);
    } 
    
    @Override
    public BigDecimal readMaterialCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        Product product = productData.get(productType);
        
        return product.getCostPerSqFoot();
    }
    
    @Override
    public BigDecimal readLaborCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        Product product = productData.get(productType);
        
        return product.getLaborCostPerSqFoot();
    }
}
