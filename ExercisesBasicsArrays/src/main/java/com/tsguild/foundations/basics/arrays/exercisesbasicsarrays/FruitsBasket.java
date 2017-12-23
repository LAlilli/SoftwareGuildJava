/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.arrays.exercisesbasicsarrays;

/**
 *
 * @author LA-San
 */
public class FruitsBasket {
    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        String[] apple = new String[28];
        String[] orange = new String[33];
        int apples = 0;
        int oranges = 0;
        
        // Fruit sorting code goes here!
        for(int i = 0; i < fruit.length; i++){
            if("Apple" == fruit[i]){
                apples++;
            } else if("Orange" == fruit[i]){
                oranges++;
            }
        }
        System.out.println("Total # of apples: " + apples);
        System.out.println("Total # of oranges: " + oranges);
        
        int appleCount = 0;
        int orangeCount = 0;
        for(int j = 0; j < fruit.length; j++){
            if("Apple" == fruit[j]){
                apple[appleCount] = fruit[j];
                appleCount++;
            } else if("Orange" == fruit[j]){
                orange[orangeCount] = fruit[j];
                orangeCount++;
            }
        }
        
        System.out.println("Total number of apples in apple array: " + appleCount);
        System.out.println("Total number of oranges in orange array: " + orangeCount);
        System.out.println("Total number of fruit: " + fruit.length);
    }
}
