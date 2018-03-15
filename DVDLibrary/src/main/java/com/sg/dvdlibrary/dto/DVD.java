/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author LA-San
 */
public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studioName;
    private String userNote;

    public DVD(String title) {
        this.title = title;
    }

    // getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //getter and setter for release date
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    //getter and setter for MPAA rating
    public String getMPAARating() {
        return mpaaRating;
    }
    
    public void setMPAARating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    //getter and setter for director name
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    } 
    
    //getter and setter for studio name
    public String getStudioName(){
        return studioName;
    }
    
    public void setStudioName(String studioName){
        this.studioName = studioName;
    }
    
    //getter and setter for user note
    public String getUserNote(){
        return userNote;
    }
    
    public void setUserNote(String userNote){
        this.userNote = userNote;
    }
    
    public long getMovieAge(){
        Period p = releaseDate.until(LocalDate.now());
        
        return p.getYears();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.releaseDate);
        hash = 89 * hash + Objects.hashCode(this.mpaaRating);
        hash = 89 * hash + Objects.hashCode(this.directorName);
        hash = 89 * hash + Objects.hashCode(this.studioName);
        hash = 89 * hash + Objects.hashCode(this.userNote);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.studioName, other.studioName)) {
            return false;
        }
        if (!Objects.equals(this.userNote, other.userNote)) {
            return false;
        }
        return true;
    }
    
    
}
