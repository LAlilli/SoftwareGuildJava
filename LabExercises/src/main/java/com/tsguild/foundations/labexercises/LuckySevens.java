/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.labexercises;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author LA-San
 */
public class LuckySevens {
    public static void main(String[] args){
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
}
