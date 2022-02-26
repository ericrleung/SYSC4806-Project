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
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/")
    public String restaurant(Model model) {
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantRepository.findAll();
        model.addAttribute("restaurants", restaurants);
        return "index"; //return landing page
    }
    
}