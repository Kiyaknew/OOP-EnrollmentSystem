package org.example.service;

import org.example.model.Instructor;
import org.example.model.Course;

public interface InstructorRegistration {
    void saveInstructor(Instructor instructor);
    void displayAllInstructor();
    void updateInstructor(Instructor instructor);
    void removeInstructor(Instructor instructor);
    void addCourseInstructor(String instructorID, String courseID, CourseRegistration courseReg);
    void assignInstructorToSection(String instructorID, String sectionID, SectionRegistration sectionReg);
    void removeInstructorFromSection(String sectionID, SectionRegistration sectionReg);
    void removeCourseFromInstructor(String instructorID, String courseID);
}
