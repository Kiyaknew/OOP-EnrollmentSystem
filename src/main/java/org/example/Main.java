package org.example;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Course;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("Inteprog", "Integrative Programming", "IT");
        Course c2 = new Course("Dismath", "Discrete Mathematics", "IT");
        Course c3 = new Course("Sysde", "System Development", "IT");

        Student s1 = new Student(2021244770, "Erika Trixie P. Dirilo", 18, "IT");
        Student s2 = new Student(2021255660, "Mikaela Alexa A. Madrigal", 19, "IT");
        Student s3 = new Student(2024441226, "Nigel Andrei R. Linatoc", 20, "IT");

        List<Student> students =  new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        List<Course> courseList =  new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);

        System.out.println(courseList);
        System.out.println(students);

        Instructor instructor = new Instructor(100, "Miguel Edward D. Rosa", 24,  courseList, students);

        System.out.println(instructor.getId());
        System.out.println(instructor.getName());
        System.out.println("Instructors programs: " + instructor.displayCourseList());
        System.out.println("Instructors students: " + instructor.displayStudentList());

        Student student = new Student();
        student.mainTask();

        instructor.facultyTask();

        StudentRegistration studentRegistration = new StudentRegistrationImplement();

    }

}
