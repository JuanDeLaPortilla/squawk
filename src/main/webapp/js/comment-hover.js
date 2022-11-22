jQuery(document).ready(function ($) {
    $('.comment').hover(
        function () {
            $(this).removeClass('uil uil-comment-dots')
            $(this).addClass('uis uis-comment-dots')
            $(this).css("font-size","1.9rem")
        },
        function () {
            $(this).removeClass('uis uis-comment-dots')
            $(this).addClass('uil uil-comment-dots')
            $(this).css("font-size","1.4rem")
        },
    )
});