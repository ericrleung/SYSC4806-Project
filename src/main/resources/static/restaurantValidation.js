var addressField = document.getElementById("address");
var phoneField = document.getElementById("phoneNum");

function validateForm() {
  if (addressField.value == "") {
    alert("Address Should have format \"{number} {street name} Optional:{City/Country/Postal Code}\"");
    return false;
  }
  else if(phoneField.value == ""){
    alert("Phone Number Should follow format \"(XXX)-(XXX)-(XXXX)\"");
    return false;
  }
}