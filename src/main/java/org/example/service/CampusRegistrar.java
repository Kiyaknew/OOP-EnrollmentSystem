package org.example.service;

import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistration registration;

    public CampusRegistrar(StudentRegistration registration){
        this.registration = registration;

    }

    public String saveStudent(Student student){
        registration.saveStudent(student);
        return "Success";
    }

    public void displayAllStudent(){
        registration.displayAllStudent();
    }
}
