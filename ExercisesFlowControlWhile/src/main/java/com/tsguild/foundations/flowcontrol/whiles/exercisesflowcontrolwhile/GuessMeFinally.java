/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles.exercisesflowcontrolwhile;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class GuessMeFinally {
    public static void main(String[] args){
        Random randomNum = new Random();
        Scanner userInput = new Scanner(System.in);
        int aiNum = randomNum.nextInt(100 - (-100) + 1) + (-100);
        int counter = 0;
        
        System.out.println("Guess a number between -100 and 100: ");
        int userNum = userInput.nextInt();
        
        System.out.println("Your guess: " + userNum);
        
        if(userNum == aiNum && counter == 0){
            System.out.println("Wow, nice guess! That was it!");
            System.out.println("It was " + aiNum);
        } else {
        while(userNum != aiNum){
            if(userNum > aiNum){
                System.out.println("Whoa, too high! Try again!");
                userNum = userInput.nextInt();
                System.out.println("Your guess: " + userNum);
            } else if(userNum < aiNum){
                System.out.println("Bummer, too low. Try again!");
                userNum = userInput.nextInt();
                System.out.println("Your guess: " + userNum);
            } else {
                System.out.println("Too bad, so sad. Try again!");
                userNum = userInput.nextInt();
                System.out.println("Your guess: " + userNum);
            }
            counter++;
        }
      }
    }
}
