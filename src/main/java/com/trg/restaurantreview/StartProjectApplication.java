package com.trg.restaurantreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class StartProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(StartProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StartProjectApplication.class);
    }

    @Bean
    public CommandLineRunner defaultObjects(RestaurantReviewRepository reviewRepo, RestaurantRepository restaurantRepo) {
        return (args) -> {
            // save a few Reviews

            RestaurantReview r1 = new RestaurantReview(2, "Great Food", "Dylan");

            RestaurantReview r2 = new RestaurantReview(1, "Terrible Food", "Anil");

            Restaurant resto1 = new Restaurant("L'academie", "233 Carleton Drive", "455-899-6754", "Fancy French Cuisine");

            resto1.addReview(r1);
            resto1.addReview(r2);

            restaurantRepo.save(resto1);

            // fetch all reviews
            log.info("Entities found with findAll():");
            log.info("-------------------------------");
            for (Object item : reviewRepo.findAll()) {
                log.info( ((RestaurantReview) item).getMessage());
            }

            // fetch all restaurants
            log.info("Entities found with findAll():");
            log.info("-------------------------------");
            for (Object item : restaurantRepo.findAll()) {
                log.info( ((Restaurant) item).getName());
            }

            log.info("");
        };
    }

}
