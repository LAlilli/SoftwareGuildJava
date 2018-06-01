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
    
    public TaxDaoFileImplStub(){
        onlyTaxData = new Tax();
        onlyTaxData.setState("OH");
        onlyTaxData.setStateTax(new BigDecimal(6.25));
    }

    @Override
    public void loadTaxData() {
    }

    @Override
    public boolean validateUserTaxData(String state) throws FlooringMasteryPersistenceException {
        if(onlyTaxData.getState() == state){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BigDecimal setStateTax(String state) throws FlooringMasteryPersistenceException {
        if(onlyTaxData.getState() == state){
            return onlyTaxData.getStateTax();
        } else {
            return null;
        }
    }
}
