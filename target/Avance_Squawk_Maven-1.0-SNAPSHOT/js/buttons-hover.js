jQuery(document).ready(function ($) {
    $('.comment').hover(
        function () {
            $(this).removeClass('fa-regular fa-comment-dots')
            $(this).addClass('fa-solid fa-comment-dots')
        },
        function () {
            $(this).removeClass('fa-solid fa-comment-dots')
            $(this).addClass('fa-regular fa-comment-dots')
        },
    )

    $('.like').hover(
        function () {
            $(this).removeClass('fa-regular fa-heart')
            $(this).addClass('fa-solid fa-heart')
        },
        function () {
            $(this).removeClass('fa-solid fa-heart')
            $(this).addClass('fa-regular fa-heart')
        },
    )
});