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
public class BiggerBetterAdder {
    public static void main(String[] args){
        int x = 6;
        int y = 25;
        int z = 89;
        
        int sum;
        
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("Enter a number for X: ");
        x = inputUser.nextInt();
        
        System.out.print("Enter a number for Y: ");
        y = inputUser.nextInt();
        
        System.out.print("Enter a number for Z: ");
        z = inputUser.nextInt();
        
        sum = x + y + z;
        System.out.println("Sum of x,y,z is: " + sum);
    }
}
