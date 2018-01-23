/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dto;

/**
 *
 * @author LA-San
 */
public class Address {
    private String firstName;
    private String lastName;
    private String street;
    private String cityState;
    private String zipCode;

    public Address(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    } 
    
    public String getZipCode(){
        return zipCode;
    }
    
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
}
