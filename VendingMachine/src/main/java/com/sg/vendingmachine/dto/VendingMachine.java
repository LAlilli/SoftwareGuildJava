/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.util.Objects;

/**
 *
 * @author LA-San
 */
public class VendingMachine {
    private String itemID;
    private String itemName;
    private double itemCost;
    private int numberOfItem;

    public VendingMachine() {
        
    }
    
    public VendingMachine(String itemID){
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.itemName);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.itemCost) ^ (Double.doubleToLongBits(this.itemCost) >>> 32));
        hash = 79 * hash + this.numberOfItem;
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
        final VendingMachine other = (VendingMachine) obj;
        if (Double.doubleToLongBits(this.itemCost) != Double.doubleToLongBits(other.itemCost)) {
            return false;
        }
        if (this.numberOfItem != other.numberOfItem) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        return true;
    }

    
    
}
