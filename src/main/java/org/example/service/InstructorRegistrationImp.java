package org.example.service;

import org.example.model.Instructor;
import org.example.model.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class InstructorRegistrationImp implements InstructorRegistration{
    static Scanner input = new Scanner(System.in);
    private ArrayList<Instructor> instructorList = new ArrayList<>();
    private CourseRegistrationImpl courseRegistration;

    public InstructorRegistrationImp(CourseRegistrationImpl courseRegistration) {
        this.courseRegistration = courseRegistration;
    }

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

    public void updateInstructor(Instructor instructor){
        for(int i = 0; i< instructorList.size(); i++){
            if(instructorList.get(i).getId().equals(instructor.getId())){

                Instructor updateInstructorCourse = instructorList.get(i);

                System.out.println("Update name: ");
                String name = input.nextLine();

                System.out.println("Update age: ");
                int age = input.nextInt();
                input.nextLine();

                if (updateInstructorCourse.getCourse().isEmpty()){
                    System.out.println("No assigned courses to instructor to be updated.");
                } else {
                    System.out.println("\n--- Assigned Courses ---");
                    for (int k = 0; k < updateInstructorCourse.getCourse().size(); k++) {
                        System.out.println((k + 1) + ". " + updateInstructorCourse.getCourse().get(k).getCourseName());
                    }

                    System.out.println("Remove a course? (Y/N)");
                    String rmCourse = input.nextLine().toUpperCase().trim();

                    if (rmCourse.equals("Y")){
                        System.out.println("Enter the no. of course to remove: ");
                        int delAssigned = input.nextInt() -1;
                        input.nextLine();

                        if (delAssigned >= 0 && delAssigned < updateInstructorCourse.getCourse().size()) {
                            updateInstructorCourse.getCourse().remove(delAssigned);
                            System.out.println("Course removed from instructor!");
                        } else {
                            System.out.println("Invalid Selection! No courses removed.");
                        }
                    }
                }


                Instructor updatedInstructor = new Instructor(instructor.getId(), name, age, updateInstructorCourse.getCourse());
                instructorList.set(i, updatedInstructor);
                System.out.println("Instructor successfully updated!");
                return;
            }
        }
        System.out.println("No Instructor Found with ID.");

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

    public void addCourseInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getId().equals(instructor.getId())) {

                System.out.println("\n--- Available Courses ---");

                courseRegistration.displayAllCourse();

                System.out.println("\nEnter the ID of the course you want to assign: ");
                String selectedCourseId = input.nextLine();


                Course addCourse = courseRegistration.searchCourse(selectedCourseId);

                if (addCourse != null) {

                    instructorList.get(i).getCourse().add(addCourse);
                    System.out.println("Course successfully added to instructor!");
                } else {
                    System.out.println("Course ID not found. No course added.");
                }

                return;
            }
        }
        System.out.println("Instructor not found.");
    }


}