package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistrationImp implements StudentRegistration {
    static Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getId().equals(student.getId())) {
                System.out.println("Student ID " + student.getId() + " already exists.");
                return;
            }
        }
        studentList.add(student);
        System.out.println(student.getName() + " added to the system.");
    }

    public void displayAllStudent() {
        System.out.println("---------------------------STUDENT LISTS---------------------------");
            for (int k = 0; k < studentList.size(); k++) {
                System.out.println((k + 1) + ". " + studentList.get(k));

            }
        System.out.println("-------------------------------------------------------------------");
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                System.out.println("Enter name: ");
                String name = input.nextLine();

                System.out.println("Enter age: ");
                int age = input.nextInt();

                input.nextLine();
                System.out.println("Enter program: ");
                String program = input.nextLine();

                studentList.set(i, new Student(student.getId(), name, age, program));
                System.out.println("Student successfully updated.");
                return;
            }
        }
        System.out.println("Student ID not found in the system.");
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(student.getId())) {
                studentList.remove(i);
                System.out.println("Successfully Deleted.");
                return;
            }
        }
        System.out.println("Student ID " + student.getId() + " does not exist.");
    }

    public Student findStudentByID(String studentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(studentID)) {
               return studentList.get(i);
            }
        }
        return null;
    }
}