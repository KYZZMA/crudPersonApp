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
        PersonDao.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
       PersonDao.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable("id") int id, Model model){
        Person personUpdate = PersonDao.showIndex(id);
        model.addAttribute("person", personUpdate);
        return "edit-form";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id){
        PersonDao.update(person, id);
        return "redirect:/";
    }

}



