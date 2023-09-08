package com.example.crud.personDAO;

import com.example.crud.model.Person;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class PersonDao {

    private static Set<Person> people = new HashSet<>();

    static {
        people.add(new Person(UUID.randomUUID().toString(),"Саша",22, "junior"));
        people.add(new Person(UUID.randomUUID().toString(),"Маша",18, "trainee"));
        people.add(new Person(UUID.randomUUID().toString(),"Леша",30, "Senior"));
        people.add(new Person(UUID.randomUUID().toString(),"Гена",35, "Lead"));
    }


    public static Set<Person> personGet(){
        return people;


    }

}
