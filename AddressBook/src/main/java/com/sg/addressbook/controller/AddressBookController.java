/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.ui.AddressBookView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LA-San
 */
public class AddressBookController {
    AddressBookView view;
    AddressBookDao dao;
    
    public AddressBookController(AddressBookDao dao, AddressBookView view) {
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
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        viewNumberOfAddresses();
                        break;
                    case 4:
                        listAllAddresses();
                        break;
                    case 5:
                        findAddress();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
    } 
}

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addAddress() throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAllAddresses() throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }

    private void findAddress() throws AddressBookDaoException {
        view.displayDisplayAddressBanner();
        String lastName = view.getAddressNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() throws AddressBookDaoException {
        view.displayRemoveAddressBanner();
        String lastName = view.getAddressNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    
    private void viewNumberOfAddresses() throws AddressBookDaoException {
        view.displayNumberOfAddressBanner();
        Map<String, Address> address = null;
        int numberOfAddresses = dao.getNumberOfAddresses(address);
        view.displayNumberSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
