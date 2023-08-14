package com.example.appsenai.controller;

import com.example.appsenai.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer > {



}