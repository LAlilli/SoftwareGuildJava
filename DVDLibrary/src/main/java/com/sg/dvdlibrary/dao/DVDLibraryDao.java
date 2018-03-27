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
   
   double getAverageDVDAge() throws DVDLibraryPersistenceException;
   
   List<DVD> getNewestDVD(int ageInYears) throws DVDLibraryPersistenceException;
   
   List<DVD> getOldestDVD(int ageInYears) throws DVDLibraryPersistenceException;
   
   /*
    Find all movies released in the last N years
    Find all the movies with a given MPAA rating
    Find all the movies by a given director
    Find the average number of notes associated with movies in your collection
    When searching by director, the movies should be sorted into separate data structures by MPAA rating.
   */
}
