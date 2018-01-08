/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.milestone2calculator;

/**
 *
 * @author LA-San
 */
public class SimpleCalculator {
    //performs addition, subtraction, multiplication, division
    public void add(int userNum1, int userNum2){
        int sum = userNum1 + userNum2;
        
        System.out.println("Sum of the numbers you entered: " + sum);
    }
    
    public void subtract(int userNum1, int userNum2){
        int sum = userNum1 - userNum2;
        
        System.out.println("Sum of the numbers you entered: " + sum);
    }
    
    public void multiply(int userNum1, int userNum2){
        int result = userNum1 * userNum2;
        
        System.out.println("Sum of the numbers you entered: " + result);
    }
    
    public void divide(float userNum1, float userNum2){
        float result = userNum1/userNum2;
        
        System.out.println("Sum of the numbers you entered: " + result);
    }
}
