package com.example.crud.controllers;

import com.example.crud.model.Person;
import com.example.crud.personDAO.PersonDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
public class PersonController {

    @GetMapping("/")
    public String getPerson(Model model) {
        model.addAttribute("persons", PersonDao.personGet());
        return "person-get";
    }

    @GetMapping("/create-form")
    public String createForm(){
            return"create-form";
        }

    @PostMapping("/create")
    public String cereate(Person person){
        person.setId(UUID.randomUUID().toString());
        PersonDao.personGet().add(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        Person pesonDelete = PersonDao.personGet().stream().
                filter(person -> person.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        PersonDao.personGet().remove(pesonDelete);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable("id") String id, Model model){
        Person personUpdate = PersonDao.personGet().stream().
                filter(person -> person.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        model.addAttribute("person", personUpdate);
        return "edit-form";
    }

    @PostMapping("/update")
    public String update(Person person){
        delete(person.getId());
        PersonDao.personGet().add(person);
        return "redirect:/";
    }

}



