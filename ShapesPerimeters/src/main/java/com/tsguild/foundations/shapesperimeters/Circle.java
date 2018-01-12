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
public class Circle extends Shape{
    private double radius;
    public final double pi = 3.14;
    
    public Circle(){
        super();
    }
    
    public static void main(String[] args){
        Circle circle = new Circle();
        System.out.println("Area " + circle.getArea(2) + " | Perimeter " + circle.getPerimeter(2));
    }
    
    public double getArea(double radius){
        super.getArea();
        
        double area = pi * (radius * radius);
        
        return area;
    }
    
    public double getPerimeter(double radius){
        super.getPerimeter();
        
        double perimeter = 2 * (pi * radius);
        
        return perimeter;
    }
}
