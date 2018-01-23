/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
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
public class AddressBookDaoFileImpl implements AddressBookDao{
    private Map<String, Address> address = new HashMap<>();
    public static final String ADDRESS_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public Address addAddress(String lastName, Address addresses) throws AddressBookDaoException {
        Address newAddress = address.put(lastName, addresses);
        writeRoster();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        loadRoster();
	return new ArrayList<Address>(address.values());
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookDaoException {
        loadRoster();
	return address.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookDaoException {
        Address removedAddress = address.remove(lastName);
        writeRoster();
        return removedAddress;
    }
    
    @Override
    public int getNumberOfAddresses(Map<String, Address> address) throws AddressBookDaoException {
        int getNumberOfAddresses = address.size();
        writeRoster();
        return getNumberOfAddresses;
    }
    
    private void loadRoster() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
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

            Address currentAddress = new Address(currentTokens[0]);
            // Set the remaining vlaues on currentAddress manually
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setLastName(currentTokens[2]);
            currentAddress.setStreet(currentTokens[3]);
            currentAddress.setCityState(currentTokens[4]);
            currentAddress.setZipCode(currentTokens[5]);

            // Put currentAddress into the map using studentID as the key
            address.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    private void writeRoster() throws AddressBookDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save student data.", e);
        }

        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // write the Address object to the file
            out.println(currentAddress.getLastName() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER 
                    + currentAddress.getStreet() + DELIMITER
                    + currentAddress.getCityState() + DELIMITER
                    + currentAddress.getZipCode()); 
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    } 
}
