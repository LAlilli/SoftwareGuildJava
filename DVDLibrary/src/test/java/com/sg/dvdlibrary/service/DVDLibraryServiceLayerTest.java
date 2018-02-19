/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDaoStubImpl;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoStubImpl;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
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
public class DVDLibraryServiceLayerTest {
    
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryServiceLayerTest() {
        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
        DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoStubImpl();
        
        service = new DVDLibraryServiceLayerImpl(dao, auditDao);
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
    
    @Test
    public void testCreateDVDDuplicate() throws Exception{
        DVD dvd = new DVD("Alien Covenant");
        dvd.setReleaseDate("2/2/2015");
        dvd.setMPAARating("R");
        dvd.setDirectorName("Swarez");
        dvd.setStudioName("Warner");
        dvd.setUserNote("Weird");
        
        try {
            service.addDVD(dvd);
            fail("Expected DVDLibraryDuplicateException was not thrown.");
        } catch (DVDLibraryDuplicateException e){
            return;
        }
    }
    
    @Test
    public void testCreateDVDInvalidData() throws Exception{
        DVD dvd = new DVD("Alien Covenant");
        dvd.setReleaseDate("2/2/2015");
        dvd.setMPAARating("R");
        dvd.setDirectorName("Swarez");
        dvd.setStudioName("Warner");
        dvd.setUserNote("Weird");
        
        try {
            service.addDVD(dvd);
            fail("Expected DVDLibraryDataValidationException was not thrown. ");
        } catch (DVDLibraryDataValidationException e){
            return;
        }
    }

    /**
     * Test of addDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testAddDVD() throws Exception {
        DVD dvd = new DVD("Prometheus");
        dvd.setReleaseDate("10/31/2012");
        dvd.setMPAARating("R");
        dvd.setDirectorName("Smith");
        dvd.setStudioName("Warner");
        dvd.setUserNote("Freaky");
        
        service.addDVD(dvd);
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        assertEquals(1, service.getAllDVDs().size());
    }

    /**
     * Test of getDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVD() throws Exception {
        DVD dvd = service.getDVD("Prometheus");
        assertNotNull(dvd);
        dvd = service.getDVD("Alien");
        assertNull(dvd);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd = service.removeDVD("Prometheus");
        assertNotNull(dvd);
        dvd = service.removeDVD("Alien");
        assertNull(dvd);
    }

    /**
     * Test of editDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testEditDVD() throws Exception {
        DVD dvd = new DVD("Prometheus");
        dvd.setReleaseDate("10/31/2012");
        dvd.setMPAARating("R");
        dvd.setDirectorName("Smith");
        dvd.setStudioName("Warner");
        dvd.setUserNote("Freaky");
        
        service.editDVD(dvd.getTitle(), dvd);
    }  
}
