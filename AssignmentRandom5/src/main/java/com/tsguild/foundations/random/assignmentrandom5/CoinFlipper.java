/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.random.assignmentrandom5;
import java.util.Random;

/**
 *
 * @author LA-San
 */
public class CoinFlipper {
    public static void main(String[] args){
        Random coinFlipper = new Random();
        
        System.out.println("Let's play a game!");
        System.out.println("Ready...Flip...!");
        
        boolean coinFlipResult = coinFlipper.nextBoolean();
        
        if(coinFlipResult == true){
            System.out.println("You got HEADS!");
        } else if(coinFlipResult == false){
            System.out.println("You got TAILS!");
        }
    }
}
