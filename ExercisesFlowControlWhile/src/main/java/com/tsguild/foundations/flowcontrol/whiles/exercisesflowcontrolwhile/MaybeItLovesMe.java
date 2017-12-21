/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles.exercisesflowcontrolwhile;

import java.util.Random;

/**
 *
 * @author LA-San
 */
public class MaybeItLovesMe {
    public static void main(String[] args){
        Random randomNum = new Random();
        boolean lovesMe = false;
        int randomPetals = randomNum.nextInt((89 - 13) + 1) + 13;
        
        System.out.println("Here it goes...");
        
        while(randomPetals > 0){
            if((randomPetals%2) == 0){
                lovesMe = true;
                System.out.println("It loves me!");
            } else {
                lovesMe = false;
                System.out.println("It loves me not!");
            }
            randomPetals--;
        }
        
        if(lovesMe == false){
            System.out.println("Awwww, bummer.");
        } else {
            System.out.println("Oh wow! It really LOVES me!");
        } 
    }
}
