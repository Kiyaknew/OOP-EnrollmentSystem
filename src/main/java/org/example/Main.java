package org.example;
import org.example.model.Instructor;
import org.example.model.Student;


public class Main {
    public static void main(String[] args) {
            Student student1 = new Student(101, "John Doe");
            Instructor instructor1 = new Instructor(201, "Jane Doe");

            System.out.println("Student ID: " + student1.getId());
            System.out.println("Student Name: " + student1.getName());

            student1.setProgram("BS Information Technology");

            System.out.println("Student Program: " + student1.getProgram());

            System.out.println("Instructor ID: " + instructor1.getId());
            System.out.println("Instructor Name: " + instructor1.getName());

            instructor1.setCourse("Integrative Programming and Technologies");

            System.out.println("Taken Course: " + instructor1.getCourse());
        }

    }
