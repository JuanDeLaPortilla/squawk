const tab = document.querySelector(".tab-form");
const tabHeader = tab.querySelector(".tab-header");
const tabHeaderElements = tab.querySelectorAll(".tab-header > div");
const tabBody = document.querySelector(".tab-body");
const tabBodyElements = tab.querySelectorAll(".tab-body > div")

for(let i=0;i<tabHeaderElements.length;i++){
    tabHeaderElements[i].addEventListener("click",function (){
        tabHeader.querySelector(".active").classList.remove("active");
        tabHeaderElements[i].classList.add("active");
        tabBody.querySelector(".active").classList.remove("active");
        tabBodyElements[i].classList.add("active");
    });
}
