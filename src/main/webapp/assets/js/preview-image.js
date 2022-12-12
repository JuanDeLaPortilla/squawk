const inpFile = document.getElementById("inpFile");
const previewContainer = document.getElementById("imagePreview");
const previewImage = previewContainer.querySelector("img");
const previewDefaultText = previewContainer.querySelector(".default-text");

inpFile.addEventListener("change", function (){
    const file = document.querySelector("input[type=file]").files[0];

    if (file) {
        const reader = new FileReader();

        previewContainer.style.border = "none";
        previewDefaultText.style.display = "none";
        previewImage.style.display = "block";

        reader.addEventListener("load",function (){
            previewImage.setAttribute("src", this.result);
        });

        reader.readAsDataURL(file);
    }else{
        previewContainer.style.border = null;
        previewDefaultText.style.display = null;
        previewImage.style.display = null;
    }
});