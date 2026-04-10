package org.example;

import org.example.model.*;
import org.example.service.CampusRegistrar;
import org.example.service.CourseRegistrationImpl;
import org.example.service.StudentRegistrationImp;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Student student = new Student();
        student.mainTask();

        Instructor instructor = new Instructor();
        instructor.mainTask();

        StudentRegistrationImp studentRegistration = new StudentRegistrationImp();
        CourseRegistrationImpl courseRegistration = new CourseRegistrationImpl();

        CampusRegistrar campusRegistrar = new CampusRegistrar(studentRegistration, courseRegistration);

        //interactive
        while (true){
            System.out.print("\nPick a number.\n" +
                    "1. Student Registration\n" +
                    "2. Course Registration\n" +
                    "3. Exit\n" +
                    "Answer: ");

            int num1 = sc.nextInt();

            if (num1 == 1){
                System.out.print("\nStudent Registration:\n" +
                        "Pick a number.\n" +
                        "1. Save Student\n" +
                        "2. Display Student\n" +
                        "3. Update Student\n" +
                        "4. Remove Student\n" +
                        "Answer: ");
                int srNum = sc.nextInt();
                sc.nextLine();
                switch(srNum){
                    case 1:
                        System.out.println("\nSave Student.");
                        System.out.println("Enter Student ID: ");
                        String studID = sc.nextLine();

                        System.out.println("Enter Student Name: ");
                        String studName = sc.nextLine();

                        System.out.println("Enter Student Age: ");
                        int studAge = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter Program: ");
                        String studProgram = sc.nextLine();

                        campusRegistrar.saveStudent(new Student(studID, studName, studAge, studProgram));
                        break;

                    case 2:
                        campusRegistrar.displayAllStudent();
                        break;

                    case 3:
                        campusRegistrar.displayAllStudent();
                        System.out.println("Update Student.");
                        System.out.println("Enter Student ID: ");
                        String newStudID = sc.nextLine();
                        campusRegistrar.updateStudent(new Student(newStudID));
                        break;

                    case 4:
                        campusRegistrar.displayAllStudent();
                        System.out.println("Remove Student.");
                        System.out.println("Enter Student ID: ");
                        String delStudID = sc.nextLine();
                        System.out.println(campusRegistrar.removeStudent(new Student(delStudID)));
                        break;

                    default:
                        System.out.println("Error.");
                        break;
                }



            } else if (num1 == 2){
                System.out.print("\nCourse Registration:\n" +
                        "Pick a number.\n" +
                        "1. Save Course\n" +
                        "2. Display Course\n" +
                        "3. Update Course\n" +
                        "4. Remove Course\n" +
                        "Answer: ");
                int crNum = sc.nextInt();
                sc.nextLine();
                switch(crNum){
                    case 1:
                        System.out.println("\nSave Course.");
                        System.out.println("Enter Course ID: ");
                        String courseID = sc.nextLine();

                        System.out.println("Enter Course Name: ");
                        String courseName = sc.nextLine();

                        System.out.println("Enter Program: ");
                        String courseProgram = sc.nextLine();

                        campusRegistrar.saveCourse(new Course(courseID, courseName, courseProgram));
                        break;

                    case 2:
                        campusRegistrar.displayAllCourse();
                        break;

                    case 3:
                        campusRegistrar.displayAllCourse();
                        System.out.println("Update Course.");
                        System.out.println("Enter Course ID: ");
                        String newCourseID = sc.nextLine();
                        campusRegistrar.updateCourse(new Course(newCourseID));
                        break;

                    case 4:
                        campusRegistrar.displayAllCourse();
                        System.out.println("Remove Course.");
                        System.out.println("Enter Course ID: ");
                        String delCourseID = sc.nextLine();
                        System.out.println(campusRegistrar.removeCourse(new Course(delCourseID)));
                        break;

                    default:
                        System.out.println("Error.");
                        break;
                }


            } else if (num1 == 3){
                System.exit(0);


            } else {
                System.out.println("Error.\n");
            }
        }

    }
}