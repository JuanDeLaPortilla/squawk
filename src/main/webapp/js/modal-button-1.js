// Get the modal
const modal1 = document.getElementById("modalForm1");

// Get the button that opens the modal
const btn1 = document.getElementById("modalBtn1");

// Get the <span> element that closes the modal
const span1 = document.getElementById("closeModalBtn1");

// When the user clicks on the button, open the modal
btn1.onclick = function() {
    modal1.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span1.onclick = function() {
    modal1.style.display = "none";
}

// When the user clicks anywhere outside the modal, close it
window.onclick = function(event) {
    if (event.target == modal1) {
        modal1.style.display = "none";
    }
}
