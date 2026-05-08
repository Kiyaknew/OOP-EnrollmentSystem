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

            }
        }
    }
}