package org.example;

import org.example.model.*;
import org.example.service.CampusRegistrar;
import org.example.service.CourseRegistrationImpl;
import org.example.service.InstructorRegistrationImp;
import org.example.service.StudentRegistrationImp;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Student student = new Student();
        student.mainTask();

        Instructor instructor = new Instructor();
        instructor.mainTask();

        StudentRegistrationImp studentRegistration = new StudentRegistrationImp();
        CourseRegistrationImpl courseRegistration = new CourseRegistrationImpl();
        InstructorRegistrationImp instructorRegistration = new InstructorRegistrationImp(courseRegistration);

        CampusRegistrar campusRegistrar = new CampusRegistrar(studentRegistration, courseRegistration, instructorRegistration);

        //interactive
        while (true) {
            System.out.print("\n---DLSL Enrollment and Management System---\n" +
                    "1. Campus Management\n" +
                    "2. Enroll Student\n"  +
                    "3. Exit\n" +
                    "Choice: ");

            int choice1 = input.nextInt();

            if (choice1 == 1) {
                System.out.print("\n---Campus Management---\n" +
                        "1. Instructor and Assigned Course Management\n" +
                        "2. Student Management\n" +
                        "3. Course Management\n" +
                        "4. Section Management\n" +
                        "5. Department Management\n" +
                        "Enter choice: ");
                int srNum = input.nextInt();
                input.nextLine();
                switch (srNum) {
                    case 1:
                        System.out.println("\n--- Management: INSTRUCTORS ---");
                        System.out.println("1. CREATE Instructor\n" +
                                "2. DISPLAY Instructors\n" +
                                "3. UPDATE Instructor\n" +
                                "4. ASSIGN COURSES\n" +
                                "5. DELETE Instructor\n" +
                                "6. Back to Main\n"
                        );
                        System.out.print("Enter choice: ");
                        int instchoice = input.nextInt();

                        input.nextLine();

                        switch (instchoice) { //nested case for all the instructor CRUD operations and other shtufff
                            case 1: //for creating instructors
                                System.out.println("--- Create New Instructor ---");
                                System.out.print("Enter Instructor ID: ");
                                String instID = input.nextLine();

                                System.out.print("Enter Instructor Name: ");
                                String instName = input.nextLine();

                                System.out.print("Enter Instructor Age: ");
                                int instAge = input.nextInt();
                                input.nextLine();

                                campusRegistrar.saveInstructor(new Instructor(instID, instName, instAge));
                                break;

                            case 2: //for displaying instructors
                                campusRegistrar.displayAllInstructor();
                                break;

                            case 3: //for updating instructors and their current courses
                                campusRegistrar.displayAllInstructor();
                                System.out.println("Enter ID of Instructor to Update: ");
                                String updInstructor = input.nextLine();
                                campusRegistrar.updateInstructor(new Instructor(updInstructor));
                                break;

                            case 4: //for assigning courses and section
                                System.out.println("--- Instructor Assignment ---");
                                System.out.println("1. Section");
                                System.out.println("2. Course");
                                int assignChoice = input.nextInt();
                                input.nextLine();
                                if(assignChoice == 1){ //For section assignment
                                    System.out.println("Will do this later :c");
                                    break;
                                } else if (assignChoice == 2){
                                    campusRegistrar.displayAllInstructor();
                                    System.out.print("Enter Instructor ID to assign courses: ");

                                    String assignInstructorCourse = input.nextLine().trim();

                                    campusRegistrar.assignCourse(new Instructor(assignInstructorCourse));
                                    break;
                                }

                            case 5: //For removing an instructor
                                campusRegistrar.displayAllInstructor();
                                System.out.println("Enter Instructor ID to delete: ");
                                String delInstructorID = input.nextLine();
                                System.out.println(campusRegistrar.removeInstructor(new Instructor(delInstructorID)));
                                break;

                            case 6://Exiting the instructor management
                                System.out.println("Redirecting . . .\n");
                                break;
                        }
                        break;
                    case 2: //nested case for all Student CRUD operations
                        System.out.println("--- Management: STUDENTS ---");
                        System.out.println("1. CREATE Student\n" +
                                        "2. DISPLAY Student\n" +
                                        "3. UPDATE Student\n" +
                                        "4. DELETE Student\n" +
                                        "5. Back to Main\n"
                        );
                        System.out.print("Enter choice: ");
                        int studChoice = input.nextInt();

                        input.nextLine();

                        switch(studChoice) {
                            case 1: //making new student
                                System.out.println("--- Create New Student ---");
                                System.out.print("Enter Student ID: ");
                                String studID = input.nextLine();

                                System.out.print("Enter Student Name: ");
                                String studName = input.nextLine();

                                System.out.print("Enter Student Age: ");
                                int studAge = input.nextInt();

                                System.out.print("Enter Student Program: ");
                                String studProg = input.nextLine();

                                input.nextLine();
                                campusRegistrar.saveStudent(new Student(studID, studName, studAge, studProg));
                                break;

                            case 2: //displaying all students
                                campusRegistrar.displayAllStudent();
                                break;

                            case 3:
                                campusRegistrar.displayAllStudent();
                                System.out.print("Enter Student ID to Update: ");
                                String newStudID = input.nextLine();
                                campusRegistrar.updateStudent(new Student(newStudID));
                                break;

                            case 4:
                                campusRegistrar.displayAllStudent();
                                System.out.println("Enter Student ID to delete: ");
                                String rmStudID = input.nextLine();
                                System.out.println(campusRegistrar.removeStudent(new Student(rmStudID)));
                                break;

                            case 5:
                               System.out.println("Redirecting . . .\n");
                               break;

                            default:
                                System.out.println("Error in reading input. Redirecting . . .");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("--- Management: COURSE ---");
                        System.out.println("1. CREATE Course\n" +
                                "2. DISPLAY Courses\n" +
                                "3. UPDATE Course\n" +
                                "4. DELETE Course\n" +
                                "5. Back to Main\n"
                        );
                        System.out.print("Enter choice: ");
                        int courChoice = input.nextInt();

                        input.nextLine();

                        switch(courChoice){
                            case 1:
                                System.out.println("--- Create New Course ---");
                                System.out.print("Enter Course ID: ");
                                String courID = input.nextLine();

                                System.out.print("Enter Course Name: ");
                                String courName = input.nextLine();

                                System.out.print("Enter Course Program: ");
                                String courProg = input.nextLine();

                                campusRegistrar.saveCourse(new Course(courID, courName, courProg));
                                break;

                            case 2:
                                campusRegistrar.displayAllCourse();
                                break;

                            case 3:
                                campusRegistrar.displayAllCourse();
                                System.out.println("Enter Course ID to update: ");
                                String newCourseID = input.nextLine();
                                campusRegistrar.updateCourse(new Course(newCourseID));
                                break;

                            case 4:
                                campusRegistrar.displayAllCourse();
                                System.out.println("Remove Course.");
                                System.out.println("Enter Course ID: ");
                                String rmCourseID = input.nextLine();
                                System.out.println(campusRegistrar.removeCourse(new Course(rmCourseID)));
                                break;

                            case 5:
                                System.out.println("Redirecting . . .");
                                break;

                            default:
                                System.out.println("Error in reading input. Redirecting . . .");
                                break;
                        }



                }
            } else if (choice1 == 3){
                break;
            }
        }
    }
}