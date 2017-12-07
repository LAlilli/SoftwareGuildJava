/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.variables.core.exercises;

/**
 *
 * @author LA-San
 */
public class MenuOfChampions {
    public static void main(String[] args){
        String burger = "LAN Burger";
        String soup = "Tomato Basil Soup";
        String dessert = "Chocolate Torte";
        
        double burgerPrice = 8.95;
        double soupPrice = 4.50;
        double dessertPrice = 5.00;
        
        //Add in ASCII Art
        
        System.out.println("WELCOME TO LAN CAFE!");
        System.out.println("Today's Menu Is...");
        System.out.println(burger + "    $ " + burgerPrice);
        System.out.println(soup + "    $ " + soupPrice);
        System.out.println(dessert + "    $ " + dessertPrice);
    }
}
