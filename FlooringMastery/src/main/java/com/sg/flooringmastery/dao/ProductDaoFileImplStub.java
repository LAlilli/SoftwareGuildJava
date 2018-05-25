/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;

/**
 *
 * @author LA-San
 */
public class ProductDaoFileImplStub implements ProductDao {

    Product onlyProductData;
    
    @Override
    public void loadProductData() {
        
    }

    @Override
    public boolean validateUserProductData(String productType) {
        //update to real data
        return true;
    }

    @Override
    public BigDecimal readMaterialCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        BigDecimal materialCost = new BigDecimal(0);
        
        return materialCost;
    }

    @Override
    public BigDecimal readLaborCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        BigDecimal laborCost = new BigDecimal(0);
        
        return laborCost;
    }
}
