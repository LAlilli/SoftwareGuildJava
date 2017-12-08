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
public class PassingTheTuringTest {
    public static void main(String[] args){
        String name, color, favFood;
        int num;
        
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("Welcome! What is your name? ");
        name = inputUser.nextLine();
        
        System.out.print("Nice to meet you, " + name + ". ");
        System.out.println("My name is LA.");
        
        System.out.print("What is your favorite color? ");
        color = inputUser.nextLine();
        
        System.out.println("Your favorite color is " + color + "? Mine is too!");
        System.out.print("What is your favorite food? Mine is chocolate. ");
        favFood = inputUser.nextLine();
        
        System.out.println(favFood + ", huh, sounds delicious.");
        System.out.print("Do you have a lucky number? ");
        num = inputUser.nextInt();
        System.out.println(num + " is a lucky number!");
        System.out.print("Thanks for talking to me, " + name);
    }
}
