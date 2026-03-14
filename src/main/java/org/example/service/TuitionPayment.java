package org.example.service;

public class TuitionPayment {
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;

        public double calculateTuitionFee(int units, double discountRate){
            totalTuition = units * pricePerUnit;
            if(discountRate != 0) {
                totalTuition = totalTuition -(totalTuition * discountRate);
            }
            return totalTuition;
        }

        public void makePayment(double amount){
            balance = totalTuition - amount;
        }

        public double getRemainingBalance(){
            return balance;
        }

        public boolean isFullyPaid(){
            return balance == 0 ? true : false;
        }

}
