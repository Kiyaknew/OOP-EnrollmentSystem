package org.example.service;

import java.math.BigDecimal;

public class Calculator {
    private int answer;
    //add
    //substract
    //division
    //multiplication

    public void sum(int a, int b){
        answer = a + b;
    }

    public void subtract(int a, int b){
        answer = a - b;
    }

    public void division(double a, double b){
        answer = a / b;
    }

    public void multiplication(int a, int b){
        answer = a * b;
    }

    public int getAnswer(){
        return answer;
    }
}
