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
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LA-San
 */
public class OrderDaoTest {
    
    private OrderDao dao = new OrderDaoFileImplProduction();
    
    public OrderDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FlooringMasteryPersistenceException {
        List<Order> allOrders = dao.getAllOrders();
        for (Order order : allOrders){
            dao.removeOrder(order.getOrderNum());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllOrders method, of class OrderDao.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order1 = new Order(1);
        order1.setCustomerName("Joey");
        order1.setState("OH");
        order1.setStateTax(new BigDecimal(6.25));
        order1.setProductType("Wood");
        order1.setArea(new BigDecimal(20));
        order1.setCostPerSqFoot(new BigDecimal(2.25));
        order1.setLaborCostPerSqFoot(new BigDecimal(2.10));
        order1.setMaterialCost(new BigDecimal(20));
        order1.setLaborCost(new BigDecimal(20));
        order1.setTax(new BigDecimal(1.25));
        order1.setTotal(new BigDecimal(100));
        order1.setDate(LocalDate.parse("12/15/2015", df));
        
        dao.addOrder(order1.getOrderNum(), order1);
        
        Order order2 = new Order(2);
        order2.setCustomerName("Jane");
        order2.setState("IN");
        order2.setStateTax(new BigDecimal(6.25));
        order2.setProductType("Wood");
        order2.setArea(new BigDecimal(20));
        order2.setCostPerSqFoot(new BigDecimal(2.25));
        order2.setLaborCostPerSqFoot(new BigDecimal(2.10));
        order2.setMaterialCost(new BigDecimal(20));
        order2.setLaborCost(new BigDecimal(20));
        order2.setTax(new BigDecimal(1.25));
        order2.setTotal(new BigDecimal(100));
        order2.setDate(LocalDate.parse("10/15/2015", df));
        
        dao.addOrder(order2.getOrderNum(), order2);
        
        assertEquals(6, dao.getAllOrders().size());
    }

    /**
     * Test of addOrder method, of class OrderDao.
     */
    @Test
    public void testAddGetOrder() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order(2);
        order.setCustomerName("Jimmy");
        order.setState("MI");
        order.setStateTax(new BigDecimal(6.25));
        order.setProductType("Plastic");
        order.setArea(new BigDecimal(20));
        order.setCostPerSqFoot(new BigDecimal(2.25));
        order.setLaborCostPerSqFoot(new BigDecimal(2.10));
        order.setMaterialCost(new BigDecimal(20));
        order.setLaborCost(new BigDecimal(20));
        order.setTax(new BigDecimal(1.25));
        order.setTotal(new BigDecimal(100));
        order.setDate(LocalDate.parse("12/15/2015", df));
        
        dao.addOrder(order.getOrderNum(), order);
        
        assertNotNull(order);
    }

    /**
     * Test of editOrder method, of class OrderDao.
     */
    @Test
    public void testEditOrder() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order(1);
        order.setCustomerName("Customer 1");
        order.setState("OH");
        order.setStateTax(new BigDecimal(6.25));
        order.setProductType("Wood");
        order.setArea(new BigDecimal(20));
        order.setCostPerSqFoot(new BigDecimal(5.15));
        order.setLaborCostPerSqFoot(new BigDecimal(4.75));
        order.setMaterialCost(new BigDecimal(103));
        order.setLaborCost(new BigDecimal(95));
        order.setTax(new BigDecimal(204.25));
        order.setTotal(new BigDecimal(402.25));
        order.setDate(LocalDate.parse("01/01/2001", df));
        
        dao.editOrder(order.getOrderNum(), order);
        
        assertEquals(1, order.getOrderNum());
    }

    /**
     * Test of removeOrder method, of class OrderDao.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order1 = new Order(1);
        order1.setCustomerName("Customer 1");
        order1.setState("OH");
        order1.setStateTax(new BigDecimal(6.25));
        order1.setProductType("Wood");
        order1.setArea(new BigDecimal(20));
        order1.setCostPerSqFoot(new BigDecimal(5.15));
        order1.setLaborCostPerSqFoot(new BigDecimal(4.75));
        order1.setMaterialCost(new BigDecimal(103));
        order1.setLaborCost(new BigDecimal(95));
        order1.setTax(new BigDecimal(204.25));
        order1.setTotal(new BigDecimal(402.25));
        order1.setDate(LocalDate.parse("01/01/2001", df));
        
        dao.addOrder(order1.getOrderNum(), order1);
        
        Order order2 = new Order(2);
        order2.setCustomerName("Customer 2");
        order2.setState("OH");
        order2.setStateTax(new BigDecimal(6.25));
        order2.setProductType("Wood");
        order2.setArea(new BigDecimal(30));
        order2.setCostPerSqFoot(new BigDecimal(5.15));
        order2.setLaborCostPerSqFoot(new BigDecimal(4.75));
        order2.setMaterialCost(new BigDecimal(103));
        order2.setLaborCost(new BigDecimal(95));
        order2.setTax(new BigDecimal(204.25));
        order2.setTotal(new BigDecimal(402.25));
        order2.setDate(LocalDate.parse("02/02/2002", df));
        
        dao.addOrder(order2.getOrderNum(), order2);
        
        assertEquals(6, dao.getAllOrders().size());
        
        dao.removeOrder(order1.getOrderNum());
        assertEquals(6, dao.getAllOrders().size());
        
        dao.removeOrder(order2.getOrderNum());
        assertEquals(6, dao.getAllOrders().size());
    }

    /**
     * Test of generateOrderNum method, of class OrderDao.
     */
    @Test
    public void testGenerateOrderNum() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order1 = new Order();
        order1.setCustomerName("Joey");
        order1.setState("OH");
        order1.setStateTax(new BigDecimal(6.25));
        order1.setProductType("Wood");
        order1.setArea(new BigDecimal(20));
        order1.setCostPerSqFoot(new BigDecimal(2.25));
        order1.setLaborCostPerSqFoot(new BigDecimal(2.10));
        order1.setMaterialCost(new BigDecimal(20));
        order1.setLaborCost(new BigDecimal(20));
        order1.setTax(new BigDecimal(1.25));
        order1.setTotal(new BigDecimal(100));
        order1.setDate(LocalDate.parse("12/15/2015", df));
        dao.generateOrderNum(order1);
        
        assertNotNull(order1.getOrderNum());
    }
}
