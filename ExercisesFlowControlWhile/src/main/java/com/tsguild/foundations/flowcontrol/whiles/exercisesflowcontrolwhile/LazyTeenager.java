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
public class LazyTeenager {
    public static void main(String[] args){
        Random num = new Random();
        int counter = 0;
        int randChance = num.nextInt((100-5) + 5) + 5;
        
        do{
            counter++;
            
            System.out.println("Clean your room! " + " (x" + counter + ")");
            
            if(counter == 15){
                System.out.println("That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            } else if(randChance < 15){
                System.out.println("Fine! I'll clean my room...");
                break;
            }
        }while(true);
    }
}
