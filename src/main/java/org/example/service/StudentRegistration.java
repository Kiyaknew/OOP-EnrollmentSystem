package org.example.service;

import org.example.model.Student;

public interface StudentRegistration {
    void saveStudent(Student student);
    void displayAllStudent();
    void updateStudent(Student student);
    String removeStudent(Student student);
}
