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
public class DoOrDoNot {
        public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }
        
        //prints out "I did it!" if you tell it to
        //prints out "I know you said not to...
        //but I totally did anyways." if no

        boolean iDidIt = false;

        /*do {
            iDidIt = true;
            break;
        } while (doIt);*/
        
        while(doIt){
            iDidIt = true;
            break;
        }
        
        //prints out "I did it!" &
        // "Don't look at me, I didn't do anything!"

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
    }
}
