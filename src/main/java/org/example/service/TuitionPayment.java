package org.example.service;

public class TuitionPayment {
    private double pricePerUnit = 1000;
    private double balance;
    private double totalTuition;

        public double calculateTuitionFee(int units, double discountRate){
            totalTuition = units * pricePerUnit;
            double tuitionDiscount = totalTuition * discountRate;
            balance = totalTuition - tuitionDiscount;
            return balance;
        }

        public void makePayment(double amount){
            balance =- amount;
        }

        public double getRemainingBalance(){
            return balance;
        }

        public boolean isFullyPaid(){
            return balance <= 0;
        }

}
