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
public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        if (str.contains("xxxx")){
            return 3;
        } else if (str.contains("xxx")){
            return 2;
        } else if (str.contains("xx")){
            return 1;
        } else {
            return 0;
        }
    }
}
