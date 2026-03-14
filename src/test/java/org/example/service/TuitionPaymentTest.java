package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TuitionPaymentTest {
        private TuitionPayment tuitionPayment;

        @BeforeEach
        void set() {
            tuitionPayment = new TuitionPayment();
        }
        @Test
        void testCalculateFee() {
            double result = tuitionPayment.calculateTuitionFee(10, 0.2);
            System.out.println(result);
            assertEquals(8000, result);
        }
        @Test
        void makeaPayment(){
            tuitionPayment.calculateTuitionFee(10, 0.2);
            tuitionPayment.makePayment(1000);

            assertEquals(7000, tuitionPayment.getRemainingBalance());

        }

        @Test

}