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
        for (int i = 0; i < instructorList.size(); i++){
            if (instructorList.get(i).getId().equals(instructor.getId())) {
                System.out.println("Instructor ID " + instructor.getId() + " already exists.");
                return;
            }
        }
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
                int age = Integer.parseInt(input.nextLine());

                Instructor updatedInstructor = new Instructor(instructor.getId(), name, age);
                updatedInstructor.setCourseList(instructorList.get(i).getCourseList());
                instructorList.set(i, updatedInstructor);
                System.out.println("Instructor successfully updated.");
                return;
            }
        }
        System.out.println("No Instructor Found with ID.");

    }


    public void removeInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(instructor.getId())) {
                instructorList.remove(i);
                System.out.println("Successfully Deleted.");
                return;
            }
        }
        System.out.println("Instructor ID " + instructor.getId() + " does not exist.");
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
      System.out.println("Assigned course to instructor.");

    }

    public void assignInstructorToSection(String instructorID, String sectionID, SectionRegistration sectionReg){
        Instructor instructor = findInstructorbyID(instructorID);
        if (instructor == null){
            System.out.println("Instructor not found.");
            return;
        }
        Section section = sectionReg.findSectionByID(sectionID);
        if (section == null){
            System.out.println("Section not found");
            return;
        }
        if (section.getAssignedInstructor() != null) {
            System.out.println("Section " + section.getSectionName() + " already has an instructor: " +
                    section.getAssignedInstructor().getName() +
                    ". Please remove the current instructor first.");
            return;
        }
        section.setAssignedInstructor(instructor);
        System.out.println("Assigned instructor to section.");

    }
    public void removeInstructorFromSection(String sectionID, SectionRegistration sectionReg) {
        Section section = sectionReg.findSectionByID(sectionID);
        if (section == null) {
            System.out.println("Section not found.");
            return;
        }
        if (section.getAssignedInstructor() == null) {
            System.out.println("Section " + section.getSectionName() + " has no assigned instructor.");
            return;
        }
        System.out.println("Successfully removed " + section.getAssignedInstructor().getName() +
                " from section " + section.getSectionName());
        section.setAssignedInstructor(null);
    }

    public void removeCourseFromInstructor(String instructorID, String courseID) {
        Instructor instructor = findInstructorbyID(instructorID);
        if (instructor == null) {
            System.out.println("Instructor not found.");
            return;
        }
        if (instructor.getCourseList().isEmpty()) {
            System.out.println("This instructor has no assigned courses.");
            return;
        }
        for (int i = 0; i < instructor.getCourseList().size(); i++) {
            if (instructor.getCourseList().get(i).getCourseID().equals(courseID)) {
                System.out.println("Successfully removed " + instructor.getCourseList().get(i).getCourseName() +
                        " from " + instructor.getName());
                instructor.getCourseList().remove(i);
                return;
            }
        }
        System.out.println("Course ID " + courseID + " is not assigned to this instructor.");
    }

    public Instructor findInstructorbyID(String instructorID){
        for(int i = 0; instructorList.size() > i; i++){
            if(instructorList.get(i).getId().equals(instructorID)) {
                return instructorList.get(i);
            }
        }
        return null;
    }
    public List<Instructor> getInstructorList(){
        return instructorList;
    }

    public void searchByName(String name) {
        System.out.println("---------------------------SEARCH RESULTS---------------------------");
        boolean found = false;
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(instructorList.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("No instructors found with name: " + name);
        System.out.println("--------------------------------------------------------------------");
    }
}


