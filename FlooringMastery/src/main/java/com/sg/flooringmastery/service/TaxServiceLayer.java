/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.NoSuchStateException;
import java.math.BigDecimal;

/**
 *
 * @author LA-San
 */
public interface TaxServiceLayer {
    void loadTaxData() throws FlooringMasteryPersistenceException;
    BigDecimal validateUserTaxData(String state) throws FlooringMasteryPersistenceException, NoSuchStateException;
}
