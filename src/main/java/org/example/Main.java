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
                case "2":
                    courseMenu();
                case "3":
                    instructorMenu();
                case "4":
                    sectionMenu();
                case "5":
                    departmentMenu();
                case "6":
                    enrollmentMenu();
                case "7":
                    tuitionMenu();
                case "0":
                    runSystem = false;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("Thank you for using E.X.E Campus System.");
    }
    //student menu

    static void studentMenu(){

    }


}