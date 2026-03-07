package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers(){
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        calculator.sum(10,15);

        //Assert
        assertEquals(15, calculator.getAnswer());
    }


}