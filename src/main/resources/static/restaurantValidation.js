var submitBtn = document.getElementById("submit");
var addressField = document.getElementById("address");
var phoneField = document.getElementById("phoneNum");

function validateForm() {
  let x = document.forms["myForm"]["fname"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}