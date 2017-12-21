/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles.exercisesflowcontrolwhile;

/**
 *
 * @author LA-San
 */
public class LovesMe {
    public static void main(String[] args){
        int petals = 34;
        
        System.out.println("Well here it goes...");
        
        while(petals > 0){
            if((petals%2) == 0){
                System.out.println("It loves me NOT!");
            } else {
                System.out.println("It LOVES me!");
            }
            petals--;
        }
        
        //used a while loop b/c i needed the condition
        //checked first to run (based on # of petals)
        System.out.println("Yay, you're loved!");
    }
}
