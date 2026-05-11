package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;

public interface EnrollmentRegistration {
    void enrollStudentInSection(String studentID, String sectionID);
    void viewDepartmentHierarchy(String departmentID);

}
