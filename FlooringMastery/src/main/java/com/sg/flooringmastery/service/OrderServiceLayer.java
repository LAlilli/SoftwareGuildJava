/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchProductException;
import com.sg.flooringmastery.dao.NoSuchStateException;
import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LA-San
 */
public interface OrderServiceLayer {
    void addOrder(Order order) throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException;

    void editOrder(int orderNum, Order order) throws FlooringMasteryDataValidationException, FlooringMasteryPersistenceException;

    Order removeOrder(int orderNum) throws FlooringMasteryPersistenceException;

    Order getOrder(int orderNum, LocalDate date) throws FlooringMasteryPersistenceException;

    List<Order> getAllOrders() throws FlooringMasteryPersistenceException;

    void validateOrderData(Order order) throws FlooringMasteryDataValidationException;

    void saveCurrentWork(Order order) throws FlooringMasteryPersistenceException;

    int generateOrderNumber(Order order) throws FlooringMasteryPersistenceException;
    
    BigDecimal calculateTax(Order order) throws FlooringMasteryPersistenceException, NoSuchStateException;
    
    BigDecimal calculateLaborCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException;
    
    BigDecimal calculateMaterialCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException;

    BigDecimal calculateTotal(Order order) throws FlooringMasteryPersistenceException;
}
