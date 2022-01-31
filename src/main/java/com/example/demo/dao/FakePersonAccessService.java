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

}
