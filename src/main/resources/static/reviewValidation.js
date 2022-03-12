var rating = document.getElementById("rating");

function validateForm() {
  let ratingPattern = new RegExp("^[1-5]*$");
  var valid = new Boolean(true);
  if (rating.value == "" || !ratingPattern.test(rating.value)) {
    alert("Rating should be number in range [1,5]")
    valid = false;
  }

  return valid;
}