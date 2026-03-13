package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TuitionPaymentTest {
        private TuitionPayment pay;

        @BeforeEach
        void set() {
            pay = new TuitionPayment();
        }
        @Test
        void testCalculateFee() {
            double result = pay.calculateTuitionFee(10, 0.2);
            System.out.println(result);
            assertEquals(8000, result);
        }

}