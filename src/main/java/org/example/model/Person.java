package org.example.model;

public abstract class Person {
    private String id;
    private String name;
    private int age;

    public Person(){
        this("Unknown");

    }

    public Person(String id){
        this(id, "Unknown");
    }

    public Person(String id, String name){
        this(id, name, 0);

    }

    public Person(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(){
        this.age = age;
    }

    public abstract void mainTask();
}
