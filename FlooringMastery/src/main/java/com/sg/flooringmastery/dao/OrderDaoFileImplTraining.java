/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class OrderDaoFileImplTraining {
    
    private Map<Integer, Order> orders = new HashMap<>();
    public static final String ORDER_FILE = "orders.txt";
    public static final String DELIMITER = "::";
    
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        loadOrderData();
        return new ArrayList<Order>(orders.values());
    }
    
    public Order getOrder(int orderNum, LocalDate date) throws FlooringMasteryPersistenceException {
        loadOrderData();
        return orders.get(orderNum);
    }

    public void loadOrderData() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        
        File dir = new File("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\");
        
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;
        
            try
            {
                String fileList[] = dir.list();
                
                for(int i = 0; i < fileList.length; i++)
                {
                    File orderFile = new File("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\" + fileList[i].replace("\\", "\\\\"));
                    //System.out.println("FILE = " + orderFile.toString());
                        try
                        {
                            scanner = new Scanner(new BufferedReader(new FileReader(orderFile)));
                            
                            while (scanner.hasNextLine())
                            {
                                try
                                {
                                    // get the next line in the file
                                    currentLine = scanner.nextLine();
                                    // break up the line into tokens
                                    currentTokens = currentLine.split(DELIMITER);        

                                    Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));

                                    // Set the remaining vlaues on currentOrder manually
                                    currentOrder.setCustomerName(currentTokens[1]);
                                    currentOrder.setState(currentTokens[2]);
                                    currentOrder.setStateTax(new BigDecimal(currentTokens[3]));
                                    currentOrder.setProductType(currentTokens[4]);
                                    currentOrder.setArea(new BigDecimal(currentTokens[5]));
                                    currentOrder.setCostPerSqFoot(new BigDecimal(currentTokens[6]));
                                    currentOrder.setLaborCostPerSqFoot(new BigDecimal(currentTokens[7]));
                                    currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
                                    currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
                                    currentOrder.setTax(new BigDecimal(currentTokens[10]));
                                    currentOrder.setTotal(new BigDecimal(currentTokens[11]));
                                    currentOrder.setDate(LocalDate.parse(currentTokens[12]));


                                    orders.put(currentOrder.getOrderNum(), currentOrder);
                                }
                                catch (InputMismatchException e)
                                {
                                    System.out.println("-_- Data mismatch - unable to scan.");

                                }
                            }
                        }
                        catch (FileNotFoundException e)
                        {
                            throw new FileNotFoundException();
                        }
                        
                // close scanner
                scanner.close();
                }
            }
            
        catch (FileNotFoundException e)
        {
            throw new FlooringMasteryPersistenceException("-_- Could not load order data into memory.", e);
        }
    }
}
