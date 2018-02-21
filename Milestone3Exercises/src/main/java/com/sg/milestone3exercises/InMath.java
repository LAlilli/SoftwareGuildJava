/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.milestone3exercises;

/**
 *
 * @author LA-San
 */
public class InMath {
    
    MathOperator operator;
    
    public InMath(MathOperator operator){
        this.operator = operator;
    }
    
    public int calculate(MathOperator operator, int operand1, int operand2) {        
        switch(operator) {
            case PLUS:
                  return operand1 + operand2;
            case MINUS:
                  return operand1 - operand2;
            case MULTIPLY:
                  return operand1 * operand2;
            case DIVIDE:
                  return operand1 / operand2;
            default:
                  throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args){
        InMath addition = new InMath(MathOperator.PLUS);
        System.out.println(addition.calculate(MathOperator.PLUS, 1, 2));
        
        InMath minus = new InMath(MathOperator.MINUS);
        System.out.println(minus.calculate(MathOperator.MINUS, 2, 1));
        
        InMath multiply = new InMath(MathOperator.MULTIPLY);
        System.out.println(multiply.calculate(MathOperator.MULTIPLY, 1, 2));
        
        InMath divide = new InMath(MathOperator.DIVIDE);
        System.out.println(divide.calculate(MathOperator.DIVIDE, 2, 1));
    }
}
