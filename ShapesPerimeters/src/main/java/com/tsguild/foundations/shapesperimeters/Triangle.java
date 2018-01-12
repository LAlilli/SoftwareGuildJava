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
public class Triangle extends Shape{
    private int height;
    private int base;
    private int side1;
    private int side2;
    
    public Triangle(){
        super();
    }
    
    public static void main(String[] args){
        Triangle triangle = new Triangle();
        System.out.println("Area " + triangle.getArea(2,3) + " | Perimeter " + triangle.getPerimeter(2,3,2));
    }
    
    public int getArea(int height, int base){
        super.getArea();
        
        area = ((height * base)/2);
        
        return area;
    }
    
    public int getPerimeter(int base, int side1, int side2){
        super.getPerimeter();
        
        perimeter = base + side1 + side2;
        
        return perimeter;
    }
}
