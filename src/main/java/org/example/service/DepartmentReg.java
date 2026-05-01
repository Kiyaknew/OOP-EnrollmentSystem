package org.example.service;

import org.example.model.Department;

public interface DepartmentReg {
    void saveDepartment(Department department);
    void displayAllDepartment();
    void updateDepartment(Department department);
    String removeDepartment(Department department);

}
