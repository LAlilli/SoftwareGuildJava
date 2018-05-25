/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchProductException;
import java.math.BigDecimal;

/**
 *
 * @author LA-San
 */
public interface ProductServiceLayer {
    void loadProductData() throws FlooringMasteryPersistenceException;
    BigDecimal setMaterialCost(String productType) throws FlooringMasteryPersistenceException, NoSuchProductException;
    BigDecimal setLaborCost(String productType) throws FlooringMasteryPersistenceException, NoSuchProductException;
}
