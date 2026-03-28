package org.example.service;
import org.example.model.Student;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class StudentRegistrationImplement implements StudentRegistration{
    private Scanner input = new Scanner(System.in);
    private ArrayList <Student> studentsList = new ArrayList<>();

    //create
    public void saveStudent(Student student){
        studentsList.add(student);
    }

    //read
    public void displayAllStudent(){
        System.out.println(studentsList);
    }

    //update
    public void updateStudent(Student student){
        for(int i = 0; i < studentsList.size();i++){
            if (studentsList.get(i).getId() == (student.getId())){
                System.out.println("Enter new student name: ");
                String name = input.nextLine();

                System.out.println("Enter new student program: ");
                String program = input.nextLine();

                System.out.println("Enter new student age: ");
                int age = input.nextInt();

                studentsList.set(i, new Student(student.getId(), name, age, program));
                break;
            }
        }
    }
    //remove
    public String removeStudent(Student student){
        for(int i = 0; i < studentsList.size(); i++){
            if(studentsList.get(i).getId() == (student.getId())){
                studentsList.remove(i);
                return "Successfully deleted student.";
            }
        }
        return "Error occurred with deleting student.";
    }
}
