/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

/**
 *
 * @author LA-San
 */
public class BankRoll {
    
    private double machineMoney;
    
    public BankRoll(){
        
    }

    public BankRoll(double machineMoney) {
        this.machineMoney = machineMoney;
    }

    public double getMachineMoney() {
        return machineMoney;
    }

    public void setMachineMoney(double machineMoney) {
        this.machineMoney = machineMoney;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.machineMoney) ^ (Double.doubleToLongBits(this.machineMoney) >>> 32));
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
        final BankRoll other = (BankRoll) obj;
        if (Double.doubleToLongBits(this.machineMoney) != Double.doubleToLongBits(other.machineMoney)) {
            return false;
        }
        return true;
    }
}
