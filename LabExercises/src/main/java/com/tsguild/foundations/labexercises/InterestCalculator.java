/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.labexercises;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class InterestCalculator {
    public static void main(String[] args){
        //comeback to complete challenge
        //Change the program so that interest is compounded monthly.
        //Change the program so that the user can choose from quarterly, monthly, or daily interest compound periods
        
        float annualIntRate;
        float principal;
        float quarterlyIntRate;
        float totalInterest;
        int years;
        int i;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is the annual interest rate? ");
        annualIntRate = userInput.nextFloat();
        quarterlyIntRate = (annualIntRate/4);
        System.out.println();
        
        System.out.println("What is the initial principal amount? ");
        principal = userInput.nextFloat();
        System.out.println();
        
        System.out.println("How many years will the money stay in the fund? ");
        years = userInput.nextInt();
        
        System.out.println();
        
        for(i = 1; i <= years; i++){
            System.out.println("Year #" + i);
            System.out.println("Principal at the beginning of the year: $" + principal);
            
            totalInterest = (4 * (principal * (1 + quarterlyIntRate/100)));
            System.out.println("Total interest accrued over the year: $" + totalInterest);
            
            principal = principal + (4 * (principal * (1 + quarterlyIntRate/100)));
            System.out.println("Principal at the end of the year: $" + principal);
            
            System.out.println();
        }
    }
}
