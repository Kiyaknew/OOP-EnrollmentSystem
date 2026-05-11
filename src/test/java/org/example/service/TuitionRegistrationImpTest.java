package org.example.service;

import org.example.model.*;
import org.example.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TuitionRegistrationImpTest {
    private TuitionRegistrationImp tuitionService;
    private StudentRegistration studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentRegistrationImp();
        tuitionService = new TuitionRegistrationImp(studentService);
    }

    @Test
    void testCalculateFees_Success() {
        Student student = new Student("1", "Alex", 20, "BSIT");
        studentService.saveStudent(student);

        tuitionService.calculateFee("1", 18);

        assertNotNull(tuitionService.getPaymentByStudentID("1"));
    }

    @Test
    void testCalculateFees_StudentNotFound() {
        tuitionService.calculateFee("2", 18);
        assertNull(tuitionService.getPaymentByStudentID("2"));
    }

    @Test
    void testCalculateFees_AlreadyCalculated() {
        Student student = new Student("3", "Erik", 20, "BSIT");
        studentService.saveStudent(student);

        tuitionService.calculateFee("3", 18);
        tuitionService.calculateFee("3", 18);
    }

    @Test
    void testMakePayment_Success() {
        Student student = new Student("1", "Dumbledore", 20, "BSIT");
        studentService.saveStudent(student);
        tuitionService.calculateFee("1", 10);

        tuitionService.makePayment("1", 500.0);

        TuitionFeePayment payment = tuitionService.getPaymentByStudentID("1");
        assertNotNull(payment);
    }

    @Test
    void testMakePayment_ValidationBranches() {
        Student student = new Student("2", "Harry pottah", 20, "BSIT");
        studentService.saveStudent(student);
        tuitionService.calculateFee("2", 1);

        tuitionService.makePayment("2", -1.0);

        tuitionService.makePayment("2", 999999.0);

        tuitionService.makePayment("99", 100.0);
    }

    @Test
    void testGetRemainingBalance_Flows() {
        Student student = new Student("3", "Cairo", 20, "BSIT");
        studentService.saveStudent(student);
        tuitionService.calculateFee("3", 15);

        tuitionService.getRemainingBalance("3");
        tuitionService.getRemainingBalance("100");
    }
}