/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author LA-San
 */
public class App {
    public static void main(String[] args) throws DVDLibraryDataValidationException {

        //instantiate spring container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //grab controller and call run method
        DVDLibraryController controller = ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
}
