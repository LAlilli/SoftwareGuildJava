/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.refactoringmilestone2;

/**
 *
 * @author LA-San
 */
public class App {
    public static void main(String[] args){
       Refactor myApp = new Refactor();
       
       myApp.factorizor();
       System.out.println();
       
       myApp.interestCalculator();
       System.out.println();
       
       myApp.luckySevens();
       System.out.println();
       
       myApp.rockPaperScissors();
    }
}
