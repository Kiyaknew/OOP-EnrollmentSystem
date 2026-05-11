package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String depId;
    private String departmentName;
    private List<Section> sections;

    public Department(){

    }

    public Department(String depId){
        this.depId = depId;
        this.sections = new ArrayList<>();
    }

    public Department(String depId, String departmentName){
        this.depId = depId;
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();

    }

    public String getDepId(){
        return depId;
    }

    public void setDepId(String depId){
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

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID='" + depId + '\'' +
                ", Name='" + departmentName + '\'' +
                ", Sections=" + sections.size() +
                '}';
    }

}
