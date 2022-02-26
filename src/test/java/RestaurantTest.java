import com.trg.restaurantreview.Restaurant;
import com.trg.restaurantreview.RestaurantReview;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestaurantTest {

    protected static Restaurant restaurant;

    @Before
    public void setUp(){
        restaurant = new Restaurant();
    }

    @Test
    public void testName() {
        restaurant.setName("Yummy Diner");
        assertEquals(restaurant.getName(), "Yummy Diner");
    }

    @Test
    public void testAddress() {
        restaurant.setAddress("123 Example Drive");
        assertEquals(restaurant.getAddress(), "123 Example Drive");
    }

    @Test
    public void testPhoneNumber(){
        restaurant.setPhoneNumber("123-456-789");
        assertEquals(restaurant.getPhoneNumber(), "123-456-789");
    }

    @Test
    public void testDescription(){
        restaurant.setDescription("A home-made food diner!");
        assertEquals(restaurant.getDescription(), "A home-made food diner!");
    }

    @Test
    public void testReview(){
        RestaurantReview review1 = new RestaurantReview(5 , "This restaurant is amazing!", "user123");
        RestaurantReview review2 = new RestaurantReview(1 , "This restaurant is terrible!", "user456");
        restaurant.addReview(review1);
        restaurant.addReview(review2);
        assertEquals(restaurant.getReviews(), new ArrayList<RestaurantReview>(Arrays.asList(review1, review2)));
    }



}
