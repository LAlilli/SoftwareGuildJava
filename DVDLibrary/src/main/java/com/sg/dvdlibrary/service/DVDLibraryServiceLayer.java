/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author LA-San
 */
public interface DVDLibraryServiceLayer {
    void addDVD(DVD dvd) throws
            DVDLibraryDuplicateException,
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;
 
    List<DVD> getAllDVDs() throws
            DVDLibraryPersistenceException;
 
    DVD getDVD(String title) throws
            DVDLibraryPersistenceException;
 
    DVD removeDVD(String title) throws
            DVDLibraryPersistenceException;
    
    void editDVD(String title, DVD dvd) throws
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;
}
