/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.milestone2calculator;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class App {
    //UI - handles all user input/output
    public static void main(String[] args){
        //variables
        Scanner userInput = new Scanner(System.in);
        int userNum1 = 0, userNum2 = 0;
        int add = 1;
        int subtract = 2;
        int multiply = 3;
        int divide = 4;
        int quit = 0;
        String answer, choice;
        boolean continueProgram = true;
        SimpleCalculator myCalc = new SimpleCalculator();
        
        System.out.println("Welcome!");
        
        while(continueProgram){
           System.out.println("What would you like to do? ");
           System.out.println("Please choose: 1. Add  2. Subtract  3. Multiply  4. Divide");
           System.out.println("Or 0. Exit program. ");
           choice = userInput.nextLine();
           
           if(choice.equals("0")){
               System.out.println("Thank you for using the program. Bye!");
               continueProgram = false;
               break;
           } else {
                 System.out.println("Please enter a number. ");
                 answer = userInput.nextLine();
                 userNum1 = Integer.parseInt(answer);
                 System.out.println("Please enter a second number. ");
                 answer = userInput.nextLine();
                 userNum2 = Integer.parseInt(answer);
                 
                 if(choice.equals("1")){
                     myCalc.add(userNum1, userNum2);
                 } else if(choice.equals("2")){
                     myCalc.subtract(userNum1, userNum2);
                 } else if(choice.equals("3")){
                     myCalc.multiply(userNum1, userNum2);
                 } else if(choice.equals("4")){
                     myCalc.divide(userNum1, userNum2);
                 }
            }  
        }   
    }
}
