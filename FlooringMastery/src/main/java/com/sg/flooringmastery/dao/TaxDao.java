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
public interface TaxDao {
    void loadTaxData()throws FlooringMasteryPersistenceException;
    boolean validateUserTaxData(String state) throws FlooringMasteryPersistenceException;
    BigDecimal setStateTax(String state) throws FlooringMasteryPersistenceException;
}
