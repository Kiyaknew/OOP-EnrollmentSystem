package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }
    @Test
    void shouldAddTwoNumbers(){
        //Act
        calculator.sum(10,5);

        //Assert
        assertEquals(15, calculator.getAnswer());
    }
    @Test
    void shouldSubstractTwoNumbers(){
        calculator.subtract(10, 15);

        assertEquals(5, calculator.getAnswer());
    }

    @Test
    void shouldDivideTwoNumbers(){

        calculator.division(10, 5);

        assertEquals(2, calculator.getAnswer(), delta );

    }


}