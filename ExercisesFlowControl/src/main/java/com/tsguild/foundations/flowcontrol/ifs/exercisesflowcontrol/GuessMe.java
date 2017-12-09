/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs.exercisesflowcontrol;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class GuessMe {
    public static void main(String[] args){
        int x = 6;
        int userGuess;
        
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("Guess my number: ");
        userGuess = inputUser.nextInt();
        System.out.println("Your guess: " + userGuess);
        
        if(userGuess == x){
            System.out.println("Wow, nice guess! That was it");
        }
        
        if(userGuess < x){
            System.out.println("Ha, nice try - too low! I chose " + x);
        }
        
        if(userGuess > x){
            System.out.println("Too bad, way too high. I chose " + x);
        }
    }
}
