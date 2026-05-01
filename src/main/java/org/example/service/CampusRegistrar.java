package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.Instructor;

public class CampusRegistrar {
    private StudentRegistration studentReg;
    private CourseRegistration courseReg;
    private InstructorRegistration instructorReg;

    public CampusRegistrar(StudentRegistration studentReg, CourseRegistration courseReg, InstructorRegistration instructorReg){
        this.studentReg = studentReg;
        this.courseReg = courseReg;
        this.instructorReg = instructorReg;

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

    public String saveInstructor(Instructor instructor){
        instructorReg.saveInstructor(instructor);
        return "Successfully saved " + instructor + "as an instructor.";
    }

    public String displayAllInstructor(){
        instructorReg.displayAllInstructor();
        return "All records displayed.";
    }

    public String updateInstructor(Instructor instructor){
        instructorReg.updateInstructor(instructor);
        return "Successfully updated " + instructor + "information.";
    }

    public String assignCourse(Instructor instructor){
        instructorReg.addCourseInstructor(instructor);
        return "Successfully added course to instructor.";
    }

    public String removeInstructor(Instructor instructor){
        instructorReg.removeInstructor(instructor);
        return "Successfully removed instructor from the records.";
    }


}
