package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String depId;
    private String departmentName;
    private List<Section> sections;

    public Department(){

    }

    public Department(String depId, String departmentName){
        this.depId = depId;
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();

    }

    public String getdepId(){
        return depId;
    }

    public void setdepId(String depId){
        this.depId = depId;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public List<Section> getSections(){
        return sections;
    }

}
