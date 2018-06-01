/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchProductException;
import com.sg.flooringmastery.dao.NoSuchStateException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringMasteryDataValidationException;
import com.sg.flooringmastery.service.OrderServiceLayer;
import com.sg.flooringmastery.service.ProductServiceLayer;
import com.sg.flooringmastery.service.TaxServiceLayer;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class FlooringMasteryController {
    FlooringMasteryView view;
    private OrderServiceLayer service;
    private TaxServiceLayer taxService;
    private ProductServiceLayer productService;
    
    public FlooringMasteryController(FlooringMasteryView view, OrderServiceLayer service, TaxServiceLayer taxService, ProductServiceLayer productService){
        this.service = service;
        this.view = view;
        this.taxService = taxService;
        this.productService = productService;
    }

    public void run() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, FileNotFoundException {
        boolean keepGoing = true;
        int menuSelection = 0;
        int modeSelection = 0;
        int trainingMenuSelection = 0;
        
        modeSelection = getModeSelection();
        if(modeSelection == 1){
            view.displayProductionModeBanner();
            try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        try {
                        addOrder();
                        } catch (NoSuchStateException e) {
                            view.displayErrorMessage(e.getMessage());
                        } catch (NoSuchProductException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                        editOrder();
                        } catch (NoSuchStateException e) {
                            view.displayErrorMessage(e.getMessage());
                        } catch (NoSuchProductException e) {
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        viewOrder();
                        break;
                    case 6:
                        saveCurrentWork();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                    }
                }
            exitMessage();
        } catch (FlooringMasteryPersistenceException e) {
                view.displayErrorMessage(e.getMessage());
            }
        } else if(modeSelection == 2){
            view.displayTrainingModeBanner();
            
            try {
            while (keepGoing) {
                trainingMenuSelection = getTrainingMenuSelection();
                switch (trainingMenuSelection) {
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        viewOrder();
                        break;
                    case 3:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                    }
                }
                exitMessage();
            } catch (FlooringMasteryPersistenceException e) {
                    view.displayErrorMessage(e.getMessage());
            }
        }
    }

    //menu selections
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private int getModeSelection(){
        return view.printModeAndSelection();
    }
    
    private int getTrainingMenuSelection(){
        return view.printTrainingMenuAndSelection();
    }
    
    //add order
    private void addOrder() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, NoSuchStateException, NoSuchProductException {
        
        view.displayAddOrderBanner();
        
        Order newOrder = view.getNewOrderInfo();
        
        //load tax and product data
        taxService.loadTaxData();
        productService.loadProductData();
        
        //calculate costs
        BigDecimal stateTax = taxService.validateUserTaxData(newOrder.getState());
        newOrder.setStateTax(stateTax);
        
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(newOrder.getProductType());
        newOrder.setCostPerSqFoot(materialCostPerSqFoot);
        
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(newOrder.getProductType());
        newOrder.setLaborCostPerSqFoot(laborCostPerSqFoot);
        
        BigDecimal laborCost = service.calculateLaborCost(newOrder);
        newOrder.setLaborCost(laborCost);
        
        BigDecimal materialCost = service.calculateMaterialCost(newOrder);
        newOrder.setMaterialCost(materialCost);
        
        BigDecimal totalTax = service.calculateTax(newOrder);
        newOrder.setTax(totalTax);
        
        BigDecimal total = service.calculateTotal(newOrder);
        newOrder.setTotal(total);
        
        //generate order number
        int orderNum = service.generateOrderNumber(newOrder);
        newOrder.setOrderNum(orderNum);
        
        //show summary of order
        view.displayOrder(newOrder); 
        
        //check that user wants to save work
        String response = view.displaySaveWorkResponse();
        if(response.equals("y")){
            view.displaySaveWorkBanner();
            service.addOrder(newOrder);
            view.displayAddSuccessBanner();
            service.saveCurrentWork(newOrder);
        } else {
            view.displayNoSavedWork();
            
            //save to hashmap if want to save later
            service.addOrder(newOrder);
        }
    }
    
    //search by order number / date
    private void viewOrder() throws FlooringMasteryPersistenceException {
        view.displayGetOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        view.displayOrder(order);
    }
    
    //list all orders
    private void listOrders() throws FlooringMasteryPersistenceException {
        view.displayDisplayAllBanner();
        List<Order> orderList = service.getAllOrders();
        view.displayOrderList(orderList);
    }
    
    //remove order
    private void removeOrder() throws FlooringMasteryPersistenceException, FileNotFoundException {
        
        //retrieve order that user would like to remove
        view.displayRemoveOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        view.displayOrder(order);
        
        //check that user wants to remove order
        String response = view.displaySaveWorkResponse();
        if(response.equals("y")){
            view.displaySaveWorkBanner();
            service.removeOrder(order.getOrderNum());
            service.removeOrderContent(order);
            view.displayRemoveSuccessBanner();
        } else {
            view.displayNoSavedWork();
        }
    }
   
    //edit order
    private void editOrder() throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException, NoSuchStateException, NoSuchProductException, FileNotFoundException {
        
        //retrieve order that user would like to edit
        view.displayEditOrderBanner();
        int orderNum = view.getOrderNumChoice();
        LocalDate date = view.getOrderDate();
        Order order = service.getOrder(orderNum, date);
        
        view.editOrder(order);
        
        //load tax and product data
        taxService.loadTaxData();
        productService.loadProductData();
        
        //calculate costs
        BigDecimal stateTax = taxService.validateUserTaxData(order.getState());
        order.setStateTax(stateTax);
        
        BigDecimal materialCostPerSqFoot = productService.setMaterialCost(order.getProductType());
        order.setCostPerSqFoot(materialCostPerSqFoot);
        
        BigDecimal laborCostPerSqFoot = productService.setLaborCost(order.getProductType());
        order.setLaborCostPerSqFoot(laborCostPerSqFoot);
        
        BigDecimal laborCost = service.calculateLaborCost(order);
        order.setLaborCost(laborCost);
        
        BigDecimal materialCost = service.calculateMaterialCost(order);
        order.setMaterialCost(materialCost);
        
        BigDecimal totalTax = service.calculateTax(order);
        order.setTax(totalTax);
        
        BigDecimal total = service.calculateTotal(order);
        order.setTotal(total);
        
        //check that user wants to save updated work
        String response = view.displaySaveWorkResponse();
        if(response.equals("y")){
            view.displaySaveWorkBanner();
            service.editOrder(order.getOrderNum(), order);
            service.removeOrderContent(order);
            service.saveCurrentWork(order);
            view.displayEditSuccessBanner();
        } else {
            view.displayNoSavedWork();
            
            //update hashmap in case want to save
            service.editOrder(order.getOrderNum(), order);
        } 
    }
    
    //save current work
    private void saveCurrentWork() throws FlooringMasteryPersistenceException {
        List<Order> orderList = service.getAllOrders();
        view.displaySaveWorkBanner();
        for(int i = 0; i < orderList.size(); ++i)
        {
            service.saveCurrentWork(orderList.get(i));
        }
        view.displaySaveWorkSuccessBanner();
    }
        
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
