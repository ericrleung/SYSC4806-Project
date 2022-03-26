function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("mylist");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.getElementsByClassName("rating")[0].innerHTML.includes(filter) || filter == "ALL") {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}