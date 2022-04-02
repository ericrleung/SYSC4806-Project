function filterLowToHigh(){
    var input, table, tr, td, i, shouldSwitch;
      input = document.getElementById("mylist");
      table = document.getElementById("myTable");
      tr = table.getElementsByTagName("tr");
      switching = true;
      while (switching) {
              //start by saying: no switching is done:
              switching = false;
              rows = table.rows;
              /*Loop through all table rows (except the
              first, which contains table headers):*/
              for (i = 0; i < (rows.length - 1); i++) {
                  //start by saying there should be no switching:
                  shouldSwitch = false;
                  /*Get the two elements you want to compare,
                  one from current row and one from the next:*/
                  x = rows[i].getElementsByTagName("TD")[0].getElementsByClassName("rating")[0].innerHTML
                  y = rows[i + 1].getElementsByTagName("TD")[0].getElementsByClassName("rating")[0].innerHTML
                  //check if the two rows should switch place:
                  if (x > y) {
                      //if so, mark as a switch and break the loop:
                      shouldSwitch = true;
                      break;
                  }
              }
              if (shouldSwitch) {
                  /*If a switch has been marked, make the switch
                  and mark that a switch has been done:*/
                  rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                  switching = true;
              }
          }
    }