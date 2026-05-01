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
                        System.out.println("\n---Management: INSTRUCTOR---");
                        System.out.println("1. CREATE Instructor\n" +
                                "2. DISPLAY Instructors\n" +
                                "3. UPDATE Instructor\n" +
                                "4. ASSIGN COURSES\n" +
                                "5. DELETE Instructor\n"
                        );
                        System.out.print("Enter choice: ");
                        int instchoice = input.nextInt();

                        input.nextLine();

                        switch (instchoice) { //nested case for all the instructor CRUD operations and other shtufff
                            case 1: //for creating instructors
                                System.out.println("--- Creating a New Instructor ---");
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

                                if(assignChoice == 1){ //For section assignment
                                    System.out.println("Will do this later :c");
                                    break;
                                } else if (assignChoice == 2){
                                    campusRegistrar.displayAllInstructor();
                                    System.out.println("-------------------------------------------");
                                    System.out.println("Enter Instructor ID to assign courses: ");
                                    String assignInstructorCourse = input.nextLine();
                                    campusRegistrar.assignCourse(new Instructor(assignInstructorCourse));
                                    break;
                                }

                            case 5: //For removing an instructor
                                campusRegistrar.displayAllInstructor();
                                System.out.println("Enter Instructor ID to Remove: ");
                                String delInstructorID = input.nextLine();
                                System.out.println(campusRegistrar.removeInstructor(new Instructor(delInstructorID)));
                                break;
                        }


                }
            } else if (choice1 == 3){
                break;
            }
        }
    }
}