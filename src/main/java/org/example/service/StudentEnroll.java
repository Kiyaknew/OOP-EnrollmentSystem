package org.example.service;
import org.example.model.Student;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentEnroll {
        private Scanner input = new Scanner(System.in);
        private ArrayList <Student> studentsList = new ArrayList<>();

        //create
        public void addStudent(Student student){
            studentsList.add(student);
        }

        //read
        public void displayAll(){
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

                    studentsList.set(i, new Student(student.getId(), name, program));
                    break;
                }
            }
        }
        //remove
    public String deleteStudent(Student student){
            for(int i = 0; i < studentsList.size(); i++){
                if(studentsList.get(i).getId() == (student.getId())){
                    studentsList.remove(i);
                    return "Successfully deleted student.";
                }
            }
            return "Error occurred with deleting student.";
    }
}
