
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestaurantReviewTest {

    @Test
    public void getRatingTest() {
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        assertEquals(4, rr.getRating());
    }

    @Test
    public void getMessageTest() {
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        assertEquals("testing", rr.getMessage());
    }

    @Test
    public void getReviewerNameTest(){
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        assertEquals("Anil Menon", rr.getReviewerName());
    }

    @Test
    public void setRatingTest() {
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        rr.setRating(5);
        assertEquals(5, rr.getRating());
    }

    @Test
    public void setMessageTest() {
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        rr.setMessage("new message");
        assertEquals("new message", rr.getMessage());
    }

    @Test
    public void setReviewerNameTest() {
        RestaurantReview rr = new RestaurantReview(4, "testing", "Anil Menon");
        rr.setReviewerName("David Chang");
        assertEquals("David Chang", rr.getReviewerName());
    }

}
