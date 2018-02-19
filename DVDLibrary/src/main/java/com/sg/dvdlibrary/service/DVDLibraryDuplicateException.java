/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

/**
 *
 * @author LA-San
 */
public class DVDLibraryDuplicateException extends Exception {
    public DVDLibraryDuplicateException(String message) {
        super(message);
    }

    public DVDLibraryDuplicateException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
