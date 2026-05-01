package org.example.service;

import org.example.model.Instructor;
import org.example.model.Course;

public interface InstructorRegistration {
    void saveInstructor(Instructor instructor);
    void displayAllInstructor();
    void updateInstructor(Instructor instructor);
    String removeInstructor(Instructor instructor);
    void addCourseInstructor(Instructor instructor);
}
