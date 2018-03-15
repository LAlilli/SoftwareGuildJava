/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import static com.sg.vendingmachine.dao.VendingMachineAuditDaoFileImpl.AUDIT_FILE;
import com.sg.vendingmachine.dto.VendingMachine;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
public class VendingMachineAuditDaoTest {
    
    private VendingMachineAuditDao dao = new VendingMachineAuditDaoFileImpl();
    
    public VendingMachineAuditDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of writeAuditEntry method, of class VendingMachineAuditDao.
     */
    @Test
    public void testWriteAuditEntry() throws Exception {
        String entry = "Snickers";
        
        PrintWriter out;
        out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        
        dao.writeAuditEntry(entry);
        
        assertEquals(entry, entry);
    }    
}
