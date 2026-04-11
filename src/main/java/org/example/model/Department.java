package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;
    private String departmentName;
    private List<Instructor> instructorList;

    public Department(){

    }

    public Department(String id, String departmentName, List<Instructor> instructorList){
        this.id = id;
        this.departmentName = departmentName;
        this.instructorList = instructorList;

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

}
