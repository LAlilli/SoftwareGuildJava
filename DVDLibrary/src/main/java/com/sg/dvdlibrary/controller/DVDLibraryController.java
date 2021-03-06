/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.time.LocalDate;
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
                        getAverageDvdAge();
                        break;
                    case 8:
                        getOldestDvd();
                        break;
                    case 9:
                        getNewestDvd();
                        break;
                    case 10:
                        displayMoviesReleasedInSetYears();
                        break;
                    case 11:
                        displayMoviesWithGivenMpaa();
                        break;
                    case 12:
                        displayMoviesByDirector();
                        break;
                    case 13:
                        displayMoviesByStudio();
                        break;
                    case 14:
                        displayAverageNumberOfNotes();
                        break;
                    case 15:
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

    //average DVD age
    private void getAverageDvdAge() throws DVDLibraryPersistenceException{
        double averageAge = service.getAverageDVDAge();
        
        view.displayAverageAgeMessage(averageAge);
    }
    
    //oldest DVD
    public void getOldestDvd() throws DVDLibraryPersistenceException{
        int ageInYears = 0;
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getOldestDVD(ageInYears);
        
        view.displayOldestDvdMessage(dvd);
    }
    
    //newest DVD
    public void getNewestDvd() throws DVDLibraryPersistenceException{
        int ageInYears = 0;
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getNewestDVD(ageInYears);
        
        view.displayNewestDvdMessage(dvd);
    }
    
    //released in past N years
    private void displayMoviesReleasedInSetYears() throws DVDLibraryPersistenceException {
        int years = view.displayMoviesReleasedSetYearsPrompt();
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getMoviesReleasedInSetYears(years);
        view.displayMoviesReleasedSetYears(years);
    }
    
    //movies with given MPAA rating
    private void displayMoviesWithGivenMpaa() throws DVDLibraryPersistenceException {
        String givenMpaa = view.displayMoviesSortedByMpaaPrompt();
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getMoviesWithSetMpaa(givenMpaa);
        view.displayMoviesSortedByMpaa(givenMpaa);
    }
    
    //movies by specific director, sorted by MPAA
    private void displayMoviesByDirector() throws DVDLibraryPersistenceException {
        String givenDirector = view.displayMoviesSortedByDirectorPrompt();
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getMoviesSetDirectorSortedByMpaa(givenDirector);
        view.displayMoviesSortedByDirector(givenDirector);
    }
    
    //movies by specific studio
    private void displayMoviesByStudio() throws DVDLibraryPersistenceException {
        String givenStudio = view.displayMoviesSortedByStudioPrompt();
        DVD dvd = new DVD();
        List<DVD> dvdList = service.getMoviesReleasedBySetStudio(givenStudio);
        view.displayMoviesSortedByStudio(givenStudio);
    }
    
    //average number of notes
    private void displayAverageNumberOfNotes() throws DVDLibraryPersistenceException {
        double averageNumNotes = service.getAverageNumberNotes();
        
        view.displayAverageNumberNotes(averageNumNotes);
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
                    dvd.setReleaseDate(LocalDate.parse(releaseDate));
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
