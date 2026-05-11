package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;


public interface TuitionRegistration {
    void calculateFee(String studentID, int units);
    void makePayment(String studentID, double amount);
    void getRemainingBalance(String studentID);

}
