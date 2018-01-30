/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class DVDLibraryController {
    DVDLibraryView view;
    DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
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
        } catch (DVDLibraryDaoException e) {
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
    private void addDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    //list all DVDs and their associated properties
    private void listAllDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    //display DVD information based on title choice
    private void displayDVDInfo() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    //remove DVD
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }
    
    //search for DVD by title
    private void searchDVDByTitle() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
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
    private void editDVD() throws DVDLibraryDaoException {
        
        //retrieve DVD that user would like to edit
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(title);
        
        boolean keepEditing = true;
        int editMenuSelection = 0;
        
        //allow user to edit different properties for DVD
        while(keepEditing){
            editMenuSelection = getEditMenuSelection();
            
            switch (editMenuSelection){
                case 1:
                    //remove old title/key from hashmap
                    dao.removeDVD(title); 
                    //add new title
                    String updatedTitle = view.editDVDTitle();
                    dvd.setTitle(updatedTitle);
                    dao.editDVD(updatedTitle, dvd);
                    break;
                case 2:
                    String releaseDate = view.editDVDReleaseDate();
                    dvd.setReleaseDate(releaseDate);
                    dao.editDVD(title, dvd);
                    break;
                case 3:
                    String mpaaRating = view.editDVDMPAARating();
                    dvd.setMPAARating(mpaaRating);
                    dao.editDVD(title, dvd);
                    break;
                case 4:
                    String directorName = view.editDVDDirectorName();
                    dvd.setDirectorName(directorName);
                    dao.editDVD(title, dvd);
                    break;
                case 5:
                    String studioName = view.editDVDStudioName();
                    dvd.setStudioName(studioName);
                    dao.editDVD(title, dvd);
                    break;
                case 6:
                    String userNote = view.editDVDUserNote();
                    dvd.setUserNote(userNote);
                    dao.editDVD(title, dvd);
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
