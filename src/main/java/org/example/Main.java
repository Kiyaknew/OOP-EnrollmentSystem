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
            System.out.println(">>>| Select a number: ");
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
                    registrar.displayAllStudent();
                    break;
                case "3": {
                    registrar.displayAllStudent();
                    System.out.print("Input student ID to update: ");
                    String id = input.nextLine();
                    registrar.updateStudent(new Student(id));
                    break;
                }
                case "4": {
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
    static void courseMenu(){
    }

    static void instructorMenu(){}

    static void departmentMenu(){}

    static void sectionMenu(){}

    static void  enrollmentMenu(){}

    static void tuitionMenu(){}



}