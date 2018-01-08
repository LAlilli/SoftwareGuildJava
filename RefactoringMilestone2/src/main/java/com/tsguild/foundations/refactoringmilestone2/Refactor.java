/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.refactoringmilestone2;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author LA-San
 */
public class Refactor {
    
    public void luckySevens(){
        int moneyAvailable;
        int dice1;
        int dice2;
        int sum = 0;
        int i;
        int numberOfRolls = 0;
        //int numberOfRollsMax; tracking how many rolls when most money
        
        Scanner userInput = new Scanner(System.in);
        Random randDice = new Random();
        
        System.out.println("How much money do you have to bet? ");
        moneyAvailable = userInput.nextInt();
        
        for(i = 0; i < moneyAvailable; i++){
           //role dice
           dice1 = randDice.nextInt(6) + 1;
           dice2 = randDice.nextInt(6) + 1;
           
           sum = dice1 + dice2;
           
           if(sum == 7){
               moneyAvailable = moneyAvailable + 4;
           } else {
               moneyAvailable = moneyAvailable - 1;
           }
           numberOfRolls++;
        }
        
        System.out.println("You're broke after " + numberOfRolls + " rolls.");
    }
    
    public void interestCalculator(){
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
    
    public void factorizor(){
         int userNum;
        int factor = 0;
        int sum = 0;
    
        Scanner userInput = new Scanner(System.in);
    
        System.out.println("What number would you like to factor? ");
        userNum = userInput.nextInt();
        System.out.println("The factors of " + userNum + " are: ");
        for(int i = 1; i < userNum; i++){
            if((userNum%i) == 0){
                System.out.println(i);
                factor++;
                sum = i + i;
            }
        }
        if(sum == userNum){
            System.out.println(userNum + " is a perfect number.");
        } else {
            System.out.println(userNum + " is not a perfect number.");
        }
        if(factor == 1){
            System.out.println(userNum + " is a prime number.");
        } else {
            System.out.println(userNum + " is not a prime number.");
        }
    }
    
    public void rockPaperScissors() {
        int rock = 1, paper = 2, scissors = 3; //variables for choice
        int tie = 0, userWin = 0, aiWin = 0; //variables for counting wins/ties
        int rounds, i , userChoice, aiChoice; //variables for rounds, iterator and choice
        boolean playAgain = true;
        String answer; //for user input
        
        Scanner userInput = new Scanner(System.in); //scanner for numeric entries
        Random randChoice = new Random();
        
        System.out.println("Welcome! Let's play Rock Paper Scissors! \n");
        
        while(playAgain == true){
            System.out.println("How many rounds would you like to play? ");
            answer = userInput.nextLine();
            rounds = Integer.parseInt(answer);
        
            if(rounds > 10){
                System.out.println("Sorry that's WAY too many rounds!");
            } else if(rounds < 1){
                System.out.println("Hmm, I don't think we can play a negative amount of rounds...");
            }
        
            for(i = 1; i <= rounds; i++){
                System.out.println("\n ROUND " + i);
                System.out.println("Ready? Choose: 1)Rock 2)Paper 3)Scissors ");
                answer = userInput.nextLine();
                userChoice = Integer.parseInt(answer);
                
                //logic to compare computer choice and user choice
                aiChoice = randChoice.nextInt(3) + 1;
                if(aiChoice == userChoice){
                    System.out.println("It's a tie!");
                    tie++;
                } else if(aiChoice == 1 && userChoice == 2){
                    System.out.println("You win!");
                    userWin++;
                } else if(aiChoice == 2 && userChoice == 1){
                    System.out.println("Ha, I win!");
                    aiWin++;
                } else if(aiChoice == 2 && userChoice == 3){
                    System.out.println("You win!");
                    userWin++;
                } else if(aiChoice == 1 && userChoice == 3){
                    System.out.println("Ha, I win!");
                    aiWin++;
                } else if(aiChoice == 3 && userChoice == 1){
                    System.out.println("You win!");
                    userWin++;
                } else if(aiChoice == 3 && userChoice == 2){
                    System.out.println("Ha, I win!");
                    aiWin++;
                }
            }
        
            System.out.println();
        
            System.out.println("Number of ties: " + tie);
            System.out.println("Number of user wins: " + userWin);
            System.out.println("Number of ai wins: " + aiWin);
        
            System.out.println();
        
            if(userWin > aiWin && userWin > tie){
                System.out.println("Congrats, you won!");
            } else if(userWin < aiWin){
                System.out.println("Nice try, I win!");
            } else if(userWin < tie && aiWin < tie){
                System.out.println("Guess it's a tie!");
            }
        
            //ask user to play again
            System.out.println();
            System.out.println("Did you want to play again? (y/n) ");
            answer = userInput.nextLine();
            System.out.println();
        
            if(answer.equals("y")){
                playAgain = true;
                aiWin = 0;
                userWin = 0;
                tie = 0;
            } else if(answer.equals("n")){
                playAgain = false;
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }
}
