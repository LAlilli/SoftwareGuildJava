/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class DVDLibraryController {
    DVDLibraryView view;
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws DVDLibraryDataValidationException {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        //try catch block for DAO exception
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listAllDVDs();
                        break;
                    case 5:
                        displayDVDInfo();
                        break;
                    case 6:
                        searchDVDByTitle();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
    } 
}

    //menu methods
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private int getEditMenuSelection(){
        return view.editMenuSelection();
    }

    //add a new DVD
    private void addDVD() throws DVDLibraryPersistenceException {
        view.displayCreateDVDBanner();
        boolean hasErrors = false;
        do {
            DVD currentDVD = view.getNewDVDInfo();
            try {
                service.addDVD(currentDVD);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DVDLibraryDuplicateException | DVDLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }

    //list all DVDs and their associated properties
    private void listAllDVDs() throws DVDLibraryPersistenceException {
        List<DVD> dvdList = service.getAllDVDs();

        view.displayDVDList(dvdList);
    }

    //display DVD information based on title choice
    private void displayDVDInfo() throws DVDLibraryPersistenceException {
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = service.getDVD(dvdTitle) ;
        view.displayDVD(dvd);
    }

    //remove DVD
    private void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        service.removeDVD(dvdTitle);
        view.displayRemoveSuccessBanner();
    }
    
    //search for DVD by title
    private void searchDVDByTitle() throws DVDLibraryPersistenceException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = service.getDVD(dvdTitle);
        view.displayDVD(dvd);
    }
    
    //unknown command message
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    //exit message
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    //editing DVD information based on user selection
    private void editDVD() throws DVDLibraryPersistenceException, DVDLibraryDataValidationException {
        
        //retrieve DVD that user would like to edit
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = service.getDVD(title);
        
        boolean keepEditing = true;
        int editMenuSelection = 0;
        
        //allow user to edit different properties for DVD
        while(keepEditing){
            editMenuSelection = getEditMenuSelection();
            
            switch (editMenuSelection){
                case 1:
                    //remove old title/key from hashmap
                    service.removeDVD(title); 
                    //add new title
                    String updatedTitle = view.editDVDTitle();
                    dvd.setTitle(updatedTitle);
                    service.editDVD(updatedTitle, dvd);
                    break;
                case 2:
                    String releaseDate = view.editDVDReleaseDate();
                    dvd.setReleaseDate(releaseDate);
                    service.editDVD(title, dvd);
                    break;
                case 3:
                    String mpaaRating = view.editDVDMPAARating();
                    dvd.setMPAARating(mpaaRating);
                    service.editDVD(title, dvd);
                    break;
                case 4:
                    String directorName = view.editDVDDirectorName();
                    dvd.setDirectorName(directorName);
                    service.editDVD(title, dvd);
                    break;
                case 5:
                    String studioName = view.editDVDStudioName();
                    dvd.setStudioName(studioName);
                    service.editDVD(title, dvd);
                    break;
                case 6:
                    String userNote = view.editDVDUserNote();
                    dvd.setUserNote(userNote);
                    service.editDVD(title, dvd);
                    break;
                case 7:
                    keepEditing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        view.displayEditSuccessBanner();
    }
}
