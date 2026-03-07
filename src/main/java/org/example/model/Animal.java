package org.example.model;

public class Animal {
    private String name;
    private int age = 0;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
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

    public void setAge(int Age){
        this.age = age;
    }
}
