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
public class Rectangle extends Shape{
    private int width;
    private int length;
    
    public Rectangle(){
        super();
    }
    
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle();
        System.out.println("Area " + rectangle.getArea(2,3) + " | Perimeter " + rectangle.getPerimeter(2,3));
    }
    
    public int getArea(int width, int length){
        super.getArea();
        
        area = length * width;
        
        return area;
    }
    
    public int getPerimeter(int width, int length){
        super.getPerimeter();
        
        perimeter = (2 * length) + (2 * width);
        
        return perimeter;
    }
}
