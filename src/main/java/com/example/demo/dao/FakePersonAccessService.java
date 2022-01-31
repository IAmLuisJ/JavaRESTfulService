package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public class FakePersonAccessService {
    private static List<Person> DB = new ArrayList<>();

    public int InsertPerson(UUID id, String personName) {
        DB.add(new Person(id, personName));
        return 1;
    }

    public List<Person> selectAllPeople() {
        return DB;
    }

    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    public int deletePersonById(UUID id) {
        // Optional object has ifPresent() method
        Optional<Person> maybe = selectPersonById(id);
        if (maybe.isEmpty()) {
            return 1;
        }
        DB.remove(maybe.get());
        return 0;
    }

    public int updatePersonById(UUID id, Person updatedPerson) {
        // update person
        Optional<Person> maybe = selectPersonById(id);
        if (maybe.isEmpty()) {
            return 1;
        }
        // person exists
        var maybeIdex = DB.indexOf(maybe.get());
        DB.set(maybeIdex, updatedPerson);
        return 0;
    }

}
