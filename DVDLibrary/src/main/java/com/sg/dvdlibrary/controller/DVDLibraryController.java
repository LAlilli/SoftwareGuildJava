/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;
import java.util.Map;

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

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDLibraryDaoException {
        /*view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();*/
    }

    private void listAllDVDs() throws DVDLibraryDaoException {
        /*view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);*/
    }

    private void displayDVDInfo() throws DVDLibraryDaoException {
        /*view.displayDisplayAddressBanner();
        String lastName = view.getAddressNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);*/
    }

    private void removeDVD() throws DVDLibraryDaoException {
        /*view.displayRemoveAddressBanner();
        String lastName = view.getAddressNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();*/
    }
    
    private void editDVD() throws DVDLibraryDaoException {
        /*view.displayNumberOfAddressBanner();
        Map<String, Address> address = null;
        int numberOfAddresses = dao.getNumberOfAddresses(address);
        view.displayNumberSuccessBanner();*/
    }
    
    private void searchDVDByTitle() throws DVDLibraryDaoException {
        /*view.displayNumberOfAddressBanner();
        Map<String, Address> address = null;
        int numberOfAddresses = dao.getNumberOfAddresses(address);
        view.displayNumberSuccessBanner();*/
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
