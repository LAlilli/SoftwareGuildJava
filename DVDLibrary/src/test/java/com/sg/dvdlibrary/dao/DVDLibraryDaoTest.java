/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author LA-San
 */
public class DVDLibraryDaoTest {
    
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    public DVDLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD>dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList){
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @org.junit.Test
    public void testAddGetDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd = new DVD("Prometheus");
        dvd.setReleaseDate(LocalDate.parse("12/15/2015", df));
        dvd.setMPAARating("R");
        dvd.setDirectorName("Smith");
        dvd.setStudioName("Solomon");
        dvd.setUserNote("Excellent");
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getTitle());
        
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryDao.
     */
    @org.junit.Test
    public void testGetAllDVDs() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd1 = new DVD("Prometheus");
        dvd1.setReleaseDate(LocalDate.parse("12/15/2015", df));
        dvd1.setMPAARating("R");
        dvd1.setDirectorName("Smith");
        dvd1.setStudioName("Solomon");
        dvd1.setUserNote("Excellent");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Alien");
        dvd2.setReleaseDate(LocalDate.parse("10/31/2012", df));
        dvd2.setMPAARating("R");
        dvd2.setDirectorName("Joey");
        dvd2.setStudioName("Warner");
        dvd2.setUserNote("Scary");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @org.junit.Test
    public void testRemoveDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd1 = new DVD("Prometheus");
        dvd1.setReleaseDate(LocalDate.parse("12/15/2015", df));
        dvd1.setMPAARating("R");
        dvd1.setDirectorName("Smith");
        dvd1.setStudioName("Solomon");
        dvd1.setUserNote("Excellent");
        
        dao.addDVD(dvd1.getTitle(), dvd1);
        
        DVD dvd2 = new DVD("Alien");
        dvd2.setReleaseDate(LocalDate.parse("10/31/2012", df));
        dvd2.setMPAARating("R");
        dvd2.setDirectorName("Joey");
        dvd2.setStudioName("Warner");
        dvd2.setUserNote("Scary");
        
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
        
        dao.removeDVD(dvd1.getTitle());
        assertEquals(1, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd1.getTitle()));
        
        dao.removeDVD(dvd2.getTitle());
        assertEquals(0, dao.getAllDVDs().size());
        assertNull(dao.getDVD(dvd2.getTitle()));
    }

    /**
     * Test of editDVD method, of class DVDLibraryDao.
     */
    @org.junit.Test
    public void testEditGetDVD() throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DVD dvd = new DVD("Prometheus");
        dvd.setReleaseDate(LocalDate.parse("12/15/2015", df));
        dvd.setMPAARating("R");
        dvd.setDirectorName("Smith");
        dvd.setStudioName("Solomon");
        dvd.setUserNote("Excellent");
        
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromDao = dao.getDVD(dvd.getTitle());
        
        //fromDao.setTitle("Alien Covenant");
        
        dao.editDVD(fromDao.getTitle(), fromDao);
        
        assertEquals(dvd, fromDao);
    }    
}
