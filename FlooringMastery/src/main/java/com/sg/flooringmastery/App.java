/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FlooringMasteryController;
import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.AuditDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.OrderDaoFileImplProduction;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.ProductDaoFileImpl;
import com.sg.flooringmastery.dao.TaxDao;
import com.sg.flooringmastery.dao.TaxDaoFileImpl;
import com.sg.flooringmastery.service.FlooringMasteryDataValidationException;
import com.sg.flooringmastery.service.OrderServiceLayer;
import com.sg.flooringmastery.service.OrderServiceLayerImpl;
import com.sg.flooringmastery.service.ProductServiceLayer;
import com.sg.flooringmastery.service.ProductServiceLayerImpl;
import com.sg.flooringmastery.service.TaxServiceLayer;
import com.sg.flooringmastery.service.TaxServiceLayerImpl;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOConsoleImpl;

/**
 *
 * @author LA-San
 */
public class App {
    public static void main(String[] args) throws FlooringMasteryPersistenceException, FlooringMasteryDataValidationException{
        UserIO myIO = new UserIOConsoleImpl();
        FlooringMasteryView myView = new FlooringMasteryView(myIO);
        
        OrderDao orderDao = new OrderDaoFileImplProduction();
        AuditDao auditDao = new AuditDaoFileImpl();
        ProductDao productDao = new ProductDaoFileImpl();
        TaxDao taxDao = new TaxDaoFileImpl();
        
        ProductServiceLayer productService = new ProductServiceLayerImpl(productDao);
        TaxServiceLayer taxService = new TaxServiceLayerImpl(taxDao);
        OrderServiceLayer orderService = new OrderServiceLayerImpl(orderDao, auditDao, taxService, productService);
        
        FlooringMasteryController controller = new FlooringMasteryController(myView, orderService, taxService, productService);
        controller.run();
    }
    
    //method to determine if prod or training mode based on user selection
}
