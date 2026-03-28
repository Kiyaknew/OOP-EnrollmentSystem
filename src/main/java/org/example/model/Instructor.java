package org.example.model;
import java.util.List;

public class Instructor extends Person{
    private List<Course> courseList;
    private List<Student> students;

    public Instructor(int id, String name, int age, List<Course> courseList, List<Student> students ) {
        super(id, name);
        this.courseList = courseList;
        this.students = students;
    }

    public List<Course> displayCourseList(){
        return courseList.stream().toList();
    }

    public List<Student> displayStudentList(){
        return students.stream().toList();
    }

    public void facultyTask(){
    System.out.println("Teach");
}
}