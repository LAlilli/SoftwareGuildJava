/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author LA-San
 */
public class Order {

    private int orderNum; 
    private String customerName;
    private BigDecimal area;
    private BigDecimal materialCost; 
    private BigDecimal laborCost;
    private BigDecimal tax; 
    private BigDecimal total; 
    private LocalDate date; 
    
    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

    public Order() {
        
    }
    
    //objects for product and tax classes
    private Product product = new Product();
    private Tax taxObject = new Tax();
    
    //accessing Product properties
    public String getProductType(){
        return product.getProductType();
    }
    
    public void setProductType(String productType){
        product.setProductType(productType);
    }
    
    public BigDecimal getCostPerSqFoot(){
        return product.getCostPerSqFoot();
    }
    
    public void setCostPerSqFoot(BigDecimal costPerSqFoot){
        product.setCostPerSqFoot(costPerSqFoot);
    }
    
    public BigDecimal getLaborCostPerSqFoot(){
        return product.getLaborCostPerSqFoot();
    }
    
    public void setLaborCostPerSqFoot(BigDecimal laborCostPerSqFoot){
        product.setLaborCostPerSqFoot(laborCostPerSqFoot);
    }
    
    public String getState(){
       return taxObject.getState();
    }
    
    public BigDecimal getStateTax(){
        return taxObject.getStateTax();
    }
    
    public void setState(String state){
       taxObject.setState(state);
    }
    
    public void setStateTax(BigDecimal stateTax){
        taxObject.setStateTax(stateTax);
    }

    //order properties
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal matericalCost) {
        this.materialCost = matericalCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.orderNum;
        hash = 79 * hash + Objects.hashCode(this.customerName);
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + Objects.hashCode(this.product.getProductType());
        hash = 79 * hash + Objects.hashCode(this.product.getCostPerSqFoot());
        hash = 79 * hash + Objects.hashCode(this.product.getLaborCostPerSqFoot());
        hash = 79 * hash + Objects.hashCode(this.taxObject.getStateTax());
        hash = 79 * hash + Objects.hashCode(this.taxObject.getState());
        hash = 79 * hash + Objects.hashCode(this.total);
        hash = 79 * hash + Objects.hashCode(this.area);
        hash = 79 * hash + Objects.hashCode(this.laborCost);
        hash = 79 * hash + Objects.hashCode(this.tax);
        hash = 79 * hash + Objects.hashCode(this.materialCost);
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
        final Order other = (Order) obj;
        if (this.orderNum != other.orderNum) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.taxObject, other.taxObject)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Order Number: " + orderNum + " |Customer Name: " + customerName + " |Date: " + date;
    }
}
