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
public class WaitAWhile {
    public static void main(String[] args) {

        int timeNow = 5; //if this was changed to 11 and bedTime left at 10, the loop would never run
        int bedTime = 10; //if this was changed to 11, the loop would run 5 times instead of 4

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
            //if timeNow++ was taken out, the loop would run infinitely
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}