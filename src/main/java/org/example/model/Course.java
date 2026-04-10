package org.example.model;

public class Course{
    private String courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    public Course(String courseID){
        this.courseID = courseID;
    }

    public Course( String courseID, String courseName, String program){
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
    }

    public String getCourseID(){
        return courseID;
    }

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID = '" + courseID + '\'' +
                ", courseName = '" + courseName + '\'' +
                ", program = '" + program + '\'' +
                '}';
    }
}
