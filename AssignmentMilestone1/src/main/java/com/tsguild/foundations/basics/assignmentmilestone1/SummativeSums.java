/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.assignmentmilestone1;

/**
 *
 * @author LA-San
 */
public class SummativeSums {
    public static void main(String[] args){
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array2 = { 999, -60, -77, 14, 160, 301 };
        int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 };
        
        System.out.println("#1 Array sum: " + sumArray(array1));
        System.out.println("#2 Array sum: " + sumArray(array2));
        System.out.println("#3 Array sum: " + sumArray(array3));
    }
    
    public static int sumArray(int[] numbers){
        int sum = 0;
        int i;
        
        for(i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        
        return sum;
    }
}
