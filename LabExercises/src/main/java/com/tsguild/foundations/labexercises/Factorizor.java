/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.labexercises;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class Factorizor {

    public static void main(String[] args){
        int userNum;
        int factor = 0;
        int sum = 0;
    
        Scanner userInput = new Scanner(System.in);
    
        System.out.println("What number would you like to factor? ");
        userNum = userInput.nextInt();
        System.out.println("The factors of " + userNum + " are: ");
        for(int i = 1; i < userNum; i++){
            if((userNum%i) == 0){
                System.out.println(i);
                factor++;
                sum = i + i;
            }
        }
        if(sum == userNum){
            System.out.println(userNum + " is a perfect number.");
        } else {
            System.out.println(userNum + " is not a perfect number.");
        }
        if(factor == 1){
            System.out.println(userNum + " is a prime number.");
        } else {
            System.out.println(userNum + " is not a prime number.");
        }
    }
}
