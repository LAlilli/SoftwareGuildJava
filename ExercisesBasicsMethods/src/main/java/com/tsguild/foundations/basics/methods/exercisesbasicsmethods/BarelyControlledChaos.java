/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.methods.exercisesbasicsmethods;

import java.util.Random;

/**
 *
 * @author LA-San
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = randomColor(); // call color method here 
        String animal = randomAnimal(); // call animal method again here 
        String colorAgain = randomColor(); // call color method again here 
        int weight = randomInt(200, 5); // call number method, 
            // with a range between 5 - 200 
        int distance = randomInt(20, 10); // call number method, 
            // with a range between 10 - 20 
        int number = randomInt(2000, 1000); // call number method, 
            // with a range between 10000 - 20000 
        int time = randomInt(6, 2); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public static String randomColor(){
        Random randColor = new Random();
        int randomColor = randColor.nextInt((5 - 1) +1) +1;
        
        if(randomColor == 1){
            return "green";
        } else if(randomColor == 2){
            return "blue";
        } else if(randomColor == 3){
            return "black";
        } else if(randomColor == 4){
            return "turqoise";
        } else {
            return "charteuse";
        }
    }
    
    public static String randomAnimal(){
        Random randAnimal = new Random();
        int randomAnimal = randAnimal.nextInt((5 - 1) +1) +1;
        
        if(randomAnimal == 1){
            return "antelope";
        } else if(randomAnimal == 2){
            return "wolf";
        } else if(randomAnimal == 3){
            return "turtle";
        } else if(randomAnimal == 4){
            return "tiger";
        } else {
            return "emu";
        }
    }
    
    public static int randomInt(int a, int b){
        Random randInt = new Random();
        int randomNum = randInt.nextInt((a - b) + b) + b;
        
        return randomNum;
    }
}