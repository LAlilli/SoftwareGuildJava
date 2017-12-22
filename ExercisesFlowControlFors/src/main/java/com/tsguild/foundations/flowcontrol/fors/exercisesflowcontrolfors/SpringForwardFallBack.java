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
public class SpringForwardFallBack {
    public static void main(String[] args) { 

        //starts at 0, prints out to 9
        System.out.println("It's Spring...!");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + ", ");
        }

        //starts at 10, prints out to 1
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}
