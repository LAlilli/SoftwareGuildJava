/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.milestone2classlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

/**
 *
 * @author LA-San
 */
public class StudentQuizGrades implements UserIO {
    private Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args){
        
        StudentQuizGrades student = new StudentQuizGrades();
        HashMap<String, ArrayList<Integer>> studentQuizzes = new HashMap<>();
        boolean selection = true;

        //create example list one and store value
        ArrayList<Integer> student1 = new ArrayList<Integer>();
        student1.add(65);
        student1.add(88);
        student1.add(99);
        student1.add(74);
        
        //create example list two and store values
        ArrayList<Integer> student2 = new ArrayList<Integer>();
        student2.add(95);
        student2.add(96);
        student2.add(95);
        student2.add(90);
        
        //put values into map
        studentQuizzes.put("Harry Potter", student1);
        studentQuizzes.put("Tom Riddle", student2);
        
        System.out.println("STUDENTS OF HOGWARTS - QUIZ SCORES");
        System.out.println("===================================");
        
        while(selection){
            String input = student.readString("Please select from the following: "
                    + "1. See list of students   2. Add student   3. Remove student   "
                    + "4. View list of quiz scores for specific student   "
                    + "5. View average quiz score for specific student   "
                    + "0. Exit program ");
            System.out.println();

            if(input.equals("1")){
                //print out list of students based on hashmap
                for (Map.Entry<String, ArrayList<Integer>> entry : studentQuizzes.entrySet()){
                    String studentName = entry.getKey();
                    System.out.println(studentName);
                    System.out.println();
                }
            } else if(input.equals("2")){
                String name = student.readString("What is the student's name? ");

                System.out.println();
                boolean addQuizScores = true;
                ArrayList<Integer> additionalStudents = new ArrayList<>();
                while(addQuizScores){
                    additionalStudents.add(student.readInt("What is the quiz score? "));
                    
                    System.out.println();
                    input = student.readString("Did you have additional quiz scores to enter? (y/n) ");
                    System.out.println();
                    if(input.equals("y")){
                        addQuizScores = true;
                    } else {
                        addQuizScores = false;
                    }
                }
                
                System.out.println();
                studentQuizzes.put(name, additionalStudents);
                System.out.println(studentQuizzes);
                System.out.println();

            } else if(input.equals("3")){
                String name = student.readString("What is the student's name that you wish to remove?");
                
                System.out.println();
                studentQuizzes.remove(name);
                System.out.println(studentQuizzes);
                System.out.println();

            } else if(input.equals("4")){
                String name = student.readString("For what student would you like to see quiz scores? ");
                
                System.out.println();
                ArrayList<Integer> scores = studentQuizzes.get(name);
                student.print("The following are quiz scores for " + name + " \n" + scores);
                System.out.println();

            } else if(input.equals("5")){
                String name = student.readString("For what student would you like to see an average quiz score? ");
                System.out.println();
                ArrayList<Integer> avgScore = studentQuizzes.get(name);
                
                //determine average
                int sum = 0;
                for(Integer counter : avgScore){
                    sum += counter;
                }
                int average = (sum / avgScore.size());
                
                student.print("The following is the average quiz score for " + name + " \n" + average);
                System.out.println();

            } else if(input.equals("0")){
                student.print("Exiting program. ");
                selection = false;
                break;
            } else {
                student.print("That is not a valid selection. Please choose by selecting the corresponding number. ");
                System.out.println();
            }
        }
    }
    
    @Override
    public void print(String message){
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        double numInput = Double.parseDouble(input);
        
        return numInput; 
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        double numInputMin = Double.parseDouble(input);
        
        System.out.println(prompt);
        input = userInput.nextLine();
        
        double numInputMax = Double.parseDouble(input);
        
        return numInputMax; 
    }
    
    @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        int numInput = Integer.parseInt(input);
        
        return numInput;
    }

    @Override
    public int readInt(String prompt, int min, int max){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        int numInput = Integer.parseInt(input);
        
        return numInput;
    }
    
    @Override
    public String readString(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        return input;
    }
    
    @Override
    public long readLong(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        long numInput = Long.parseLong(input);
        
        return numInput;
    }

    @Override
    public long readLong(String prompt, long min, long max){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        long numInput = Long.parseLong(input);
        
        return numInput;
    }
    
    @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        float numInput = Float.parseFloat(input);
        
        return numInput;
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        float numInput = Float.parseFloat(input);
        
        return numInput;
    }
}

/*
COMMENTS ON CHALLENGES

+figuring out how to save multiple values for same key in hashmap
+determining how to use UserIO methods (instantiate object from class, use method, enter string for prompt)

RESOURCES
+ https://dzone.com/articles/hashmap-%E2%80%93-single-key-and
+ https://stackoverflow.com/questions/19541582/storing-and-retrieving-arraylist-values-from-hashmap (make data entry more efficient)

*/