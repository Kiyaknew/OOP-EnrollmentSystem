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


    public List<Course> getCourseList(){
        return courseList;
    }

    public void setCourseList(List<Course> courseList){
        this.courseList = courseList;
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }

    @Override

    public String toString() {
        String courseDisplay = "";
        for(int i =0; i < courseList.size(); i++){
            courseDisplay += courseList.get(i).getCourseName();
            if(i <courseList.size() - 1){
                courseDisplay += ", ";
            }
        }
        return "Instructor{" +
                "Instructor ID=" + super.getId() +
                ",Name=" + super.getName() +
                ",Age=" + super.getAge() +
                ",Course='" + courseDisplay + '\'' +
                '}';
    }
}