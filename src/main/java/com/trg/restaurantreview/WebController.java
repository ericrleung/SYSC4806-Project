package com.trg.restaurantreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "displayRestaurants"; //return to landing page
    }

    @GetMapping("/createrestaurant")
    public String createRestaurant(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "createRestaurant";
    }

    @PostMapping("/createrestaurant")
    public String restaurantCreated(@ModelAttribute Restaurant restaurant, Model model){
        restaurantRepository.save(restaurant);
        return "restaurantCreated";
    }

    @GetMapping("/restaurantreviews")
    public String restaurantReviews(Model model, @RequestParam(name="restaurantid", required=true) Long id) {
        Restaurant r =  restaurantRepository.findById(id).orElse(null);

        model.addAttribute("reviews", r.getReviews());
        model.addAttribute("restaurant", r);
        return "restaurantReviews";
    }

    @GetMapping("/createreview")
    public String createReview(Model model, @RequestParam(name="restaurantid", required=true) Long id) {
        Restaurant r =  restaurantRepository.findById(id).orElse(null);

        model.addAttribute("restaurant", r);
        return "createReview";
    }
}