package com.trg.restaurantreview;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "restaurantReview", path = "restaurantReview")
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findById(long id);
}
