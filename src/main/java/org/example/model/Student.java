package org.example.model;

public class Student extends Person{
    private String program;

    public Student(){
        super();
    }

    public Student(String studentID){
        super(studentID);
    }

    public Student(String studentID, String studentName){
        super(studentID, studentName);
    }

    public Student(String studentID, String studentName, int studentAge){
        super(studentID, studentName, studentAge);
    }

    public Student(String studentID, String studentName, int studentAge, String program){
        super(studentID, studentName, studentAge);
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public void mainTask() {
        System.out.println("I study.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + super.getId() + '\'' +
                ", studentName='" + super.getName() + '\'' +
                ", studentAge= '" + super.getAge() + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}