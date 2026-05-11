package org.example.service;

import org.example.model.Course;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationImpl implements CourseRegistration{
    static Scanner input = new Scanner(System.in);
    private List<Course> courseList = new ArrayList<>();

    public void saveCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(course.getCourseID())) {
                System.out.println("Course ID " + course.getCourseID() + " already exists.");
                return;
            }
        }
        courseList.add(course);
        System.out.println(course.getCourseName() + " added to the system.");
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
                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter program: ");
                String program = input.nextLine();

                System.out.print("Enter units: ");
                int units = Integer.parseInt(input.nextLine());

                courseList.set(i, new Course(course.getCourseID(), name, program, units));
                System.out.println("Course successfully updated.");
                return;
            }
        }
        System.out.println("Course ID " + course.getCourseID() + " does not exist.");
    }

    public void removeCourse(Course course){
        for(int i = 0; i<courseList.size(); i++){
            if(courseList.get(i).getCourseID().equals(course.getCourseID())){
                courseList.remove(i);
                System.out.println("Successfully Deleted");
                return;
            }
        }
        System.out.println("Course ID " + course.getCourseID() + " does not exist.");
        return;
    }

    public Course findCourseByID(String courseId){
        for (int i = 0; courseList.size() > i; i++) {
            if (courseList.get(i).getCourseID().equals(courseId)){
                return courseList.get(i);
            }
        }
        return null;
    }
    public List<Course> getCourseList() {
        return courseList;
    }
}