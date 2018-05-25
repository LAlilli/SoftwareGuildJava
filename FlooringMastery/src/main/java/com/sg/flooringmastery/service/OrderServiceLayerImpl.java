/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchProductException;
import com.sg.flooringmastery.dao.NoSuchStateException;
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dto.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LA-San
 */
public class OrderServiceLayerImpl implements OrderServiceLayer {
    OrderDao daoOrder;
    private AuditDao auditDao;
    public static final String DELIMITER = "::";
    private TaxServiceLayer taxService;
    private ProductServiceLayer productService;
    
    public OrderServiceLayerImpl(OrderDao daoOrder, AuditDao auditDao, TaxServiceLayer taxService, ProductServiceLayer productService){
        this.daoOrder = daoOrder;
        this.auditDao = auditDao;
        this.taxService = taxService;
        this.productService = productService;
    }

    @Override
    public void addOrder(Order order) throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException { 
        validateOrderData(order);
        daoOrder.addOrder(order.getOrderNum(), order);
        
        auditDao.writeAuditEntry("Order " + order.getOrderNum() + " CREATED.");
    }

    @Override
    public void editOrder(int orderNum, Order order) throws FlooringMasteryDataValidationException, FlooringMasteryPersistenceException {
        validateOrderData(order);

        daoOrder.editOrder(order.getOrderNum(), order);

        auditDao.writeAuditEntry("Order " + order.getOrderNum() + " EDITED.");
    }

    @Override
    public Order removeOrder(int orderNum) throws FlooringMasteryPersistenceException {
        daoOrder.removeOrder(orderNum);
        // Write to audit log
        auditDao.writeAuditEntry("Order " + orderNum + " REMOVED.");
        return daoOrder.removeOrder(orderNum);
    }

    @Override
    public Order getOrder(int orderNum, LocalDate date) throws FlooringMasteryPersistenceException {
        return daoOrder.getOrder(orderNum, date);
    }

    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        return daoOrder.getAllOrders();
    }

    @Override
    public void validateOrderData(Order order) throws FlooringMasteryDataValidationException {
        if (order.getOrderNum() == 0
            || order.getCustomerName() == null
            || order.getCustomerName().trim().length() == 0
            || order.getState() == null
            || order.getState().trim().length() == 0
            || order.getProductType() == null
            || order.getProductType().trim().length() == 0
            || order.getDate() == null) {

        throw new FlooringMasteryDataValidationException (
            "ERROR: All fields are required.");
        }
    }

    @Override
    public void saveCurrentWork(Order order) throws FlooringMasteryPersistenceException {
        PrintWriter out;
        
        daoOrder.getOrder(order.getOrderNum(), order.getDate());
        
        String fileDate = printFormat(order.getDate());
        try {
	     File file = new File("Orders_" + fileDate + ".txt");
             out = new PrintWriter(new FileWriter(file, true));
             
            List<Order> orderList = this.getAllOrders();
                for (Order currentOrder : orderList) {
                // write the order object to the file
                out.println(currentOrder.getOrderNum() + DELIMITER
                        + currentOrder.getCustomerName() + DELIMITER 
                        + currentOrder.getState() + DELIMITER
                        + currentOrder.getStateTax() + DELIMITER
                        + currentOrder.getProductType() + DELIMITER
                        + currentOrder.getArea() + DELIMITER
                        + currentOrder.getCostPerSqFoot() + DELIMITER
                        + currentOrder.getLaborCostPerSqFoot() + DELIMITER
                        + currentOrder.getMaterialCost() + DELIMITER
                        + currentOrder.getLaborCost() + DELIMITER
                        + currentOrder.getTax() + DELIMITER
                        + currentOrder.getTotal() + DELIMITER
                        + currentOrder.getDate().toString());
                // force PrintWriter to write line to the file
                out.flush();
            }
                
            // Clean up
            out.close();
             
             boolean fvar = file.createNewFile();
	     if (fvar){
	          System.out.println("File has been created successfully");
	     }
             else if (!fvar){
	          System.out.println("File already present at the specified location");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
    }

    public String printFormat(LocalDate date)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String tempdate = date.format(dateFormat);
        return tempdate.replaceAll("-", "");
    }
    
    @Override
    public int generateOrderNumber(Order order) throws FlooringMasteryPersistenceException {
        daoOrder.generateOrderNum(order);
        
        return order.getOrderNum();
    }
    
    @Override
    public BigDecimal calculateTax(Order order) throws FlooringMasteryPersistenceException, NoSuchStateException {
        BigDecimal stateTax = taxService.validateUserTaxData(order.getState()); 
        
        BigDecimal totalTax = stateTax.add(order.getLaborCost()).add(order.getMaterialCost());
        
        return totalTax;
    }
    
    @Override
    public BigDecimal calculateLaborCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException {
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(order.getProductType()); 
        
        BigDecimal totalLaborCost = laborCostPerSqFoot.multiply(order.getArea());
        
        return totalLaborCost;
    }

    @Override
    public BigDecimal calculateMaterialCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException {
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(order.getProductType()); 
        
        BigDecimal totalMaterialCost = materialCostPerSqFoot.multiply(order.getArea());
        
        return totalMaterialCost;
    }

    @Override
    public BigDecimal calculateTotal(Order order) throws FlooringMasteryPersistenceException {
        
        BigDecimal total = order.getMaterialCost().add(order.getLaborCost()).add(order.getTax());
       
        return total;
    }  
}

