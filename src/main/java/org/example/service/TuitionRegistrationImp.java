package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;
import java.util.ArrayList;
import java.util.List;

public class TuitionRegistrationImp implements TuitionRegistration{
    private List<TuitionFeePayment> payments = new ArrayList<>();
    private StudentRegistration studentReg;

    public TuitionRegistrationImp(StudentRegistration studentReg){
        this.studentReg = studentReg;
    }

    private TuitionFeePayment findPaymentByStudentID(String studentID) {
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getStudent().getId().equals(studentID)){
                return payments.get(i);
            }
        }
        return null;
    }

    public TuitionFeePayment getPaymentByStudentID(String studentID){
        return findPaymentByStudentID(studentID);
    }

    public void calculateFee(String studentID, int units){
        Student student = studentReg.findStudentByID(studentID);
        if (student == null){
            System.out.println("Student not found.");
            return;
        }
        if (findPaymentByStudentID(studentID) != null) {
            System.out.println("Tuition has already been calculated for this specific student!");
            return;
        }
        TuitionFeePayment payment = new TuitionFeePayment(student, units);
        if (student.isScholar()) {
            double discount = payment.getTotalTuition() * (student.getDiscountRate() / 100);
            double discountedTotal = payment.getTotalTuition() - discount;
            payment.setTotalTuition(discountedTotal);
            payment.setBalance(discountedTotal);
            System.out.println("Scholarship discount of " + student.getDiscountRate() +
                    "% applied! Saving PHP " + discount);
        }
        payments.add(payment);
        System.out.println("Tuition calculated for " + student.getName() + " || Total: PHP " + payment.getTotalTuition() );
    }

    public void makePayment(String studentID, double amount){
        TuitionFeePayment payment = findPaymentByStudentID(studentID);
        if (payment == null){
            System.out.println("No record found. Please calculate tuition fee.");
            return;
        }
        if (payment.getBalance() == 0){
            System.out.println("Student fully paid");
            return;
        }
        if (amount <= 0){
            System.out.println("Invalid payment amount.");
            return;
        }
        if (amount > payment.getBalance()){
            System.out.println("Payment exceeds remaining balance of PHP " + payment.getBalance());
            return;
        }
        payment.setBalance((payment.getBalance() - amount));
        System.out.println("Payment of PHP" + amount + " received.");
        System.out.println("Remaining Balance: PHP " + payment.getBalance());
        System.out.println("Status: " + (payment.getBalance() == 0 ? "FULLY PAID" : "UNPAID"));
    }

    public void getRemainingBalance(String studentID){
        TuitionFeePayment payment = findPaymentByStudentID(studentID);
        if (payment == null){
            System.out.println("No record found. Please calculate tuition fee.");
            return;
        }
        System.out.println(payment);
    }
}
