package org.example.model;

public class Student extends Person {
    private String program;

    public Student(int id, String name, int age){
        super(id, name, age);
    }

    public Student(int id, String name, int age,  String program){
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public void mainTask(){
        System.out.println("Study");
    }
}
