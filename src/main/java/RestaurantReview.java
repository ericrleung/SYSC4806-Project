public class RestaurantReview {

    private int rating;
    private String message;
    private String reviewerName;

    RestaurantReview(int rating, String message, String reviewerName){
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
