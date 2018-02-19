/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author LA-San
 */
public interface DVDLibraryDao {
   DVD addDVD(String title, DVD dvds) throws DVDLibraryPersistenceException;

   List<DVD> getAllDVDs() throws DVDLibraryPersistenceException;

   DVD getDVD(String title) throws DVDLibraryPersistenceException;

   DVD removeDVD(String title) throws DVDLibraryPersistenceException;
   
   DVD editDVD(String title, DVD dvds) throws DVDLibraryPersistenceException;
}
