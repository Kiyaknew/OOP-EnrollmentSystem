package org.example.service;

import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.Scanner;

public class InstructorRegistrationImp implements InstructorRegistration{
    static Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    public void saveInstructor(Instructor instructor){
        instructorList.add(instructor);
    }

    public void displayAllInstructor() {
        System.out.println("---------------------------INSTRUCTOR LISTS---------------------------");
        for (int k = 0; k < instructorList.size(); k++) {
            System.out.println((k+1) + ". " + instructorList.get(k));

        }
        System.out.println("-------------------------------------------------------------------");
    }

    public void updateInstructor(Instructor  instructor){
        for(int i = 0; i< instructorList.size(); i++){
            if(instructorList.get(i).getId().equals(instructor.getId())){
                System.out.println("Enter name: ");
                String name = input.nextLine();

                System.out.println("Enter age: ");
                int age = input.nextInt();

                input.nextLine();
                System.out.println("Enter course: ");
                String course = input.nextLine();

                instructorList.set(i, new Instructor(instructor.getId(), name, age, course));
                break;
            }
        }
    }

    public String removeInstructor(Instructor  instructor){
        for(int i = 0; i< instructorList.size(); i++){
            if(instructorList.get(i).getId().equals(instructor.getId())){
                instructorList.remove(i);
                return "Successfully Deleted.";
            }
        }
        return "Error.";
    }
}