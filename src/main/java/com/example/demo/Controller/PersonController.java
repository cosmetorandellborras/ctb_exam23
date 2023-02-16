package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository repository;


    @GetMapping("/persons")
    public List<Person> allPersons(){
        return repository.findAll();
    }
    @GetMapping(value = "/personsxml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Person> allPersonsXML(){
        return repository.findAll();
    }

    @GetMapping("/person/{name}")
    public List<Person> findByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id ,@RequestBody Person person) {
        return repository.save(person);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}