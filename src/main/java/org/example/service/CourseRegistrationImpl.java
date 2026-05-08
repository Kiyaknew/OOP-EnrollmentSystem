package org.example.service;

import org.example.model.Course;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationImpl implements CourseRegistration{
    static Scanner input = new Scanner(System.in);
    private List<Course> courseList = new ArrayList<>();

    public void saveCourse(Course course){
        courseList.add(course);
    }

    public void displayAllCourse(){
        System.out.println("---------------------------COURSE LIST---------------------------");
        for (int k = 0; k < courseList.size(); k++) {
            System.out.println((k+1) + ". " + courseList.get(k));

        }
        System.out.println("-------------------------------------------------------------------");
    }

    public void updateCourse(Course course){
        for(int i = 0; i<courseList.size(); i++){
            if(courseList.get(i).getCourseID().equals(course.getCourseID())){
                System.out.println("Enter name: ");
                String name = input.nextLine();

                System.out.println("Enter program: ");
                String program = input.nextLine();

                System.out.print("Enter units: ");
                int units = input.nextInt();

                courseList.set(i, new Course(course.getCourseID(), name, program, units));
                break;
            }
        }
    }

    public String removeCourse(Course course){
        for(int i = 0; i<courseList.size(); i++){
            if(courseList.get(i).getCourseID().equals(course.getCourseID())){
                courseList.remove(i);
                return "Successfully Deleted";
            }
        }
        return "Error.";
    }

    public Course findCourseByID(String courseId){
        for (int i = 0; courseList.size() > i; i++) {
            if (courseList.get(i).getCourseID().equals(courseId)){
                return courseList.get(i);
            }
        }
        return null;
    }
}