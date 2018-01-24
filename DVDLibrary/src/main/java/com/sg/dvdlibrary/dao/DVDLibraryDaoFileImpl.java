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
        writeRoster();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadRoster();
	return new ArrayList<DVD>(dvd.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadRoster();
	return dvd.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        DVD removeDVD = dvd.remove(title);
        writeRoster();
        return removeDVD;
    }
    
    private void loadRoster() throws DVDLibraryDaoException {
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
            // Set the remaining vlaues on currentAddress manually
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseDate(currentTokens[2]);
            currentDVD.setMPAARating(currentTokens[3]);
            currentDVD.setDirectorName(currentTokens[4]);
            currentDVD.setStudioName(currentTokens[5]);
            currentDVD.setUserNote(currentTokens[6]);

            // Put currentAddress into the map using studentID as the key
            dvd.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private void writeRoster() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save dvd data.", e);
        }

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
