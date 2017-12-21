/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.whiles.exercisesflowcontrolwhile;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class StayPositive {
    public static void main(String[] args){
        int counter;
        int num = 0;
        int i = 0;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What number should we count down from? ");
        counter = userInput.nextInt();
        
        System.out.println("Let's begin!");
        System.out.println();
        
        
        while(num < counter){
            
            if(i == 10){
                i = 0;
                System.out.print("\n");
            } else {
                System.out.print(counter-- + " ");
                i++;
            }
        }
        
        System.out.println();
        System.out.println();
        System.out.println("Better stop at 0!");
    }
}
