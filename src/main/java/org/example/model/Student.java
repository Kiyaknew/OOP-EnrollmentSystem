package org.example.model;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    public Student(){

    }

    public Student(int studentID, String studentName, String program){
        this.studentID = studentID;
        this.studentName = studentName;
        this.program = program;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }
}
