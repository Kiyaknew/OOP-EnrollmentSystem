package org.example.model;

public class Course{
    private String courseID;
    private String courseName;
    private String program;
    private int courseUnits;

    public Course(){

    }

    public Course(String courseID){
        this.courseID = courseID;
    }

    public Course( String courseID, String courseName, String program, int courseUnits){
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
        this.courseUnits = courseUnits;
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

    public int getCourseUnits(){
        return courseUnits;
    }

    public void setCourseUnits(int courseUnits){
        this.courseUnits = courseUnits;
    }


    @Override
    public String toString() {
        return "Course{ " +
                "Course ID = '" + courseID + '\'' +
                ", Course Name = '" + courseName + '\'' +
                ", Program = '" + program + '\'' +
                ", Units = '" + courseUnits + '\'' +
                '}';
    }
}
