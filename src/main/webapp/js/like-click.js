$(document).on("click", ".like", function () {
    if ($(this).hasClass('fa-regular')) {
        $(this).removeClass('fa-regular')
        $(this).addClass('fa-solid')
        if ($('.dislike').hasClass('fa-solid')) {
            $(this).removeClass('fa-solid')
            $(this).addClass('fa-regular')
        }
    } else {
        $(this).removeClass('fa-solid')
        $(this).addClass('fa-regular')
    }
});

$(document).on("click", ".dislike", function () {
    if ($(this).hasClass('fa-regular')) {
        $(this).removeClass('fa-regular')
        $(this).addClass('fa-solid')
        if ($('.like').hasClass('fa-solid')) {
            $(this).removeClass('fa-solid')
            $(this).addClass('fa-regular')
        }
    } else {
        $(this).removeClass('fa-solid')
        $(this).addClass('fa-regular')
    }
});