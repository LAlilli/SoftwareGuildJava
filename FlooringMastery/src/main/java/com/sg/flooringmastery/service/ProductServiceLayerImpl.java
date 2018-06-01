/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchProductException;
import com.sg.flooringmastery.dao.ProductDao;
import java.math.BigDecimal;

/**
 *
 * @author LA-San
 */
public class ProductServiceLayerImpl implements ProductServiceLayer {
    
    ProductDao productDao;

    public ProductServiceLayerImpl(ProductDao dao) {
        this.productDao = dao;
    }

    public ProductServiceLayerImpl() {
        
    }

    @Override
    public void loadProductData() throws FlooringMasteryPersistenceException {
        productDao.loadProductData();
    }

    @Override
    public BigDecimal setMaterialCost (String productType) throws FlooringMasteryPersistenceException, NoSuchProductException {
        boolean correctProductType = productDao.validateUserProductData(productType);
        if(!correctProductType){
            throw new NoSuchProductException("NoSuchProductException: This product is not available.");
        } else {
            return productDao.readMaterialCostByProductType(productType);
        }
    }
    
    @Override
    public BigDecimal setLaborCost (String productType) throws FlooringMasteryPersistenceException, NoSuchProductException {
        boolean correctProductType = productDao.validateUserProductData(productType);
        if(!correctProductType){
            throw new NoSuchProductException("NoSuchProductException: This product is not available.");
        } else {
            return productDao.readLaborCostByProductType(productType);
        }
    }
}
