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
public class AllTheTrivia {
    public static void main(String[] args){
        //takes user input and mixes up answers
        
        String answer1, answer2, answer3, answer4;
        
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("What's the capitol of Canada? ");
        answer1 = inputUser.nextLine();
        
        System.out.print("K-pop originated in what country? ");
        answer2 = inputUser.nextLine();
        
        System.out.print("How many tastebuds do you have? ");
        answer3 = inputUser.nextLine();
        
        System.out.print("What has nine lives? ");
        answer4 = inputUser.nextLine();
        
        System.out.println(answer4 + " is definitely a capitol.");
        System.out.println("I didn't know there was " + answer3 + " " + answer1);
        System.out.println(answer2 + " is the only animal with 9 lives.");
    }
}
