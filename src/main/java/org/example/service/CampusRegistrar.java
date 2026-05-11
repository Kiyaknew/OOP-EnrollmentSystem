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
        return "Redirecting. . .";
    }

    public String displayAllStudent(){
        studentReg.displayAllStudent();
        return "Redirecting . . .";
    }

    public String updateStudent(Student student){
        studentReg.updateStudent(student);
        return "Redirecting . . .";
    }

    public String removeStudent(Student student){
        studentReg.removeStudent(student);
        return "Redirecting . . .";
    }

 //THIS IS FOR COURSE!!!!!!!!11
    public String saveCourse(Course course){
        courseReg.saveCourse(course);
        return "Redirecting . . .";
    }

    public String displayAllCourse(){
        courseReg.displayAllCourse();
        return "All records displayed.";
    }

    public String updateCourse(Course course){
        courseReg.updateCourse(course);
        return "Redirecting . . .";
    }

    public String removeCourse(Course course){
        courseReg.removeCourse(course);
        return "Redirecting . . .";
    }

//FOR INSTRUCTOR!!!!!!!!!!!!!!!!!!!!!!!1
    public String saveInstructor(Instructor instructor){
        instructorReg.saveInstructor(instructor);
        return "Redirecting . . .";
    }

    public String displayAllInstructor(){
        instructorReg.displayAllInstructor();
        return "Redirecting . . .";
    }

    public String updateInstructor(Instructor instructor){
        instructorReg.updateInstructor(instructor);
        return "Redirecting . . .";
    }

    public String removeInstructor(Instructor instructor){
         instructorReg.removeInstructor(instructor);
         return "Redirecting";
    }

    public String assignCourseToInstructor(String instructorID, String courseID){
        instructorReg.addCourseInstructor(instructorID, courseID, courseReg);
        return "Redirecting . . .";
    }

    public String assignInstructorToSection(String instructorID, String sectionID){
        instructorReg.assignInstructorToSection(instructorID, sectionID, sectionReg);
        return "Redirecting . . .";
    }

 //SECTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!111

    public String saveSection(Section section){
        sectionReg.saveSection(section);
        return "Redirecting . . .";
    }

    public String displayAllSection(){
        sectionReg.displayAllSections();
        return "Redirecting . . .";
    }

    public String updateSection(Section section){
        sectionReg.updateSection(section);
        return "Redirecting . . .";
    }

    public String removeSection(String sectionID){
        return sectionReg.removeSection(sectionID);
    }

//DEPARTMENT !!!!

    public String saveDepartment(Department department){
        departmentReg.saveDepartment(department);
        return "Redirecting . . .";
    }

    public String displayAllDepartment(){
        departmentReg.displayAllDepartment();
        return "Redirecting . . .";
    }

    public String updateDepartment(Department department){
        departmentReg.updateDepartment(department);
        return "Redirecting . . .";
    }

    public String removeDepartment(String departmentID){
        departmentReg.removeDepartment(departmentID);
        return "Redirecting . . .";
    }

    public String addSectiontoDepartment(String departmentID, String sectionID){
        Section section = sectionReg.findSectionByID(sectionID);
        if (section == null){
            return "Section not found.";
        }
        departmentReg.addSectiontoDepartment(departmentID, section);
        return "Succesfully added section from department.";
    }

    public String removeSectionFromDepartment(String departmentID, String sectionID){
        departmentReg.removeSectionFromDepartment(departmentID,sectionID);
        return "Successfully removed section from department.";
    }

//FOR ENROLLMENT

    public String enrollStudent(String studentID, String sectionID){
        enrollmentReg.enrollStudentInSection(studentID, sectionID);
        return "Enrolled student in the section";
    }

    public String viewDepartmentHierarchy(String departmentID){
        enrollmentReg.viewDepartmentHierarchy(departmentID);
        return "";
    }

//LAST IS TUITION METHODS!!!!!!!!!!!!!!!!!!!!!

    public String calculateTuition(String studentID, int units){
        tuitionReg.calculateFee(studentID, units);
        return "";
    }

    public String makePayment(String studentID, double amount){
        tuitionReg.makePayment(studentID, amount);
        return "";
    }

    public String viewBalance(String studentID){
        tuitionReg.getRemainingBalance(studentID);
        return "";
    }
    //add other methods here just incase
}
