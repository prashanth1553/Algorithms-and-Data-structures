package com.models;

import java.util.Random;

abstract public class Pet <T extends Pet>{
    private String name;
    private int age;

    // Constructor
    public Pet(String petName, int petAge) {
        this.name = petName;
        this.age = petAge;
    }

    // Getters
    public String getName() { return(this.name); }
    public int getAge() { return(this.age); }

    // Setters
    public void setName(String nameSet) { this.name = nameSet; }
    public void setAge(int ageSet) { this.age = ageSet; }

    // Other Methods
    abstract public String speak();

    // toString
    @Override
    public String toString() {
        String answer = "Name: " + this.name + " Age: " + this.age;
        return answer;
    }
    public  String getColor(){
    	return "";
    }
}
