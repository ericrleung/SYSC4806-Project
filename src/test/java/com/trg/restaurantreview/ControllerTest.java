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
                .param("phoneNumber", "613-123-4567")));
        this.mvc.perform((post("/editrestaurant")
                        .param("addressBookID", "1")
                        .param("buddyInfoName", "khalil")
                        .param("buddyInfoPhoneNumber", "613")))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("added Buddy")));
    }

}


