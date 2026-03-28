package org.example.model;

public abstract class Person {
    private int id;
    private String name;
    private int age;
    public Person(){
        this(0);

    }

    public Person(int id) {
        this( id,"Unknown");
        this.id = id;
    }

    public Person(int id, String name){
        this(id, name, 0);
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

}
