/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.statecapitals2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;
/**
 *
 * @author LA-San
 */
public class Capital {
    
    private String name;
    private int population;
    private int squareMileage;
    private Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args){
       Capital capital = new Capital();
       HashMap <String, Capital> stateCapitals = new HashMap<>();
       Map<String, Capital> map = new TreeMap<>(stateCapitals); //to sort hashmap alphabetically
       Set keys = map.entrySet(); // iterates over key-value set instead of iterating over key and then grabbbing value
       Iterator iterator = keys.iterator(); //iterator for treemap
       int populationMin;
       
       //add data to hashmap
       stateCapitals.put("Alabama", new Capital("Montgomery,", 205764, 155));
       stateCapitals.put("Alaska", new Capital("Juneau", 31275, 2716));
       stateCapitals.put("Arizona", new Capital("Phoenix", 1445632, 475));
       stateCapitals.put("Arkansas", new Capital("Little Rock", 193524, 116));
       stateCapitals.put("California", new Capital("Sacramento", 466488, 97));
       stateCapitals.put("Colorado", new Capital("Denver", 600158, 153));
       stateCapitals.put("Connecticut", new Capital("Hartford", 124775, 17));
       stateCapitals.put("Delaware", new Capital("Dover", 36047, 22));
       stateCapitals.put("Flordia", new Capital("Tallahassee", 181412, 96));
       stateCapitals.put("Georgia", new Capital("Atlanta", 420003, 132));
       stateCapitals.put("Hawaii", new Capital("Honolulu", 337256, 86));
       stateCapitals.put("Idaho", new Capital("Boise", 205671, 64));
       stateCapitals.put("Illinois", new Capital("Springfield", 116250, 54));
       stateCapitals.put("Indiana", new Capital("Indianapolis", 829718, 362));
       stateCapitals.put("Iowa", new Capital("Des Moines", 203433, 76));
       stateCapitals.put("Kansas", new Capital("Topeka", 127473, 56));
       stateCapitals.put("Kentucky", new Capital("Frankfort", 25527, 15));
       stateCapitals.put("Louisiana", new Capital("Baton Rouge", 229553, 77));
       stateCapitals.put("Maine", new Capital("Augusta", 19136, 55));
       stateCapitals.put("Maryland", new Capital("Annapolis", 38394, 7));
       stateCapitals.put("Massachusetts", new Capital("Boston", 617594, 48));
       stateCapitals.put("Michigan", new Capital("Lansing", 114297, 35));
       stateCapitals.put("Minnesota", new Capital("St. Paul", 300851, 52));
       stateCapitals.put("Mississippi", new Capital("Jackson", 173514, 105));
       stateCapitals.put("Missouri", new Capital("Jefferson City", 43079, 27));
       stateCapitals.put("Montana", new Capital("Helena", 28190, 14));
       stateCapitals.put("Nebraska", new Capital("Lincoln", 258379, 75));
       stateCapitals.put("Nevada", new Capital("Carson City", 55274, 143));
       stateCapitals.put("New Hampshire", new Capital("Concord", 42695, 64));
       stateCapitals.put("New Jersey", new Capital("Trenton", 84913, 8));
       stateCapitals.put("New Mexico", new Capital("Santa Fe", 75764, 37));
       stateCapitals.put("New York", new Capital("Albany", 97856, 21));
       stateCapitals.put("North Carolina", new Capital("Raleigh", 403892, 115));
       stateCapitals.put("North Dakota", new Capital("Bismarck", 61272, 27));
       stateCapitals.put("Ohio", new Capital("Columbus", 822553, 210));
       stateCapitals.put("Oklahoma", new Capital("Oklahoma City", 580000, 607));
       stateCapitals.put("Oregon", new Capital("Salem", 154637, 46));
       stateCapitals.put("Pennsylvania", new Capital("Harrisburg", 49528, 8));
       stateCapitals.put("Rhode Island", new Capital("Providence", 178042, 19));
       stateCapitals.put("South Carolina", new Capital("Columbia", 131686, 125));
       stateCapitals.put("South Dakota", new Capital("Pierre", 13646, 13));
       stateCapitals.put("Tennessee", new Capital("Nashville", 635710, 473));
       stateCapitals.put("Texas", new Capital("Austin", 790390, 252));
       stateCapitals.put("Utah", new Capital("Salt Lake City", 186440, 109));
       stateCapitals.put("Vermont", new Capital("Montpelier", 7855, 10));
       stateCapitals.put("Virginia", new Capital("Richmond", 204214, 60));
       stateCapitals.put("Washington", new Capital("Olympia", 46478, 17));
       stateCapitals.put("West Virginia", new Capital("Charleston", 51400, 32));
       stateCapitals.put("Wisconsin", new Capital("Madison", 233209, 69));
       stateCapitals.put("Wyoming", new Capital("Cheyenne", 59466, 21));
       
       System.out.println("STATE | CAPITAL PAIRS");
       System.out.println("====================");
       
       System.out.println();
       while(iterator.hasNext()) {
           //create instance of map.entry class
            Map.Entry stateCapital = (Map.Entry)iterator.next();
            System.out.print(stateCapital.getKey() + " - ");
            System.out.println(map.get(stateCapital.getKey()).getName() + " | Pop: " + map.get(stateCapital.getKey()).getPopulation() + " | Area: " + map.get(stateCapital.getKey()).getSquareMileage() + " sq mi");
        }
       
       //get user input
       System.out.println();
       populationMin = capital.readInt("Please enter a minimum limit for population: ");
       
       System.out.println();
       System.out.println("CAPITALS WITH POPULATIONS GREATER THAN " + populationMin);
       //compare userinput to map
       for(String key: map.keySet()){
           if(populationMin < map.get(key).getPopulation()){
               System.out.println(key + " - " + map.get(key).getName() + " | Pop: " + map.get(key).getPopulation() + " | Area: " + map.get(key).getSquareMileage() + " sq mi");
           }
       }
    }
    
    //default constructor
    public Capital() {
    }
    
    //constructor with properties
    public Capital(String name, int population, int squareMileage){
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }
    
    public int readInt(String prompt){
        System.out.println(prompt);
        String input = userInput.nextLine();
        
        int numInput = Integer.parseInt(input);
        
        return numInput;
    }
    
    //getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(int squareMileage) {
        this.squareMileage = squareMileage;
    }
}