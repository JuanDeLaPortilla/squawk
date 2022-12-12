let swiper = new Swiper(".mySwiper", {
    slidesPerView:5,
    spaceBetween:10,
    scrollbar: {
        el: ".swiper-scrollbar",
    },
    breakpoints:{
        960:{
            slidesPerView: 5,
            spaceBetween: 10,
        },
        720:{
            slidesPerView: 4,
            spaceBetween: 8,
        },
        540:{
            slidesPerView: 3,
            spaceBetween: 6,
        },
        320:{
            slidesPerView: 3,
            spaceBetween: 4,
        },
    }
});