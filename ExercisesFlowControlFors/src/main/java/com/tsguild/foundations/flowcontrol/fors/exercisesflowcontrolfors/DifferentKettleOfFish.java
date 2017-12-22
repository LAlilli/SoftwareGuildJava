/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors.exercisesflowcontrolfors;

/**
 *
 * @author LA-San
 */
public class DifferentKettleOfFish {
    public static void main(String[] args) {

        int fish;
        
        //updated initialization of fish to be in for loop
        //updated to be less than/equal to 10
        for(fish = 1; fish <= 10; fish++){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }
        }
        
        /*while(fish < 10){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }

            fish++;
        }*/

    }
}
