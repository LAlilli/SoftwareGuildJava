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
public class RollerCoaster {
        public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        /*while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }*/ 
        
        //loop never runs if it's set to check for n first
        
        while (keepRiding.equals("n")) {
            System.out.println("Not doing it...");
            System.out.print("Do want to ride? (y/n) : ");
            keepRiding = userInput.nextLine();
            loopsLooped++;

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}
}
