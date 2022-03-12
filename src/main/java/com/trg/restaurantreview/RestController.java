package com.trg.restaurantreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantReviewRepository restaurantReviewRepository;

    @PostMapping("/editingreview")
    public void editingReview(@RequestParam long reviewID, @RequestParam long restaurantID,
                             @RequestParam String message, @RequestParam int rating, @RequestParam String reviewerName){

        Restaurant restaurant = restaurantRepository.findById(restaurantID);
        List<RestaurantReview> myReviews = restaurant.getReviews();

        for (RestaurantReview review: myReviews){
            if (review.getId() == reviewID){
                review.setMessage(message);
                review.setReviewerName(reviewerName);
                review.setRating(rating);
            }
        }

        restaurantRepository.save(restaurant);
    }
}
