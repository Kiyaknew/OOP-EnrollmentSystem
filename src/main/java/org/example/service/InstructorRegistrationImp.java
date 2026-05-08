package org.example.service;

import org.example.model.Instructor;
import org.example.model.Course;
import org.example.model.Section;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructorRegistrationImp implements InstructorRegistration {
    static Scanner input = new Scanner(System.in);
    private List<Instructor> instructorList = new ArrayList<>();

    public void saveInstructor(Instructor instructor) {
        instructorList.add(instructor);
        System.out.println(instructor.getName() + " added to the system.");
    }

    public void displayAllInstructor() {
        System.out.println("---------------------------INSTRUCTOR LISTS---------------------------");
        for (int k = 0; k < instructorList.size(); k++) {
            System.out.println((k + 1) + ". " + instructorList.get(k));

        }
        System.out.println("-------------------------------------------------------------------");
    }

    public void updateInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(instructor.getId())) {
                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter age: ");
                int age = input.nextInt();

                Instructor updatedInstructor = new Instructor(instructor.getId(), name, age);
                updatedInstructor.setCourseList(instructorList.get(i).getCourseList());
                instructorList.set(i, updatedInstructor);

            }
        }
        System.out.println("No Instructor Found with ID.");

    }


    public String removeInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(instructor.getId())) {
                instructorList.remove(i);
                return "Successfully Deleted.";
            }
        }
        return "Error.";
    }

    public void addCourseInstructor(String instructorID, String courseID, CourseRegistration courseReg){
      Instructor instructor = findInstructorbyID(instructorID);
      if (instructor == null){
          System.out.println("Instructor not found.");
          return;
      }
      Course course = courseReg.findCourseByID(courseID);
      if(course == null){
          System.out.println("Course not found.");
          return;
      }
      for (int i = 0; i < instructor.getCourseList().size(); i++){
          if(instructor.getCourseList().get(i).getCourseID().equals(courseID)){
              System.out.println("Course already assigned to the instructor!");
              return;
          }
      }
      instructor.getCourseList().add(course);
      System.out.println("Assined course to instructor.");

    }

    public void assignInstructorToSection(String instructorID, String sectionID){

    }

    public Instructor findInstructorbyID(String instructorID){
        for(int i = 0; instructorList.size() > i; i++){
            if(instructorList.get(i).getId().equals(instructorID)) {
                return instructorList.get(i);
            }
        }
        return null;
    }
}


