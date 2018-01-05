/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.classmodeling;

/**
 *
 * @author LA-San
 */
public class HouseDesign {
    //all variables are read/write
    private float area;
    private float width;
    private float height;
    private float length;
    
    public HouseDesign(){
        
    }
    
    public HouseDesign(float area, float width, float height, float length){
        this.area = area;
        this.width = width;
        this.height = height;
        this.length = length;
    }
    
    public float getArea(){
        return area;
    }
    
    public void setArea(float area){
        this.area = area;
    }
    
    public float getWidth(){
        return width;
    }
    
    public void setWidth(float width){
        this.width = width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public void setHeight(float height){
        this.height = height;
    }
    
    public float getLength(){
        return length;
    }
    
    public void setLength(float length){
        this.length = length;
    }
    
    public float calculateArea(float length, float width, float area){
        //square footage of home
        area = length * width;
        
        return area;
    }
}
