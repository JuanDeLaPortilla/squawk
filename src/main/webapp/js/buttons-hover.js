jQuery(document).ready(function ($) {
    $('.comment').hover(
        function () {
            $(this).removeClass('fa-regular')
            $(this).addClass('fa-solid')
        },
        function () {
            $(this).removeClass('fa-solid')
            $(this).addClass('fa-regular')
        },
    )
});