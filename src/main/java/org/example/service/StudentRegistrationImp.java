package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistrationImp implements StudentRegistration{
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();

    public void saveStudent(Student student){
        studentList.add(student);
    }

    public void displayAllStudent(){
        System.out.println(studentList);
    }

    public void updateStudent(Student student){
        for(int i = 0; i< studentList.size(); i++){
            if(studentList.get(i).getId().equals(student.getId())){
                System.out.println("Enter name: ");
                String name = sc.nextLine();

                System.out.println("Enter age: ");
                int age = sc.nextInt();

                System.out.println("Enter program: ");
                String program = sc.nextLine();

                studentList.set(i, new Student(student.getId(), name, age,  program));
                break;
            }
        }
    }

    public String removeStudent(Student student){
        for(int i = 0; i< studentList.size(); i++){
            if(studentList.get(i).getId().equals(student.getId())){
                studentList.remove(i);
                return "Successfully Deleted.";
            }
        }
        return "Error.";
    }
}