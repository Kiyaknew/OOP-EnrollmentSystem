package org.example;

public class Course {
    private int courseID;
    private String courseName;
    private String course;

    public Course(){

    }

    public Course( int courseID, String courseName, String course){
        this.courseID = courseID;
        this.courseName = courseName;
        this.course = course;
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
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
