/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class AddressBookView {
    private UserIO io;
    
    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add an Address");
        io.print("2. Remove an Address");
        io.print("3. View Number of Addresses");
        io.print("4. List All Addresses");
        io.print("5. Find Address by Last Name");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    // methods for adding new addresses
    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String street = io.readString("Please enter number and street");
        String cityState = io.readString("Please enter City and State");
        String zipCode = io.readString("Please enter Zip Code");
        
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreet(street);
        currentAddress.setCityState(cityState);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
    }
    
    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("Address successfully created.  Please hit enter to continue");
    }
    
    //display addresses
    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getLastName() + ", "
                    + currentAddress.getFirstName() + " "
                    + currentAddress.getStreet() + " "
                    + currentAddress.getCityState() + " "
                    + currentAddress.getZipCode());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }
    
    //get address by last name
    public void displayDisplayAddressBanner () {
        io.print("=== Display Addresses ===");
    }

    public String getAddressNameChoice() {
        return io.readString("Please enter the Last Name.");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getLastName() + ", " + address.getFirstName());
            io.print(address.getStreet());
            io.print(address.getCityState());
            io.print(address.getZipCode());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    //removing address
    public void displayRemoveAddressBanner () {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner () {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }
    
    //list number of addresses
    public void displayNumberOfAddressBanner () {
        io.print("=== Number of Addresses Available ===");
    }

    public void displayNumberSuccessBanner () {
        io.readString("Addresses successfully listed. Please hit enter to continue.");
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
