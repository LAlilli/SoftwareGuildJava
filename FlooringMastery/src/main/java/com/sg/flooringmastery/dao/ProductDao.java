/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import java.math.BigDecimal;


/**
 *
 * @author LA-San
 */
public interface ProductDao {
    void loadProductData() throws FlooringMasteryPersistenceException;
    boolean validateUserProductData(String productType) throws FlooringMasteryPersistenceException;
    BigDecimal readMaterialCostByProductType(String productType) throws FlooringMasteryPersistenceException;
    BigDecimal readLaborCostByProductType(String productType) throws FlooringMasteryPersistenceException;
}
