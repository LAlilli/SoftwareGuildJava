/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.assignmentmilestone1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class DogGenetics {
    public static void main(String[] args){
        Random breedRandom = new Random();
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is your dog's name? ");
        String dogName = userInput.nextLine();
        System.out.println("Ever wonder about " + dogName + "'s background?");
        System.out.println("Let's find out!");
        
        System.out.println(dogName + " is: ");
        
        //create float variable for each breed to get a percent
        float breed1 = breedRandom.nextFloat();
        float breed2 = breedRandom.nextFloat();
        float breed3 = breedRandom.nextFloat();
        float breed4 = breedRandom.nextFloat();
        float breed5 = breedRandom.nextFloat();
        
        float sum = breed1 + breed2 + breed3 + breed4 + breed5;
        
        //logic for percentage of breed
        breed1 = ((breed1 * 100)/sum);
        System.out.println((int)breed1 + "% Husky");
                
        breed2 = ((breed2 * 100)/sum);
        System.out.println((int)breed2 + "% Terrier");
                
        breed3 = ((breed3 * 100)/sum);
        System.out.println((int)breed3 + "% Labrador");
                
        breed4 = ((breed4 * 100)/sum);
        System.out.println((int)breed4 + "% Newfoundland");
                
        breed5 = ((breed5 * 100)/sum);
        System.out.println((int)breed5 + "% Mastiff");
        
        System.out.println();
        System.out.println("What an adorably unique mutt!");
    }
}
