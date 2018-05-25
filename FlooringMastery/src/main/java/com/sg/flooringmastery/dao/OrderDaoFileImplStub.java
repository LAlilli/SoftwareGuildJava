/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class OrderDaoFileImplStub implements OrderDao {
    Order onlyOrder;
    List<Order> allOrders = new ArrayList<>();
    
    public OrderDaoFileImplStub(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        onlyOrder = new Order(1);
        onlyOrder.setCustomerName("Joey");
        onlyOrder.setState("OH");
        onlyOrder.setStateTax(new BigDecimal(6.25));
        onlyOrder.setProductType("Wood");
        onlyOrder.setArea(new BigDecimal(20));
        onlyOrder.setCostPerSqFoot(new BigDecimal(2.25));
        onlyOrder.setLaborCostPerSqFoot(new BigDecimal(2.10));
        onlyOrder.setMaterialCost(new BigDecimal(20));
        onlyOrder.setLaborCost(new BigDecimal(40));
        onlyOrder.setTax(new BigDecimal(1.25));
        onlyOrder.setTotal(new BigDecimal(100));
        onlyOrder.setDate(LocalDate.parse("12/15/2015", df));
        
        allOrders.add(onlyOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order addOrder(int orderNum, Order order) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order getOrder(int orderNum, LocalDate date) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(int orderNum, Order order) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(int orderNum) {
        if (orderNum == onlyOrder.getOrderNum()){
            return onlyOrder;
        } else {
            return null;
        }
    }

    //for testing mode
    @Override
    public void loadOrderData() {

    }

    @Override
    public int generateOrderNum(Order order) {
        return onlyOrder.getOrderNum();
    }
}
