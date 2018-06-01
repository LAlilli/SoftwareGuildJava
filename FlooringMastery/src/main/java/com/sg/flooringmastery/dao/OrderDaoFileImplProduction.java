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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class OrderDaoFileImplProduction implements OrderDao {

    private Map<Integer, Order> orders = new HashMap<>();
    public static final String DELIMITER = "::";
    
    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        loadOrderData();
        return new ArrayList<Order>(orders.values());
    }

    @Override
    public Order addOrder(int orderNum, Order order) throws FlooringMasteryPersistenceException {
        Order newOrder = orders.put(orderNum, order);
        return newOrder;
    }

    @Override
    public Order getOrder(int orderNum, LocalDate date) throws FlooringMasteryPersistenceException {
        loadOrderData();
        return orders.get(orderNum);
    }

    @Override
    public Order editOrder(int orderNum, Order order) throws FlooringMasteryPersistenceException {
        Order editOrder = orders.put(orderNum, order);
        return editOrder;
    }

    @Override
    public Order removeOrder(int orderNum) throws FlooringMasteryPersistenceException {
        Order removedOrder = orders.remove(orderNum);
        return removedOrder;
    }

    @Override
    public int generateOrderNum(Order order) throws FlooringMasteryPersistenceException {
        loadOrderData();
        
        //comparator for Integer of collection
        Comparator<Integer> keyCompare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // find max key
        Integer maxKey = Collections.max(orders.keySet(), keyCompare);
        //if not key, set to 1
        if(maxKey == null){
            order.setOrderNum(1);
        } else {
            //if max key, set to +1 of max key value
            order.setOrderNum(maxKey + 1);
        }

        return order.getOrderNum();
    }
    
    @Override
    public void loadOrderData() throws FlooringMasteryPersistenceException {
        //determine directory where files will be read from
        File dir = new File("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\");
        
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;
        Scanner scanner;
        
            try
            {
                //stuff directory list of files into a string array to read below
                String fileList[] = dir.list();
                
                //iterate through file list
                for(int i = 0; i < fileList.length; i++)
                {
                    //get specific text file and assign to variable
                    File orderFile = new File("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\" + fileList[i].replace("\\", "\\\\"));
                        try
                        {
                            //read next lines in file
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

                                    //put into hashmap for later reference
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
