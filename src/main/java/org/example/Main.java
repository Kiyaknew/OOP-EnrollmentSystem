package org.example;

public class Main {
    public static void main(String[] args) {
            Student student = new Student();
            student.setStudentID(2021244770);
            student.setStudentName("Erika Trixie P. Dirilo");
            student.setProgram("Information Technology");

            Student student2 = new Student();
            student2.setStudentID(2021244772);
            student2.setStudentName("Nhadiel Rheign D. Salcedo");
            student2.setProgram("AB Communication");

            Course course = new Course();
            course.setCourseID(2526);
            course.setCourseName("Inteprog");
            course.setCourse("Integrative Programming");

            Course course2 = new Course();
            course2.setCourseID(2528);
            course2.setCourseName("Wordlit");
            course2.setCourse("World and Literature");

            System.out.println("Name: " + student.getStudentName());
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Program: " + student.getProgram());

            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course ID: " + course.getCourseID());
            System.out.println("Course: " + course.getCourse());

            System.out.println("Name: " + student2.getStudentName());
            System.out.println("Student ID: " + student2.getStudentID());
            System.out.println("Program: " + student2.getProgram());

            System.out.println("Course Name: " + course2.getCourseName());
            System.out.println("Course ID: " + course2.getCourseID());
            System.out.println("Course: " + course2.getCourse());
        }

    }
