package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionID;
    private String sectionName;
    private int maxCapacity;
    private String program;
    private Instructor assignedInstructor;
    private List<Student> enrolledList; //dunno if this is correct, complete other entities first :/

    public Section(){

    }

    public Section(String sectionID){
        this.sectionID = sectionID;
    }

    public Section(String sectionID, String sectionName, int maxCapacity, String program){
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.program = program;
        this.enrolledList = new ArrayList<>();
    }

    public String getSectionID(){
        return sectionID;
    }

    public void setSectionID(String sectionID){
        this.sectionID = sectionID;
    }

    public String getSectionName(){
        return sectionName;
    }

    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    public Instructor getAssignedInstructor(){
        return assignedInstructor;
    }

    public void setAssignedInstructor(Instructor assignedInstructor){
        this.assignedInstructor = assignedInstructor;
    }

    public List<Student> getEnrolledList(){
        return enrolledList;
    }

    public void setEnrolledList(List<Student> enrolledList){
        this.enrolledList = enrolledList;
    }
    @Override
    public String toString() {
        return "Section{" +
                "ID='" + sectionID + '\'' +
                ", Name='" + sectionName + '\'' +
                ", Program='" + program + '\'' +
                ", Capacity=" + enrolledList.size() + "/" + maxCapacity +
                ", Instructor=" + (assignedInstructor != null ? assignedInstructor.getName() : "TBA") +
                '}';
    }

}

