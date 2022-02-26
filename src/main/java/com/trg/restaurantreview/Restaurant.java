package com.trg.restaurantreview;
import javax.persistence.*;
import java.util.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<RestaurantReview> reviews;

    public Restaurant() {
        this.reviews = new ArrayList<>();
    } //javabeans convention

    public Restaurant(String name, String address, String phoneNumber, String description){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.reviews = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addReview(RestaurantReview review) {
        this.reviews.add(review);
    }

    public void removeReview(RestaurantReview review) {
       this.reviews.remove(review);
    }

    public List<RestaurantReview> getReviews() {
        return this.reviews;
    }

}
