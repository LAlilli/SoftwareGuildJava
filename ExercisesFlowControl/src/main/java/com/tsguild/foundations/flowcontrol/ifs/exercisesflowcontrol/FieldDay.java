/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.flowcontrol.ifs.exercisesflowcontrol;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class FieldDay {
    public static void main(String[] args){
        String name;
        Scanner inputUser = new Scanner(System.in);
        
        System.out.print("What's your last name? ");
        name = inputUser.nextLine();
        
        if((name.compareTo("Baggins")) < 0){
            System.out.println("You're on the Red Dragons team!");
        } else if((name.compareTo("Baggins")) > 0 && (name.compareTo("Dresden")) < 0){
            System.out.println("You're on the Dark Wizards team!");
        } else if((name.compareTo("Dresden")) > 0 && (name.compareTo("Howl")) < 0){
            System.out.println("You're on the Moving Castles team!");
        } else if((name.compareTo("Howl")) > 0 && (name.compareTo("Potter")) < 0){
            System.out.println("You're on the Golden Snitches team!");
        } else if((name.compareTo("Potter")) > 0 && (name.compareTo("Vimes")) < 0){
            System.out.println("You're on the Night Guards team!");
        } else {
            System.out.println("You're on the Black Holes team!");
        }
    }
}
