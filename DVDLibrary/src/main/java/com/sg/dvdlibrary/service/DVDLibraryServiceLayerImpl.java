/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer{
    DVDLibraryDao dao;
    
    private DVDLibraryAuditDao auditDao;
   
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void addDVD(DVD dvd) throws DVDLibraryDuplicateException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        if (dao.getDVD(dvd.getTitle()) != null) {
            throw new DVDLibraryDuplicateException(
                    "ERROR: Could not create dvd.  Title "
                    + dvd.getTitle()
                    + " already exists");
        }

        validateDVDData(dvd);

        dao.addDVD(dvd.getTitle(), dvd);

        //auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " CREATED.");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        return dao.getDVD(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(title);
        // Write to audit log
        //auditDao.writeAuditEntry("DVD " + title + " REMOVED.");
        return dao.removeDVD(title);
    }
    
    @Override
    public void editDVD(String title, DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        validateDVDData(dvd);

        dao.addDVD(dvd.getTitle(), dvd);

        //auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " EDITED.");
    }
    
    private void validateDVDData(DVD dvd) throws
        DVDLibraryDataValidationException {

        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getReleaseDate() == null
                //|| dvd.getReleaseDate().trim().length() == 0
                || dvd.getMPAARating() == null
                || dvd.getMPAARating().trim().length() == 0 
                || dvd.getDirectorName() == null
                || dvd.getDirectorName().trim().length() == 0
                || dvd.getStudioName() == null
                || dvd.getStudioName().trim().length() == 0
                || dvd.getUserNote() == null
                || dvd.getUserNote().trim().length() == 0) {

            throw new DVDLibraryDataValidationException(
                    "ERROR: All fields [Title, Release Date, MPAA Rating, Director Name, Studio Name, User Note] are required.");
        }
    } 

    @Override
    public double getAverageDVDAge() throws DVDLibraryPersistenceException {
        return dao.getAverageDVDAge();
    }

    @Override
    public List<DVD> getNewestDVD(int ageInYears) throws DVDLibraryPersistenceException {
        return dao.getNewestDVD(ageInYears);
    }

    @Override
    public List<DVD> getOldestDVD(int ageInYears) throws DVDLibraryPersistenceException {
        return dao.getOldestDVD(ageInYears);
    }

    @Override
    public List<DVD> getMoviesReleasedInSetYears(int releasedWithSetYears) throws DVDLibraryPersistenceException {
        return dao.getMoviesReleasedInSetYears(releasedWithSetYears);
    }

    @Override
    public List<DVD> getMoviesWithSetMpaa(String givenMpaa) throws DVDLibraryPersistenceException {
        return dao.getMoviesWithSetMpaa(givenMpaa);
    }

    @Override
    public List<DVD> getMoviesReleasedBySetStudio(String givenStudio) throws DVDLibraryPersistenceException {
        return dao.getMoviesReleasedBySetStudio(givenStudio);
    }

    @Override
    public List<DVD> getMoviesSetDirectorSortedByMpaa(String givenDirector) throws DVDLibraryPersistenceException {
        return dao.getMoviesSetDirectorSortedByMpaa(givenDirector);
    }

    @Override
    public double getAverageNumberNotes() throws DVDLibraryPersistenceException {
        return dao.getAverageNumberNotes();
    }
}
