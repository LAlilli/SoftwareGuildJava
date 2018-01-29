/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    private Map<String, DVD> dvd = new HashMap<>();
    public static final String DVD_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public DVD addDVD(String title, DVD dvds) throws DVDLibraryDaoException {
        DVD newDVD = dvd.put(title, dvds);
        writeDVD();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadDVD();
	return new ArrayList<DVD>(dvd.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadDVD();
	return dvd.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        DVD removeDVD = dvd.remove(title);
        writeDVD();
        return removeDVD;
    }
    
    @Override
    public DVD editDVD(String title, DVD dvds) throws DVDLibraryDaoException {
        DVD editDVD = dvd.replace(title, dvds);
        writeDVD();
        return editDVD;
    }
    
    //method for loading DVD info from text file
    private void loadDVD() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);
            // Set the remaining vlaues on currentDVD manually
            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMPAARating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudioName(currentTokens[4]);
            currentDVD.setUserNote(currentTokens[5]);

            // Put current dvd into the map using title as the key
            dvd.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    //method for writing dvd info to text file
    private void writeDVD() throws DVDLibraryDaoException {

        PrintWriter out;

        //try catch block in case not able to save info to file
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save dvd data.", e);
        }

        //create DVD list to save DVDs with delimiter
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            // write the dvd object to the file
            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER 
                    + currentDVD.getMPAARating() + DELIMITER
                    + currentDVD.getDirectorName() + DELIMITER
                    + currentDVD.getStudioName() + DELIMITER 
                    + currentDVD.getUserNote());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    } 
}
