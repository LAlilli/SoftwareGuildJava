/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random.assignmentrandom5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class HighRoller {
    public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner userInput = new Scanner(System.in);

        System.out.println("How many sides does the dice have? ");
        int x = userInput.nextInt();
        
        System.out.println("You entered: " + x);
        
        int rollResult = diceRoller.nextInt(x) + 1;
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a crit failure! Ouch.");
        } else if(rollResult == x){
            System.out.println("You rolled a critical! Nice job!");
        } else {
            System.out.println("Roll again.");
        }
    }
}
