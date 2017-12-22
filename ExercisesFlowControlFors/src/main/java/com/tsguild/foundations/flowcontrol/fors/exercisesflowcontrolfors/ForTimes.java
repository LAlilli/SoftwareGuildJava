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
public class ForTimes {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("What times table should be recited? ");
        int userNum = input.nextInt();
        
        for(int i = 1; i <= 15; i++){
            System.out.println(i + " * " + userNum + " is: " + (i*userNum));
        }
    }
}
