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
public class AirplaneControlSystem {
    private String flightName; //entered by user
    private boolean clearanceApproval; //read only
    private String callSign; //read only
    
    public AirplaneControlSystem(){
        
    }
    
    public AirplaneControlSystem(String flightName, boolean clearanceApproval, String callSign){
        this.flightName = flightName;
        this.clearanceApproval = clearanceApproval;
        this.callSign = callSign;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public boolean isClearanceApproval() {
        return clearanceApproval;
    }

    public void setClearanceApproval(boolean clearanceApproval) {
        this.clearanceApproval = clearanceApproval;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }
    
    public void clearedLanding(boolean clearanceApproval){
        //if boolean is true
        System.out.println("You're cleared for landing!");
        
        //if boolean is false
        System.out.println("Not cleared, wait.");
    }
    
    public String requestCallSign(String callSign){
        System.out.println("Please provide your call sign, pilot.");
        
        return callSign;
    }
}
