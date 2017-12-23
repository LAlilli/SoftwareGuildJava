/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.arrays.exercisesbasicsarrays;

import java.util.Random;

/**
 *
 * @author LA-San
 */
public class HiddenNuts {
    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        
        // Nut finding code should go here! 
        for(int i = 0; i < 100; i++){
            if(hidingSpots[i] == ("Nut")){ //when to use equals for comparing strings
                System.out.println("Found it! It was hidden in spot #" + i);
            } 
        }
    }
}
