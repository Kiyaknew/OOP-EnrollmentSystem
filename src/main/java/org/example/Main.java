package org.example;
import org.example.model.*;

public class Main{
        public static void main(String[] args){
                Dog dog = new Dog("Yumi", 2);

                dog.setAge(3);
                System.out.println(dog.getAge());
                dog.sound();
        }
}
