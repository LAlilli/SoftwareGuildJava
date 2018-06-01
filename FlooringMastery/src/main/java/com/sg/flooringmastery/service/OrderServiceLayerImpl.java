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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    }

    @Override
    public void editOrder(int orderNum, Order order) throws FlooringMasteryDataValidationException, FlooringMasteryPersistenceException {
        validateOrderData(order);

        daoOrder.removeOrder(orderNum);
        daoOrder.editOrder(order.getOrderNum(), order);
    }

    @Override
    public Order removeOrder(int orderNum) throws FlooringMasteryPersistenceException {
        daoOrder.removeOrder(orderNum);
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

    //validate order data/ user info provided
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

    //formatter for date
    public String printFormat(LocalDate date)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String tempdate = date.format(dateFormat);
        return tempdate.replaceAll("-", "");
    }
    
    //delete content for removing order
    @Override
    public void removeOrderContent(Order order) throws FlooringMasteryPersistenceException, FileNotFoundException {
        daoOrder.getOrder(order.getOrderNum(), order.getDate());
        
        String fileDate = printFormat(order.getDate());
        
        try {
            FileOutputStream writer = new FileOutputStream("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\Orders_" + fileDate + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception Occurred:");
	    e.printStackTrace();
        }
    }
    
    //save current work order
    @Override
    public void saveCurrentWork(Order order) throws FlooringMasteryPersistenceException {
        PrintWriter out;
        
        daoOrder.getOrder(order.getOrderNum(), order.getDate());
        
        String fileDate = printFormat(order.getDate());
        try {
	     File file = new File("C:\\repos\\lindsay-lilli-individual-work\\FlooringMastery\\orders\\Orders_" + fileDate + ".txt");
             out = new PrintWriter(new FileWriter(file, true));
             
                // write the order object to the file
                out.println(order.getOrderNum() + DELIMITER
                        + order.getCustomerName() + DELIMITER 
                        + order.getState() + DELIMITER
                        + order.getStateTax() + DELIMITER
                        + order.getProductType() + DELIMITER
                        + order.getArea() + DELIMITER
                        + order.getCostPerSqFoot() + DELIMITER
                        + order.getLaborCostPerSqFoot() + DELIMITER
                        + order.getMaterialCost() + DELIMITER
                        + order.getLaborCost() + DELIMITER
                        + order.getTax() + DELIMITER
                        + order.getTotal() + DELIMITER
                        + order.getDate().toString());
                // force PrintWriter to write line to the file
                out.flush();
            //}
                
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
    
    //generate order number
    @Override
    public int generateOrderNumber(Order order) throws FlooringMasteryPersistenceException {
        daoOrder.generateOrderNum(order);
        
        return order.getOrderNum();
    }
    
    //calculate total tax
    @Override
    public BigDecimal calculateTax(Order order) throws FlooringMasteryPersistenceException, NoSuchStateException {
        BigDecimal stateTax = taxService.validateUserTaxData(order.getState()); 
        
        BigDecimal totalTax = stateTax.add(order.getLaborCost()).add(order.getMaterialCost());
        
        return totalTax;
    }
    
    //calculate total labor cost
    @Override
    public BigDecimal calculateLaborCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException {
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(order.getProductType()); 
        
        BigDecimal totalLaborCost = laborCostPerSqFoot.multiply(order.getArea());
        
        return totalLaborCost;
    }

    //calculate total material cost
    @Override
    public BigDecimal calculateMaterialCost(Order order) throws FlooringMasteryPersistenceException, NoSuchProductException {
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(order.getProductType()); 
        
        BigDecimal totalMaterialCost = materialCostPerSqFoot.multiply(order.getArea());
        
        return totalMaterialCost;
    }

    //calculate total
    @Override
    public BigDecimal calculateTotal(Order order) throws FlooringMasteryPersistenceException {
        
        BigDecimal total = order.getMaterialCost().add(order.getLaborCost()).add(order.getTax());
       
        return total;
    }  
}

