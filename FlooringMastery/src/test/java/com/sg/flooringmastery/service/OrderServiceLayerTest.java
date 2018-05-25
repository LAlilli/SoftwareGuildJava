/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.AuditDaoFileImplStub;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.OrderDaoFileImplStub;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.TaxServiceLayer;
import com.sg.flooringmastery.service.ProductServiceLayer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LA-San
 */
public class OrderServiceLayerTest {
    
    private OrderServiceLayer service;
    
    public OrderServiceLayerTest() {
        OrderDao dao = new OrderDaoFileImplStub();
        AuditDao auditDao = new AuditDaoFileImplStub();
        TaxServiceLayer taxService = new TaxServiceLayerImpl();
        ProductServiceLayer productService = new ProductServiceLayerImpl();
        
        service = new OrderServiceLayerImpl(dao, auditDao, taxService, productService);
    }

    @BeforeClass
    public static void setUpClass() {
        Order order = new Order(1);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class OrderServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
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
        
        service.addOrder(order);
    }

    /**
     * Test of editOrder method, of class OrderServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
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
        
        service.editOrder(order.getOrderNum(), order);
    }

    /**
     * Test of removeOrder method, of class OrderServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        Order order = service.removeOrder(2);
        assertNull(order);
    }

    /**
     * Test of getOrder method, of class OrderServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse("12/15/2015", df);
        Order order = service.getOrder(2, date);
        assertNull(order);
    }

    /**
     * Test of getAllOrders method, of class OrderServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        assertEquals(1, service.getAllOrders().size());
    }

    /**
     * Test of validateOrderData method, of class OrderServiceLayer.
     */
    @Test
    public void testCreateOrderInvalidData() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order(2);
        order.setCustomerName("Jimmy");
        order.setState("MI");
        order.setStateTax(new BigDecimal(6.25));
        order.setProductType("");
        order.setArea(new BigDecimal(20));
        order.setCostPerSqFoot(new BigDecimal(2.25));
        order.setLaborCostPerSqFoot(new BigDecimal(2.10));
        order.setMaterialCost(new BigDecimal(20));
        order.setLaborCost(new BigDecimal(20));
        order.setTax(new BigDecimal(1.25));
        order.setTotal(new BigDecimal(100));
        order.setDate(LocalDate.parse("12/15/2015", df));
        
        try {
            service.addOrder(order);
            fail("Expected FlooringMasteryDataValidationException was not thrown. ");
        } catch (FlooringMasteryDataValidationException e){
            return;
        }
    }

    /**
     * Test of saveCurrentWork method, of class OrderServiceLayer.
     */
    @Test
    public void testSaveCurrentWork() throws Exception {

    }

    /**
     * Test of generateOrderNumber method, of class OrderServiceLayer.
     */
    @Test
    public void testGenerateOrderNumber() throws Exception {
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
        
        service.generateOrderNumber(order);
        
        assertEquals(2, order.getOrderNum());
    }

    /**
     * Test of calculateTotal method, of class OrderServiceLayer.
     */
    @Test
    public void testCalculateTotal() throws FlooringMasteryPersistenceException {
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
        
        service.calculateTotal(order);
        
        assertEquals(new BigDecimal(100), order.getTotal());
    } 
}
