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
    
    public ProductDaoFileImplStub() {
        onlyProductData = new Product();
        onlyProductData.setProductType("Wood");
        onlyProductData.setCostPerSqFoot(new BigDecimal(2.25));
        onlyProductData.setLaborCostPerSqFoot(new BigDecimal(2.10));
    }
    
    @Override
    public void loadProductData() {
        
    }

    @Override
    public boolean validateUserProductData(String productType) {
        if(onlyProductData.getProductType().equals(productType)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BigDecimal readMaterialCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        return onlyProductData.getCostPerSqFoot();
    }

    @Override
    public BigDecimal readLaborCostByProductType(String productType) throws FlooringMasteryPersistenceException {
        return onlyProductData.getLaborCostPerSqFoot();
    }
}
