/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone3exercises;

import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class DaysOfTheWeek {
    Day day;
    
    public DaysOfTheWeek(Day day){
        this.day = day;
    }
    
    public void howManyDaysTilFriday(){
        switch (day){
            case MONDAY:
                System.out.println("There are 4 days left until Friday. ");
                break;
            case TUESDAY:
                System.out.println("There are 3 days left until Friday. ");
                break;
            case WEDNESDAY:
                System.out.println("There are 2 days left until Friday. ");
                break;
            case THURSDAY:
                System.out.println("There is 1 day left until Friday. ");
                break;
            case FRIDAY:
                System.out.println("IT'S FRIDAY!");
                break;
            case SATURDAY:
                System.out.println("There are 6 days left until Friday. ");
                break;
            case SUNDAY:
                System.out.println("There are 5 days left until Friday. ");
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("What's the day today? ");
        String input = userInput.nextLine();
        
        if(input.equals("Monday")){
            DaysOfTheWeek monday = new DaysOfTheWeek(Day.MONDAY);
            monday.howManyDaysTilFriday();
        } else if (input.equals("Tuesday")){
            DaysOfTheWeek tuesday = new DaysOfTheWeek(Day.TUESDAY);
            tuesday.howManyDaysTilFriday();
        } else if (input.equals("Wednesday")){
            DaysOfTheWeek wednesday = new DaysOfTheWeek(Day.WEDNESDAY);
            wednesday.howManyDaysTilFriday();
        } else if (input.equals("Thursday")){
            DaysOfTheWeek thursday = new DaysOfTheWeek(Day.THURSDAY);
            thursday.howManyDaysTilFriday();
        } else if (input.equals("Saturday")){
            DaysOfTheWeek saturday = new DaysOfTheWeek(Day.SATURDAY);
            saturday.howManyDaysTilFriday();
        } else if (input.equals("Sunday")){
            DaysOfTheWeek sunday = new DaysOfTheWeek(Day.SUNDAY);
            sunday.howManyDaysTilFriday();
        } else {
            DaysOfTheWeek friday = new DaysOfTheWeek(Day.FRIDAY);
            friday.howManyDaysTilFriday();
        }
    }
}
