package com.example.appsenai.controller;

import com.example.appsenai.model.Person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer > {

    List<Person> findAll();

    void save(Person person);

    void delete(Person person);
}