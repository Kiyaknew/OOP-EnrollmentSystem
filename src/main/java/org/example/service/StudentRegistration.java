package org.example.service;

import org.example.model.Student;

public interface StudentRegistration {
    void saveStudent(Student student);
    void displayAllStudent();
    void updateStudent(Student student);
    void removeStudent(Student student);
    Student findStudentByID(String studentID);
    void applyScholarship(String studentID, double discountRate);
    void removeScholarship(String studentID);
    void searchByName(String name);
}
