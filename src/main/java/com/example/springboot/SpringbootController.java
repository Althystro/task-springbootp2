package com.example.springboot;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")


public class SpringbootController {
    List<Person> personsList = new ArrayList<>();


    @PostMapping("/addContact")
    public String addContact(@RequestBody Person persons) {
        for (Person person : personsList) {
            if (person.getEmail().equals(persons.getEmail())) {
                return "Contact already exists with this email!";
            }
        }
        personsList.add(persons);
        return "added person successfully ";
    }
    //i have added the bonus to /addContact post method


    @GetMapping("/getContact")
    List<Person> getContact() {
        return personsList;
    }

    @GetMapping("/getContactByName/{name}")
    public Person getContactDetails(@PathVariable String name) throws Exception {
        for (Person person : personsList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new Exception(name + " not found");

    }

    //added both get by params methods just in case
    @GetMapping("/getContactByNameParams")
    @ResponseBody
    public Person getContactDetails1(@RequestParam String name) throws Exception {
        for (Person person : personsList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new Exception(name + " not found");

    }


}
