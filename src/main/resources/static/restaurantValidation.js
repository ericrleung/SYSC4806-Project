var addressField = document.getElementById("address");
var phoneField = document.getElementById("phoneNum");
var websiteField = document.getElementById("web");

function validateForm() {
  let addressPattern = new RegExp("[0-9]+\\s.+");
  let phonePattern = new RegExp("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
  let websitePattern = new RegExp("[0-9a-z]+\\.[-_0-9a-z]+\\.[0-9a-z]+$");
  console.log(!addressPattern.test(addressField.value))
  console.log(!phonePattern.test(phoneField.value))
  console.log(!websitePattern.test(websiteField.value))

  let text = "";
  var valid = new Boolean(true);
  if (!addressPattern.test(addressField.value)) {
    text = text.concat("Address Should have format \"{number} {street name} Optional:{City/Country/Postal Code}\"");
    valid = false;
  }
  if (!phonePattern.test(phoneField.value)){
    if (text.length) {
      text = text.concat("\n\nPhone Number Should follow format \"XXX-XXX-XXXX\"");
    } else {
     text = text.concat("Phone Number Should follow format \"XXX-XXX-XXXX\"");
    }
    valid = false;
  }
  if (websiteField.value.length > 0 && !websitePattern.test(websiteField.value)) {
    if (text.length) {
      text = text.concat("\n\nWebsite should follow format \"{subdomain}.{domain name}.{domain name}\"");
    } else {
      text = text.concat("Website should follow format \"{subdomain}.{domain name}.{domain name}\"");
    }

    valid = false;
  }
  if (!valid) {
    alert(text);
  }
  return valid;
}