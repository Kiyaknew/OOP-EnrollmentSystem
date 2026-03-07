package org.example.model;

public class Dog extends Animal {
    public Dog(String name, int age){
        super(name, age);
    }


    public void sound() {
        System.out.println("Dog Barks!");
    }
}
