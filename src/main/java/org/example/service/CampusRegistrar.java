package org.example.service;

import org.example.model.*;

public class CampusRegistrar {
    private StudentRegistration studentReg;
    private CourseRegistration courseReg;
    private InstructorRegistration instructorReg;
    private SectionRegistration sectionReg;
    private DepartmentRegistration departmentReg;
    private EnrollmentRegistration enrollmentReg;
    private TuitionRegistration tuitionReg;

    public CampusRegistrar(StudentRegistration studentReg, CourseRegistration courseReg, InstructorRegistration instructorReg, SectionRegistration sectionReg,
                           DepartmentRegistration departmentReg, EnrollmentRegistration enrollmentReg, TuitionRegistration tuitionReg ){
        this.studentReg = studentReg;
        this.courseReg = courseReg;
        this.instructorReg = instructorReg;
        this.sectionReg = sectionReg;
        this.departmentReg = departmentReg;
        this.enrollmentReg = enrollmentReg;
        this.tuitionReg = tuitionReg;

    }

//THIS IS FOR ALL STUDENT ACTIONS!!!!!!!!!!!!!11111
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

 //THIS IS FOR COURSE!!!!!!!!11
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

//FOR INSTRUCTOR!!!!!!!!!!!!!!!!!!!!!!!1
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
