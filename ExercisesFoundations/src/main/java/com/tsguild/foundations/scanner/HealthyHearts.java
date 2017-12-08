/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class HealthyHearts {
    public static void main(String[] args){
        int age;
        double maxHeartRate, targetHeartRateMin, targetHeartRateMax;
        
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("What is your age? ");
        age = inputUser.nextInt();
        
        maxHeartRate = 220 - age;
        targetHeartRateMin = maxHeartRate * 0.5;
        targetHeartRateMax = maxHeartRate * 0.85;
        
        System.out.println("Your maximum heart rate should be " + (int)maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + (int)targetHeartRateMin + " - " + (int)targetHeartRateMax + " beats per minute.");
    }
}
