package com.trg.restaurantreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class WebController {
//    @Autowired
//    AddressRepository addressRepository;
//    @GetMapping("/books")
//    public String address(Model model) {
//        ArrayList<AddressBook> books = (ArrayList<AddressBook>) addressRepository.findAll();
//        model.addAttribute("books", books);
//        return "books";
//    }

    @GetMapping("/restaurant")
    public String bookbuddies(Model model, @RequestParam(name="restaurantid", required=true) Long id) {
//        ArrayList<AddressBook> books = (ArrayList<AddressBook>) addressRepository.findAllById(Collections.singleton(id));
//
//        for(BuddyInfo a : books.get(0).getBuddies()){System.out.println(a);}
//
//        model.addAttribute("buddies", books.get(0).getBuddies());
        return " "; //return restaurant object page
    }

//    @GetMapping("/result")
//    public String greetingSubmit(Model model) {
//        return "result";
//    }
//
//    @GetMapping("/createbooks")
//    public String greetingForm(Model model) {
//        model.addAttribute("book", new AddressBook());
//        return "createbooks";
//    }
//
//    @PostMapping("/addContact")
//    public String addContact(AddressBook book) {
//        book.addBuddy(new BuddyInfo());
//        return "createbooks :: contacts"; // returning the updated section
//    }
}