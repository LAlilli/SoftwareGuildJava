/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.labexercises;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        
        BigDecimal annualIntRate;
        BigDecimal quarterly = new BigDecimal("4");
        BigDecimal principal;
        BigDecimal quarterlyIntRate;
        BigDecimal totalInterest;
        int years;
        int i;
        
        InterestCalculator calculator = new InterestCalculator();
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is the annual interest rate? ");
        annualIntRate = userInput.nextBigDecimal();
        quarterlyIntRate = calculator.calculate(MathOperator.DIVIDE, annualIntRate, quarterly); 
        System.out.println();
        
        System.out.println("What is the initial principal amount? ");
        principal = userInput.nextBigDecimal();
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
    
    public BigDecimal calculate(MathOperator operator, BigDecimal operand1, BigDecimal operand2){
        switch (operator){
            case PLUS:
                return operand1.add(operand2);
            case MINUS:
                return operand1.subtract(operand2);
            case MULTIPLY:
                return operand1.multiply(operand2);
            case DIVIDE:
                return operand1.divide(operand2, 2, RoundingMode.HALF_UP);
            default:
                throw new UnsupportedOperationException("Unknown Math Operator");
        }
    }
}
