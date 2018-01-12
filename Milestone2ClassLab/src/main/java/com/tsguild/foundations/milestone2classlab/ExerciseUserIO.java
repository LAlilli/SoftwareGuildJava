/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.milestone2classlab;

import java.util.Scanner;
/**
 *
 * @author LA-San
 */
public abstract class ExerciseUserIO implements UserIO {
    
    Scanner userInput = new Scanner(System.in);
    
    @Override
    public void print(String message){
        System.out.println("Don't Repeat Yourself. ");
    }

    @Override
    public double readDouble(String prompt){
        System.out.println("Please enter a double. ");
        prompt = userInput.nextLine();
        double userNum = Double.parseDouble(prompt);
        
        return userNum;
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        min = 1;
        max = 100;
        
        System.out.println("Please enter a double. ");
        prompt = userInput.nextLine();
        double userNum = Double.parseDouble(prompt);
        
        while(userNum < 1 || userNum > 100){
            System.out.println("Number is not in range. Please enter another number. ");
            System.out.println("Please enter a minimum. ");
            prompt = userInput.nextLine();
            userNum = Double.parseDouble(prompt);
        }
        
        return userNum;
    }

    @Override
    public float readFloat(String prompt){
        System.out.println("Please enter a float. ");
        prompt = userInput.nextLine();
        float userNum = Float.parseFloat(prompt);
        
        return userNum;
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        min = 1;
        max = 100;
        
        System.out.println("Please enter a float. ");
        prompt = userInput.nextLine();
        float userNum = Float.parseFloat(prompt);
        
        while(userNum < 1 || userNum > 100){
            System.out.println("Number is not in range. Please enter another number. ");
            System.out.println("Please enter a minimum. ");
            prompt = userInput.nextLine();
            userNum = Float.parseFloat(prompt);
        }
        
        return userNum;
    }

    @Override
    public int readInt(String prompt){
        System.out.println("Please enter an integer: ");
        prompt = userInput.nextLine();
        
        int userNum = Integer.parseInt(prompt);
        
        return userNum;
    }

    @Override
    public int readInt(String prompt, int min, int max){
        max = 100;
        min = 1;
        
        System.out.println("Please enter a number. ");
        prompt = userInput.nextLine();
        int userNum = Integer.parseInt(prompt);
        
        while(userNum < 1 || userNum > 100){
            System.out.println("Number is not in range. Please enter another number. ");
            System.out.println("Please enter a minimum. ");
            prompt = userInput.nextLine();
            userNum = Integer.parseInt(prompt);
        }
        
        return userNum;
    }

    @Override
    public abstract long readLong(String prompt);

    @Override
    public abstract long readLong(String prompt, long min, long max);

    @Override
    public String readString(String prompt){
        System.out.println("What's your favorite game? ");
        prompt = userInput.nextLine();
        
        return prompt;
    }
}
