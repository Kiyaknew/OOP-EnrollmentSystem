package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private StudentRegistration studentReg;
    private CourseRegistration courseReg;

    public CampusRegistrar(StudentRegistration studentReg, CourseRegistration courseReg){
        this.studentReg = studentReg;
        this.courseReg = courseReg;

    }

    public String saveStudent(Student student){
        studentReg.saveStudent(student);
        return "Successfully registered " + student;
    }

    public String displayAllStudent(){
        studentReg.displayAllStudent();
        return "All records displayed.";
    }

    public String updateStudent(Student student){
        studentReg.updateStudent(student);
        return "Successfully updated " + student + "'s information.";
    }

    public String removeStudent(Student student){
        studentReg.removeStudent(student);
        return "Successfully removed " + student;
    }

    public String saveCourse(Course course){
        courseReg.saveCourse(course);
        return "Successfully saved " + course;
    }

    public String displayAllCourse(){
        courseReg.displayAllCourse();
        return "All records displayed.";
    }

    public String updateCourse(Course course){
        courseReg.updateCourse(course);
        return "Successfully updated " + course + "information.";
    }

    public String removeCourse(Course course){
        courseReg.removeCourse(course);
        return "Successfully removed " + course;
    }
}
