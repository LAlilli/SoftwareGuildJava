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
public class TheCount {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("***LET'S COUNT TOGETHER!***");
        System.out.println();
        
        System.out.println("Start at: ");
        int start = input.nextInt();
        
        System.out.println("Stop at: ");
        int stop = input.nextInt();
        
        System.out.println("Count by: ");
        int count = input.nextInt();
        
        System.out.println();
        int x = 0;
        
        for(int i = start; i < stop; i+=count){
            System.out.print(i + " ");
            x++;
            if(x == 3){
                x = 0;
                System.out.print(" - Ah ah ah! \n");
            }
        }
    }
}
