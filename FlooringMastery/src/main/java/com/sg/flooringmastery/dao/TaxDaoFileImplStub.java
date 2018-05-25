/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;

/**
 *
 * @author LA-San
 */
public class TaxDaoFileImplStub implements TaxDao {
    
    Tax onlyTaxData;

    @Override
    public void loadTaxData() {
    }

    @Override
    public boolean validateUserTaxData(String state) throws FlooringMasteryPersistenceException {
        //update with correct info
        return true;
    }

    @Override
    public BigDecimal setStateTax(String state) throws FlooringMasteryPersistenceException {
        BigDecimal stateTax = new BigDecimal(2.0);
        
        return stateTax;
    }
}
