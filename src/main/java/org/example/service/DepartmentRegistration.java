package org.example.service;

import org.example.model.Department;
import org.example.model.Section;

public interface DepartmentRegistration {
    void saveDepartment(Department department);
    void displayAllDepartment();
    void updateDepartment(Department department);
    void removeDepartment(String departmentID);
    void addSectiontoDepartment(String departmentID, Section section);
    void removeSectionFromDepartment(String departmentID, String sectionID);
    Department findDepartmentByID(String departmentID);

}
