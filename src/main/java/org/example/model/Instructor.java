package org.example.model;

public class Instructor extends Person{
    private String course;

    public Instructor(){
        super();
    }

    public Instructor(String instructorID){
        super(instructorID);

    }

    public Instructor(String instructorID, String instructorName){
        super(instructorID, instructorName);

    }

    public Instructor(String instructorID, String instructorName, int instructorAge){
        super(instructorID, instructorName,instructorAge);
    }

    public Instructor(String instructorID, String instructorName, int instructorAge, String course){
        super(instructorID, instructorName, instructorAge);
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID =" + super.getId() +
                "instructorName =" + super.getName() +
                "instructorAge =" + super.getAge() +
                "course ='" + course + '\'' +
                '}';
    }
}