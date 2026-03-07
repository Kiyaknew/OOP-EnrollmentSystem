package org.example.model;

public class Instructor extends Person {
    private String course;

    public Instructor(){

    }

    public Instructor(int id, String name){
        super(id, name);
    }

    public Instructor(int id, String name, String course){
       this.course = course;

    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
