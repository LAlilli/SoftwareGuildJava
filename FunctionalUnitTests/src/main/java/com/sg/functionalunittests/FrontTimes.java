/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.functionalunittests;

/**
 *
 * @author LA-San
 */
public class FrontTimes {
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    public String frontTimes(String str, int n) {
        
        StringBuilder times = new StringBuilder();
        
        for(int i = 0; i < n; i++){
           times.append(str.substring(0, 3));
        }
        
        return times.toString();
    }
}
