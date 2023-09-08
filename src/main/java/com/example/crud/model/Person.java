package com.example.crud.model;

public class Person {

    private String id;
    private String name;
    private int age;
    private String range;


    public Person(String id, String name, int age, String range) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.range = range;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

}
