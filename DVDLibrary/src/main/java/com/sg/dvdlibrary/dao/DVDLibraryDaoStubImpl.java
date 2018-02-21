/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class DVDLibraryDaoStubImpl implements DVDLibraryDao {
    
    DVD onlyDVD;
    List<DVD> dvdList = new ArrayList<>();
    
    public DVDLibraryDaoStubImpl(){
        onlyDVD = new DVD("Alien Covenant");
        onlyDVD.setReleaseDate("2/2/2012");
        onlyDVD.setMPAARating("R");
        onlyDVD.setDirectorName("Smithers");
        onlyDVD.setStudioName("Warner");
        onlyDVD.setUserNote("Scary");
        
        dvdList.add(onlyDVD);
    }
    
    @Override
    public DVD addDVD(String title, DVD dvds) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())){
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dvdList;
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())){
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())){
            return onlyDVD;
        } else {
            return null;
        }
    }

    @Override
    public DVD editDVD(String title, DVD dvds) throws DVDLibraryPersistenceException {
        if (title.equals(onlyDVD.getTitle())){
            return onlyDVD;
        } else {
            return null;
        }
    }
}