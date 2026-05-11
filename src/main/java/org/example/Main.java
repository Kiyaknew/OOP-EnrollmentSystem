package org.example;

import org.example.model.*;
import org.example.service.*;

import java.util.Scanner;

//gonna try doing the main with static methods for better redirecting of menus cuz its alot
public class Main {
    static Scanner input = new Scanner(System.in);

    //all implementations
    static StudentRegistrationImp studentReg = new StudentRegistrationImp();
    static CourseRegistrationImpl courseReg = new CourseRegistrationImpl();
    static InstructorRegistrationImp instructorReg = new InstructorRegistrationImp();
    static SectionRegistrationImp sectionReg = new SectionRegistrationImp();
    static DepartmentRegistrationImp depReg = new DepartmentRegistrationImp();
    static EnrollmentRegistrationImp enrollReg = new EnrollmentRegistrationImp(studentReg, sectionReg, depReg);
    static TuitionRegistrationImp tuitionReg = new TuitionRegistrationImp(studentReg);

    //campus reg
    static CampusRegistrar registrar = new CampusRegistrar(studentReg, courseReg,
            instructorReg, sectionReg, depReg, enrollReg, tuitionReg);


    public static void main(String[] args) {
        boolean runSystem = true;
        while (runSystem) {
            System.out.println("|-------------- Welcome to E.X.E Campus System -------------|");
            System.out.println("= 1 = Student Management");
            System.out.println("= 2 = Course Management");
            System.out.println("= 3 = Instructor Management");
            System.out.println("= 4 = Section Management");
            System.out.println("= 5 = Department Management");
            System.out.println("= 6 = Enroll Student");
            System.out.println("= 7 = Calculate Student Tuition");
            System.out.println("= 0 = Exit the System");
            System.out.println("|-------------- ------------------------------ -------------|");
            System.out.println(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1":
                    studentMenu();
                    break;
                case "2":
                    courseMenu();
                    break;
                case "3":
                    instructorMenu();
                    break;
                case "4":
                    sectionMenu();
                    break;
                case "5":
                    departmentMenu();
                    break;
                case "6":
                    enrollmentMenu();
                    break;
                case "7":
                    tuitionMenu();
                    break;
                case "0":
                    runSystem = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("Thank you for using E.X.E Campus System.");
    }
    //student menu

    static void studentMenu(){
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- STUDENT MANAGEMENT -------------|");
            System.out.println("= 1 = Add Student");
            System.out.println("= 2 = View All Students");
            System.out.println("= 3 = Update Student Information");
            System.out.println("= 4 = Remove Student");
            System.out.println("= 0 = Back");
            System.out.println("|-------------- -------------------- -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()){
                case "1": {
                    try{
                        System.out.print("Student ID: ");
                        String id = input.nextLine();
                        System.out.print("Name: ");
                        String name = input.nextLine();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(input.nextLine());
                        System.out.print("Program: ");
                        String program = input.nextLine();
                        System.out.println(registrar.saveStudent(new Student(id, name, age, program)));
                    } catch (NumberFormatException e){
                        System.out.println("Invalid input! Age should be a number");
                    }
                    break;
                }
                case "2":
                    if (studentReg.getStudentList().isEmpty()) {
                        System.out.println("No existing students.");
                        break;
                    }
                    registrar.displayAllStudent();
                    break;
                case "3": {
                    if (studentReg.getStudentList().isEmpty()) {
                        System.out.println("Student list empty. Cannot update.");
                        break;
                    }
                    registrar.displayAllStudent();
                    System.out.print("Input student ID to update: ");
                    String id = input.nextLine();
                    registrar.updateStudent(new Student(id));
                    break;
                }
                case "4": {
                    if (studentReg.getStudentList().isEmpty()) {
                        System.out.println("Student list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllStudent();
                    System.out.print("Input student ID to remove: ");
                    String id = input.nextLine();
                    registrar.removeStudent(new Student(id));
                    break;
                }
                case "0":
                    back = true;
                    break;
                default: System.out.println("Invalid choice!");
                break;
            }
        }
    }
    static void courseMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- COURSE MANAGEMENT -------------|");
            System.out.println("= 1 = Add Course");
            System.out.println("= 2 = View All Course");
            System.out.println("= 3 = Update Course Information");
            System.out.println("= 4 = Remove Course");
            System.out.println("= 0 = Back");
            System.out.println("|--------------- ------------------ -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1": {
                    try {
                        System.out.print("Course ID: ");
                        String id = input.nextLine();
                        System.out.print("Course Name: ");
                        String name = input.nextLine();
                        System.out.print("Program: ");
                        String program = input.nextLine();
                        System.out.print("Units: ");
                        int units = Integer.parseInt(input.nextLine());
                        System.out.println(registrar.saveCourse(new Course(id, name, program, units)));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Units should be a number");
                    }
                    break;
                }
                case "2":
                    if (courseReg.getCourseList().isEmpty()) {
                        System.out.println("No existing courses.");
                        break;
                    }
                    registrar.displayAllCourse();
                    break;
                case "3": {
                    if (courseReg.getCourseList().isEmpty()) {
                        System.out.println("Course list empty. Cannot update.");
                        break;
                    }
                    registrar.displayAllCourse();
                    System.out.print("Input Course ID to update: ");
                    String id = input.nextLine();
                    registrar.updateCourse(new Course(id));
                    break;
                }
                case "4": {
                    if (courseReg.getCourseList().isEmpty()) {
                        System.out.println("Course list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllCourse();
                    System.out.print("Input Course ID to remove: ");
                    String id = input.nextLine();
                    registrar.removeCourse(new Course(id));
                    break;
                }
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
    static void instructorMenu(){
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- INSTRUCTOR MANAGEMENT -------------|");
            System.out.println("= 1 = Add Instructor");
            System.out.println("= 2 = View All Instructor");
            System.out.println("= 3 = Update Instructor Information");
            System.out.println("= 4 = Remove Instructor");
            System.out.println("= 5 = Assign Course to Instructor");
            System.out.println("= 6 = Assign Instructor to Section");
            System.out.println("= 7 = Remove Course from Instructor");
            System.out.println("= 0 = Back");
            System.out.println("|--------------- ------------------ -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1": {
                    try {
                        System.out.print("Instructor ID: ");
                        String id = input.nextLine();
                        System.out.print("Instructor Name: ");
                        String name = input.nextLine();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(input.nextLine());
                        System.out.println(registrar.saveInstructor(new Instructor(id, name, age)));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Age should be a number");
                    }
                    break;
                }
                case "2":
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("No existing instructors.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.println("\nTo see assigned sections of instructors, kindly navigate to the Sections Management.");
                    break;
                case "3": {
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("Instructor list empty. Cannot update.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.print("Input Instructor ID to update: ");
                    String id = input.nextLine();
                    registrar.updateInstructor(new Instructor(id));
                    break;
                }
                case "4": {
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("Instructor list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.print("Input Instructor ID to remove: ");
                    String id = input.nextLine();
                    registrar.removeInstructor(new Instructor(id));
                    break;
                }
                case "5":
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("Instructor list empty. Please add an instructor first.");
                        break;
                    }
                    if (courseReg.getCourseList().isEmpty()) {
                        System.out.println("Course list empty. Please add a course first.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.print("Select Instructor ID: ");
                    String assignInstructorCourse = input.nextLine();
                    registrar.displayAllCourse();
                    System.out.print("Select Course ID: ");
                    String cID = input.nextLine();
                    System.out.println(registrar.assignCourseToInstructor(assignInstructorCourse, cID));
                    break;
                case "6":
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("Instructor list empty. Please add an instructor first.");
                        break;
                    }
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty. Please add a section first.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.print("Select Instructor ID: ");
                    String assignInstructorSection = input.nextLine();
                    registrar.displayAllSection();
                    System.out.print("Select Section ID: ");
                    String sID = input.nextLine();
                    System.out.println(registrar.assignInstructorToSection(assignInstructorSection, sID));
                    break;
                case "7":
                    if (instructorReg.getInstructorList().isEmpty()) {
                        System.out.println("Instructor list empty.");
                        break;
                    }
                    registrar.displayAllInstructor();
                    System.out.print("Select Instructor ID: ");
                    String removeInstructorID = input.nextLine();
                    Instructor selectedInstructor = instructorReg.findInstructorbyID(removeInstructorID);
                    if (selectedInstructor == null) {
                        System.out.println("Instructor not found.");
                        break;
                    }
                    if (selectedInstructor.getCourseList().isEmpty()) {
                        System.out.println("This instructor has no assigned courses.");
                        break;
                    }
                    System.out.println("Courses assigned to " + selectedInstructor.getName() + ":");
                    for (int i = 0; i < selectedInstructor.getCourseList().size(); i++) {
                        System.out.println((i + 1) + ". " + selectedInstructor.getCourseList().get(i));
                    }
                    System.out.print("Select Course ID to remove: ");
                    String removeCourseID = input.nextLine();
                    System.out.println(registrar.removeCourseFromInstructor(removeInstructorID, removeCourseID));
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
    static void sectionMenu(){
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- SECTION MANAGEMENT -------------|");
            System.out.println("= 1 = Add Section");
            System.out.println("= 2 = View All Sections");
            System.out.println("= 3 = Update Section Information");
            System.out.println("= 4 = Remove Section");
            System.out.println("= 5 = Unassign Instructors");
            System.out.println("= 0 = Back");
            System.out.println("|--------------- ------------------ -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1": {
                    try {
                        System.out.print("Section ID: ");
                        String id = input.nextLine();
                        System.out.print("Section Name: ");
                        String name = input.nextLine();
                        System.out.print("Max Capacity: ");
                        int cap = Integer.parseInt(input.nextLine());
                        System.out.print("Program: ");
                        String program = input.nextLine();
                        System.out.println(registrar.saveSection(new Section(id, name, cap, program)));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Capacity should be a number");
                    }
                    break;
                }
                case "2":
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("No existing sections.");
                        break;
                    }
                    registrar.displayAllSection();
                    break;
                case "3": {
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty. Cannot update.");
                        break;
                    }
                    registrar.displayAllSection();
                    System.out.print("Input Section ID to update: ");
                    String id = input.nextLine();
                    registrar.updateSection(new Section(id));
                    break;
                }
                case "4": {
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllSection();
                    System.out.print("Input Section ID to remove: ");
                    String id = input.nextLine();
                    registrar.removeSection(id);
                    break;
                }
                case "5":
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty.");
                        break;
                    }
                    registrar.displayAllSection();
                    System.out.print("Select Section ID to remove instructor from: ");
                    String removeSectionID = input.nextLine();
                    System.out.println(registrar.removeInstructorFromSection(removeSectionID));
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
    static void departmentMenu(){
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- DEPARTMENT MANAGEMENT -------------|");
            System.out.println("= 1 = Add Department");
            System.out.println("= 2 = View All Departments");
            System.out.println("= 3 = Update Department Information");
            System.out.println("= 4 = Remove Department");
            System.out.println("= 5 = Add Section to Department");
            System.out.println("= 6 = Remove Section from Department");
            System.out.println("= 7 = View Department Hierarchy");
            System.out.println("= 0 = Back");
            System.out.println("|--------------- ---------------------- -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1": {
                        System.out.print("Department ID: ");
                        String id = input.nextLine();
                        System.out.print("Department Name: ");
                        String name = input.nextLine();
                        System.out.println(registrar.saveDepartment(new Department(id, name)));
                    break;
                }
                case "2":
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("No existing departments.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    break;
                case "3": {
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("Department list empty. Cannot update.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    System.out.print("Input Department ID to update: ");
                    String id = input.nextLine();
                    registrar.updateDepartment(new Department(id));
                    break;
                }
                case "4": {
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("Department list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    System.out.print("Input Department ID to remove: ");
                    String id = input.nextLine();
                    registrar.removeDepartment(id);
                    break;
                }
                case "5": {
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("Department list empty. Cannot remove.");
                        break;
                    }
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty. Cannot remove.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    System.out.println("Select Department ID: ");
                    String assignDepartmentSection = input.nextLine();
                    registrar.displayAllSection();
                    System.out.println("Select Section ID: ");
                    String sID = input.nextLine();
                    System.out.println(registrar.addSectiontoDepartment(assignDepartmentSection, sID));
                    break;
                }
                case "6": {
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("No departments found.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    System.out.print("Input department ID: ");
                    String dID = input.nextLine();
                    Department dept = depReg.findDepartmentByID(dID);
                    if (dept == null) {
                        System.out.println("Department not found.");
                        break;
                    }
                    if (dept.getSections().isEmpty()) {
                        System.out.println("This department has no sections assigned yet.");
                        break;
                    }
                    System.out.print("Input section ID to remove: ");
                    String sID = input.nextLine();
                    System.out.println(registrar.removeSectionFromDepartment(dID, sID));
                    break;
                }
                case "7":
                    if (depReg.getDepartmentList().isEmpty()) {
                        System.out.println("No departments found.");
                        break;
                    }
                    registrar.displayAllDepartment();
                    System.out.println("Select Department ID to see hierarchy: ");
                    String id = input.nextLine();
                    registrar.viewDepartmentHierarchy(id);
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

    }
    static void  enrollmentMenu(){
        boolean back = false;
        while (!back) {
            System.out.println("\n|-------------- DEPARTMENT MANAGEMENT -------------|");
            System.out.println("= 1 = Enroll Student in Section");
            System.out.println("= 0 = Back");
            System.out.println("|--------------- ---------------------- -------------|");
            System.out.print(">>>| Select a number: ");
            switch (input.nextLine()) {
                case "1": {
                    if (studentReg.getStudentList().isEmpty()) {
                        System.out.println("Student list empty. Cannot enroll");
                        break;
                    }
                    if (sectionReg.getSectionList().isEmpty()) {
                        System.out.println("Section list empty. Cannot enroll.");
                        break;
                    }
                    registrar.displayAllStudent();
                    System.out.print("Select Student ID: ");
                    String studentID = input.nextLine();
                    registrar.displayAllSection();
                    System.out.println("Select Section ID: ");
                    String sectionID = input.nextLine();
                    registrar.enrollStudent(studentID, sectionID);
                    break;
                }
                case "2":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }
    }

            static void tuitionMenu(){}



}