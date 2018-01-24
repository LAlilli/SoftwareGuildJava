/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author LA-San
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studioName;
    private String userNote;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getMPAARating() {
        return mpaaRating;
    }
    
    public void setMPAARating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    } 
    
    public String getStudioName(){
        return studioName;
    }
    
    public void setStudioName(String studioName){
        this.studioName = studioName;
    }
    
    public String getUserNote(){
        return userNote;
    }
    
    public void setUserNote(String userNote){
        this.userNote = userNote;
    }
}
