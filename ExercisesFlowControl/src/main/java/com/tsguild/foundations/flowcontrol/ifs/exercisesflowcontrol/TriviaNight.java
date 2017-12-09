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
public class TriviaNight {
  public static void main(String[] args){
      int answer1 = 3;
      int answer2 = 1;
      int answer3 = 2;
      
      int userAnswer1, userAnswer2, userAnswer3;
      int correctAnswers = 0;
      
      Scanner inputUser = new Scanner(System.in);
      
      System.out.println("It's time for trivia!");
      System.out.println();
      System.out.println("FIRST QUESTION");
      System.out.println("What's the biggest city in Japan?");
      System.out.println("1) Hellsinki          2) Sapporo");
      System.out.println("3) Tokyo              4) Osaka");
      userAnswer1 = inputUser.nextInt();
      System.out.println();
      System.out.println("Your answer: " + userAnswer1);
      System.out.println();
      System.out.println("SECOND QUESTION");
      System.out.println("What does BSG stand for?");
      System.out.println("1) Battle Star Galatica          2) Bad Swearing Goats");
      System.out.println("3) Beats Sink Gurus              4) Bear Seal Goose");
      userAnswer2 = inputUser.nextInt();
      System.out.println();
      System.out.println("Your answer: " + userAnswer2);
      System.out.println();
      System.out.println("THIRD QUESTION");
      System.out.println("Finish this sentence: 'Leroy...!'");
      System.out.println("1) Jelly          2) Jenkins");
      System.out.println("3) Jack           4)Jump");
      userAnswer3 = inputUser.nextInt();
      System.out.println();
      System.out.println("Your answer: " + userAnswer3);
      System.out.println();
      
      if(answer1 == userAnswer1){
          correctAnswers++;
      }
      if(answer2 == userAnswer2){
          correctAnswers++;
      }
      if(answer3 == userAnswer3){
          correctAnswers++;
      }
      if(correctAnswers == 3){
          System.out.println("Wow you got all the questions correct!");
      } else if(correctAnswers == 2){
          System.out.println("Nice, you got 2 answers correct!");
      } else if(correctAnswers == 1){
          System.out.println("You got 1 answer correct.");
      } else {
          System.out.println("Bummer...you didn't get any right. Try again!");
      }
  }  
}
