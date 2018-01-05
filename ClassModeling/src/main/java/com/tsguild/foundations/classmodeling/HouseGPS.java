/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.classmodeling;

/**
 *
 * @author LA-San
 */
public class HouseGPS {
    
    private int latitude;
    private int longitude;
    private String markerName;
    
    public HouseGPS(){
        
    }
    
    public HouseGPS(int latitude, int longitude, String markerName){
        this.latitude = latitude; //will show to user, read only
        this.longitude = longitude; //will show to user, read only
        this.markerName = markerName; //user will input marker
    }
    
    public int getLatitude(){
        return latitude;
    }
    
    public void setLatitude(int latitude){
        this.latitude = latitude;
    }
    
    public int getLongitude(){
        return longitude;
    }
    
    public void setLongitude(int longitude){
        this.longitude = longitude;
    }
    
    public String getMarkerName(){
        return markerName;
    }
    
    public void setMarkerName(String markerName){
        this.markerName = markerName;
    }
    
    public void saveHome(){
        System.out.println("Set this as home? ");
        //user input
    }
    
    public void retrieveCoordinates(){
        System.out.println("Coordinates of your home: " + latitude + " " + longitude);
    }
}
