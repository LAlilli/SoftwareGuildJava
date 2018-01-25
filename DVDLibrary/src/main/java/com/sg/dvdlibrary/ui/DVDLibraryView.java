/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit DVD Information");
        io.print("4. List All DVDs");
        io.print("5. Display Info for DVD");
        io.print("6. Search for DVD by Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    // methods for adding new dvds
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studioName = io.readString("Please enter Studio Name");
        String userNote = io.readString("Please enter a note or rating of your own");
        
        DVD currentDVD = new DVD(title);
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudioName(studioName);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Add DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully added.  Please hit enter to continue");
    }
    
    
    //display DVDs
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + ", "
                    + currentDVD.getReleaseDate() + " "
                    + currentDVD.getMPAARating() + " "
                    + currentDVD.getDirectorName() + " "
                    + currentDVD.getStudioName() + " "
                    + currentDVD.getUserNote());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    //get DVD by title
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAARating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudioName());
            io.print(dvd.getUserNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    //removing DVD
    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner () {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }
    
    //editing DVD
    public void displayEditDVDBanner () {
        io.print("=== Editing DVD ===");
    }

    public void displayEditSuccessBanner () {
        io.readString("DVD successfully updated. Please hit enter to continue.");
    }
    
    public int editMenuSelection(){
        io.print("What info would you like to edit?");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director Name");
        io.print("5. Studio Name");
        io.print("6. User Note/Rating");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public String editDVDTitle(){
        String title = io.readString("Please enter updated Title");
        
        return title;
    }
    
    //unknown commands
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
