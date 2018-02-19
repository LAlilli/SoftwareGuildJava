/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDaoFileImpl;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayerImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author LA-San
 */
public class App {
    public static void main(String[] args) throws DVDLibraryDataValidationException {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implementation into it
        DVDLibraryView myView = new DVDLibraryView(myIo);
        // Instantiate the DAO
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        // Instantiate the Audit DAO
        DVDLibraryAuditDao myAuditDao = new DVDLibraryAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        DVDLibraryServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        DVDLibraryController controller = new DVDLibraryController(myService, myView);
        // Kick off the Controller
        controller.run();
    }
}
