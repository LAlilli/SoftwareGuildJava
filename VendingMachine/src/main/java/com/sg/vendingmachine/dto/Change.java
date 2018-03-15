/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author LA-San
 */
public class Change {

    private BigDecimal penny;
    private BigDecimal nickel;
    private BigDecimal dime;
    private BigDecimal quarter;
    
    public Change(BigDecimal penny, BigDecimal nickel, BigDecimal dime, BigDecimal quarter) {
        this.penny = penny;
        this.nickel = nickel;
        this.dime = dime;
        this.quarter = quarter;
    }

    public Change() {
        
    }

    public BigDecimal getPenny() {
        return penny;
    }

    public void setPenny(BigDecimal penny) {
        this.penny = penny;
    }

    public BigDecimal getNickel() {
        return nickel;
    }

    public void setNickel(BigDecimal nickel) {
        this.nickel = nickel;
    }

    public BigDecimal getDime() {
        return dime;
    }

    public void setDime(BigDecimal dime) {
        this.dime = dime;
    }

    public BigDecimal getQuarter() {
        return quarter;
    }

    public void setQuarter(BigDecimal quarter) {
        this.quarter = quarter;
    }

    public void getChange(double changeBack, double itemCost){
        BigDecimal itemCostCompare = BigDecimal.valueOf(itemCost);
        BigDecimal change = BigDecimal.valueOf(changeBack);
        
        //bigdecimal to convert to pennies
        BigDecimal pennyMultiplier = new BigDecimal(100);
        
        //BigDecimals for each coin
        BigDecimal quarterDivisor = new BigDecimal(25);
        BigDecimal dimeDivisor = new BigDecimal(10);
        BigDecimal nickelDivisor = new BigDecimal(5);
        BigDecimal pennyDivisor = new BigDecimal(1);
        
        //bigdecimal to store remainder
        BigDecimal remainderCoins;
        
        //determine change due by comparing item cost to user change
        BigDecimal changeDue = change.subtract(itemCostCompare);

        if(changeDue.compareTo(BigDecimal.ZERO) > 0){
            //convert changeDue to pennies
            changeDue = pennyMultiplier.multiply(changeDue);

            //determine amount of quarters due
            remainderCoins = changeDue.divide(quarterDivisor).setScale(2, RoundingMode.HALF_DOWN);
            if(remainderCoins.compareTo(BigDecimal.ZERO) == 0 || remainderCoins.compareTo(BigDecimal.ZERO) > 0){
                setQuarter(changeDue.divide(quarterDivisor).setScale(0, RoundingMode.DOWN));
                remainderCoins = remainderCoins.subtract(changeDue.divide(quarterDivisor).setScale(0, RoundingMode.DOWN));
            } else {
                setQuarter(BigDecimal.ZERO);
            }
            
            //determine amount of dimes due based on remaining coins
            if(remainderCoins.compareTo(dimeDivisor.divide(pennyMultiplier)) == 0.1 || remainderCoins.compareTo(dimeDivisor.divide(pennyMultiplier)) > 0.1){
                setDime(remainderCoins.multiply(dimeDivisor).setScale(0, RoundingMode.DOWN));
                remainderCoins = remainderCoins.subtract(dimeDivisor.remainder(pennyMultiplier));
            } else {
                setDime(BigDecimal.ZERO);
            }
            
            //determine amount of nickels due based on remaining coins
            if(remainderCoins.compareTo(nickelDivisor.divide(pennyMultiplier)) == .05 || remainderCoins.compareTo(nickelDivisor.divide(pennyMultiplier)) > .05){
                setNickel(remainderCoins.multiply(pennyMultiplier).setScale(0, RoundingMode.DOWN));
                remainderCoins = remainderCoins.subtract(nickelDivisor.remainder(pennyMultiplier));
            } else {
                setNickel(BigDecimal.ZERO);
            }
            
            //determine amount of pennies due/left
            if(remainderCoins.compareTo(pennyDivisor.divide(pennyMultiplier)) == 0.01 || remainderCoins.compareTo(pennyDivisor.divide(pennyMultiplier)) > 0.01 && remainderCoins.compareTo(pennyDivisor.divide(pennyMultiplier)) < 0.05){
                setPenny(remainderCoins.multiply(pennyMultiplier).setScale(0, RoundingMode.DOWN));
            } else {
                setPenny(BigDecimal.ZERO);
            }
        } else {
            //no change is due back to user
            changeDue = BigDecimal.ZERO;
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.penny);
        hash = 59 * hash + Objects.hashCode(this.nickel);
        hash = 59 * hash + Objects.hashCode(this.dime);
        hash = 59 * hash + Objects.hashCode(this.quarter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (!Objects.equals(this.penny, other.penny)) {
            return false;
        }
        if (!Objects.equals(this.nickel, other.nickel)) {
            return false;
        }
        if (!Objects.equals(this.dime, other.dime)) {
            return false;
        }
        if (!Objects.equals(this.quarter, other.quarter)) {
            return false;
        }
        return true;
    }
}
