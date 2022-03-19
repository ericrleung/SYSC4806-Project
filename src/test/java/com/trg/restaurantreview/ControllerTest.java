package com.trg.restaurantreview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testLandingPage() throws Exception {
        this.mvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurant Reviews")));
    }

    @Test
    public void testAddRestaurant() throws Exception {
        this.mvc.perform((post("/createrestaurant")
                        .param("name", "sampleRestaurant")
                        .param("address", "1125 ColonelBy Drive")
                        .param("phoneNumber", "613-123-4567")))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurant Added")));

    }

    @Test
    public void testRemoveRestaurant() throws Exception {
        this.mvc.perform((post("/createrestaurant")
                .param("name", "sampleRestaurant")
                .param("address", "1125 ColonelBy Drive")
                .param("phoneNumber", "613-123-4567")));
        this.mvc.perform(post("/deleterestaurant")
                        .param("restaurantid", "4"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurant Reviews")));
    }

    @Test
    public void testEditRestaurant() throws Exception {
        this.mvc.perform((post("/createrestaurant")
                .param("name", "sampleRestaurant")
                .param("address", "1125 ColonelBy Drive")
                .param("phoneNumber", "613-123-4567")))
                .andDo(print());
        this.mvc.perform(post("/restaurantreviews")
                        .param("restaurantid", "6")
                        .param("name", "newSampleRestaurant")
                        .param("phoneNumber", "123-456-789")
                        .param("address", "1123 Colonel By Drive")
                        .param("description", "this is a new description"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurant Reviews")));
    }

    @Test
    public void addRestaurantReview() throws Exception {
        this.mvc.perform((post("/createrestaurant")
                        .param("name", "sampleRestaurant")
                        .param("address", "1125 ColonelBy Drive")
                        .param("phoneNumber", "613-123-4567")))
                .andDo(print());
        this.mvc.perform(post("/addingReview")
                        .param("restaurantID", String.valueOf(4))
                        .param("rating", String.valueOf(5))
                        .param("message", "hello")
                        .param("reviewerName", "Yathu"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Review Added")));
    }

    @Test
    public void editRestaurantReview() throws Exception{
        this.mvc.perform((post("/createrestaurant")
                        .param("name", "sampleRestaurant")
                        .param("address", "1125 ColonelBy Drive")
                        .param("phoneNumber", "613-123-4567")))
                .andDo(print());
        this.mvc.perform(post("/addingReview")
                        .param("restaurantID", String.valueOf(7))
                        .param("rating", String.valueOf(5))
                        .param("message", "hello")
                        .param("reviewerName", "Yathu"))
                .andDo(print());
        this.mvc.perform(post("/restaurantreviews")
                        .param("restaurantid", String.valueOf(7))
                        .param("reviewID", String.valueOf(1))
                        .param("rating", String.valueOf(5))
                        .param("message", "test")
                        .param("reviewerName", "Yathu"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("sampleRestaurant")));
    }

    @Test
    public void removeRestaurantReview() throws Exception{
        this.mvc.perform((post("/createrestaurant")
                        .param("name", "sampleRestaurant")
                        .param("address", "1125 ColonelBy Drive")
                        .param("phoneNumber", "613-123-4567")))
                .andDo(print());
        this.mvc.perform(post("/addingReview")
                        .param("restaurantID", String.valueOf(7))
                        .param("rating", String.valueOf(5))
                        .param("message", "hello")
                        .param("reviewerName", "Yathu"))
                .andDo(print());
        this.mvc.perform(post("/deletereview")
                        .param("restaurantid", "7")
                        .param("reviewid", "5"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("sampleRestaurant")));

    }

}


