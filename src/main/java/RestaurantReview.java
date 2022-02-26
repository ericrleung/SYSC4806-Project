import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RestaurantReview {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int rating;
    private String message;
    private String reviewerName;

    public RestaurantReview() {} //javabeans convention

    public RestaurantReview(int rating, String message, String reviewerName){
        this.rating = rating;
        this.message = message;
        this.reviewerName = reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

}
