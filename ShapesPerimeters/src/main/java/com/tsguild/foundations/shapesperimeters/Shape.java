/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.shapesperimeters;

/**
 *
 * @author LA-San
 */
public abstract class Shape {
    protected int area;
    protected int perimeter;
    protected String color;
    
    public Shape(){
        
    }
    
    public int getArea(){
        return area;
    }
    
    public int getPerimeter(){
        return perimeter;
    }
    
    public String getColor(){
        return color;
    }
}
