package org.example.model;

public class Person {
    private int id;
    private String name;
    public Person(){
        this(0);

    }

    public Person(int id) {
        this( id,"Unknown");
        this.id = id;
    }

    public Person(int id, String name){
        this.id = id;
        this.name = name;
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
}
