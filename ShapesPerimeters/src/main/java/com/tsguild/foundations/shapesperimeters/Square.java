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
public class Square extends Shape {
    private int side;
    
    public Square(){
        super();
    }
    
    public static void main(String[] args){
        Square square = new Square();
        System.out.println("Area " + square.getArea(3) + " | Perimeter " + square.getPerimeter(3));
    }
    
    public int getArea(int side){
        super.getArea();
        
        area = side * side;
        
        return area;
    }
    
    public int getPerimeter(int side){
        super.getPerimeter();
        
        perimeter = side * 4;
        
        return perimeter;
    }
}
