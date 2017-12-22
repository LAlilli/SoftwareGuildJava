/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.fors.exercisesflowcontrolfors;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class ForTimesFor {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int answer, userNum, i;
        int points = 0;
        
        System.out.println("What times table should be recited? ");
        userNum = input.nextInt();
        
        for(i = 1; i <= 15; i++){
            System.out.println(i + " * " + userNum + " is: ");
            answer = input.nextInt();
            if(answer == (i * userNum)){
                System.out.println("Correct!");
                points++;
            } else {
                System.out.println("Sorry, the answer is: " + (i * userNum));
            }
        }
        
        if(points < (15%2)){
            System.out.println("You should study more, you got less than 50% correct.");
        } else if(points > 13){
            System.out.println("Wow, that's amazing, you got over 90%!!");
        } else{
            System.out.println("You got " + points + " correct.");
        }
    }
}
