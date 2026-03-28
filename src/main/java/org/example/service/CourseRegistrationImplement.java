package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationImplement {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Course> courseList = new ArrayList<>();

    //create
    public void saveStudent(Course course){
        courseList.add(course);
    }

    //read
    public void displayAllStudent(){
        System.out.println(courseList);
    }

    //update
    public void updateStudent(Course course){
        for(int i = 0; i < courseList.size();i++){
            if (courseList.get(i).equals(course.getCourseID() == (course.getCourseID()){
                System.out.println("Enter Course Name: ");
                String courseName = input.nextLine();

                System.out.println("Enter Course Program: ");
                String program = input.nextLine();

                courseList.set(i, Course(course.getCourseID(), courseName, program));
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

}
