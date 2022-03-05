package com.trg.restaurantreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantReviewRepository restaurantReviewRepository;

    @PostMapping("/addingReview")
    public void addingReview(@RequestParam long restaurantID,
                             @RequestParam String message, @RequestParam int rating, @RequestParam String reviewerName){
        RestaurantReview newReview = new RestaurantReview(rating, message, reviewerName);
        Restaurant restaurant = restaurantRepository.findById(restaurantID);
        restaurant.addReview(newReview);
        restaurantRepository.save(restaurant);
    }

}
