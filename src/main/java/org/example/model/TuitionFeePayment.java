package org.example.model;

public class TuitionFeePayment {
    private double pricePerUnit = 1000.00;
    private double balance;
    private double totalTuition;
    private Student student;

    public TuitionFeePayment(){

    }

    public TuitionFeePayment(Student student){
        this(student,  0);
        this.student = student;
    }

    public TuitionFeePayment(Student student, int units){
        this.student = student;
        this.totalTuition = units * pricePerUnit;
        this.balance = this.totalTuition;
    }

    public double getPricePerUnit(){
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit){
        this.pricePerUnit = pricePerUnit;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getTotalTuition(){
        return totalTuition;
    }

    public void setTotalTuition(double totalTuition){
        this.totalTuition = totalTuition;
    }

    public Student getStudent(){
        return  student;
    }

    public void setStudent(Student student){
        this.student= student;
    }

    @Override
    public String toString() {
        return "Tuition Details{ " +
                "Student = '" + student + '\'' +
                ", Total Tuition = '" + totalTuition + '\'' +
                ", Balance = '" + balance + '\'' +
                ", Status = '" + (balance == 0 ? "FULLY PAID" : "UNPAID") + "}";
    }


}
