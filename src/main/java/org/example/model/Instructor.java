package org.example.model;

import java.util.ArrayList;
import java.util.List;
public class Instructor extends Person{
    private List<Course> courseList;

    public Instructor(){
        super();
        this.courseList = new ArrayList<>();
    }

    public Instructor(String instructorID){
        super(instructorID);
        this.courseList = new ArrayList<>();
    }

    public Instructor(String instructorID, String instructorName){
        super(instructorID, instructorName);
        this.courseList = new ArrayList<>();
    }

    public Instructor(String instructorID, String instructorName, int instructorAge){
        super(instructorID, instructorName,instructorAge);
        this.courseList = new ArrayList<>();;
    }

    public Instructor(String instructorID, String instructorName, int instructorAge, List<Course> courseList){
        super(instructorID, instructorName, instructorAge);
        this.courseList = courseList != null ? courseList: new ArrayList<>();
    }

    public List<Course> getCourse(){
        return courseList;
    }

    public void setCourse(List<Course> courseList){
        this.courseList = courseList;
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }

    @Override
    public String toString() {
        String courseDisplay = courseList.isEmpty() ? "No assigned courses" : courseList.toString();
        return "Instructor{" +
                "instructorID=" + super.getId() +
                ", instructorName=" + super.getName() +
                ", instructorAge=" + super.getAge() +
                ", course='" + courseDisplay + '\'' +
                '}';
    }
}