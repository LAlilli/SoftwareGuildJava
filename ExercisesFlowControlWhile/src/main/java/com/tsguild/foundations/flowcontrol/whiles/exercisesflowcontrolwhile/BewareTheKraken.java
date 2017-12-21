/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles.exercisesflowcontrolwhile;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author LA-San
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randFish = new Random();
        String stop;
        
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(true){ // original condition: depthDivedInFt < 36200; loop continues to run while set at true
            int fishNum = randFish.nextInt((4-1) + 1) + 1;
            
            System.out.println("So far, we've swam " + depthDivedInFt + " feet");
            System.out.println("Do you want to keep diving? (y/n) ");
            stop = input.next();
            
            if(stop.equals("n")){
                System.out.println("Ok, let's surface.");
                break;
            }
            
            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }
            
            if(fishNum == 1){
                System.out.println("Look, there's a clownfish!");
            } else if(fishNum == 2){
                System.out.println("Wow, there's a sea bass!");
            } else if(fishNum == 3){
                System.out.println("Aw, it's a baby sea horse.");
            } else {
                System.out.println("Oh boy, a hammerhead shark!");
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
