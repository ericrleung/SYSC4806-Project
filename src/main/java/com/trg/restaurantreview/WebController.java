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
import java.util.List;

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

        if(r.getReviews() != null) {
            model.addAttribute("reviews", r.getReviews());
        }
        model.addAttribute("restaurant", r);
        return "restaurantReviews";
    }

    @GetMapping("/createreview")
    public String createReview(Model model, @RequestParam(name="restaurantid", required=true) Long id) {
        Restaurant r =  restaurantRepository.findById(id).orElse(null);

        model.addAttribute("restaurant", r);
        return "createReview";
    }

    @PostMapping("/addingReview")
    public String addingReview(Model model, @RequestParam long restaurantID,
                             @RequestParam String message, @RequestParam int rating, @RequestParam String reviewerName) {
        RestaurantReview newReview = new RestaurantReview(rating, message, reviewerName);
        Restaurant restaurant = restaurantRepository.findById(restaurantID);
        restaurant.addReview(newReview);
        restaurantRepository.save(restaurant);
        model.addAttribute("restaurant", restaurant);
        return "reviewCreated";
    }
        
    @GetMapping("/editreview")
    public String editReview(Model model, @RequestParam(name="restaurantid", required=true) Long restaurantid,
                             @RequestParam(name="reviewid", required=true) Long reviewid) {
        Restaurant restaurant =  restaurantRepository.findById(restaurantid).orElse(null);
        model.addAttribute("restaurant", restaurant);

        List<RestaurantReview> myReviews = restaurant.getReviews();

        for (RestaurantReview review: myReviews){
            if (review.getId() == reviewid){
                model.addAttribute("review", review);
                break;
            }
        }
        return "editReview";
    }


    @GetMapping("/editrestaurant")
    public String editRestaurant(Model model, @RequestParam(name="restaurantid", required=true) Long restaurantid) {
        Restaurant restaurant =  restaurantRepository.findById(restaurantid).orElse(null);
        model.addAttribute("restaurant", restaurant);

        return "editRestaurant";
    }

    @PostMapping("/restaurantreviews")
    public String editingRestaurant(Model model, @RequestParam(name="restaurantid", required=true) Long restaurantID,
                              @RequestParam(required = false) String name, @RequestParam(required = false) String phoneNumber,
                              @RequestParam(required = false) String address, @RequestParam(required = false) String description,
                                    @RequestParam(required = false) String reviewerName,@RequestParam(required = false) Integer rating,
                                    @RequestParam(required = false) String message, @RequestParam(required = false) String website,
                                    @RequestParam(required = false) Long reviewID){
        Restaurant restaurant = restaurantRepository.findById(restaurantID).orElse(null);

        if (name != null) {
        restaurant.setName(name);
        restaurant.setPhoneNumber(phoneNumber);
        restaurant.setAddress(address);
        restaurant.setWebsite(website);
        restaurant.setDescription(description);
    } else {
        List<RestaurantReview> myReviews = restaurant.getReviews();

        for (RestaurantReview review: myReviews){
            if (review.getId() == reviewID){
                review.setMessage(message);
                review.setReviewerName(reviewerName);
                review.setRating(rating);
            }
        }
    }
        restaurantRepository.save(restaurant);

        if(restaurant.getReviews() != null) {
            model.addAttribute("reviews", restaurant.getReviews());
        }
        model.addAttribute("restaurant", restaurant);
        return "restaurantReviews";
    }

    @PostMapping("/deletereview")
    public String deleteReview(Model model, @RequestParam(name="restaurantid", required=true) Long restaurantid,
                               @RequestParam(name="reviewid", required=true) Long reviewid) {
        Restaurant restaurant =  restaurantRepository.findById(restaurantid).orElse(null);
        model.addAttribute("restaurant", restaurant);

        List<RestaurantReview> myReviews = restaurant.getReviews();

        for (RestaurantReview review: myReviews){
            if (review.getId() == reviewid){
                myReviews.remove(review);
                break;
            }
        }
        restaurantRepository.save(restaurant);
        model.addAttribute("reviews", restaurant.getReviews());
        return "restaurantReviews";
    }

    @PostMapping("/deleterestaurant")
    public String deleteReview(Model model, @RequestParam(name="restaurantid", required=true) Long restaurantid) {
        restaurantRepository.deleteById(restaurantid);
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantRepository.findAll();
        model.addAttribute("restaurants", restaurants);
        return "displayRestaurants";
    }

}