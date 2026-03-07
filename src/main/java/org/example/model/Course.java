package org.example.model;

public class Course{
    private int courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    public Course( int courseID, String courseName, String program){
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public int getCourseID(){
        return courseID;
    }

    public void setCourseID(int courseID){
        this.courseID = courseID;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourse(){
        return program;
    }

    public void setCourse(String course){
        this.program = program;
    }
}
