$(document).on("click",".like",function (){
    if ($(this).hasClass('fa-regular')) {
        $(this).removeClass('fa-regular')
        $(this).addClass('fa-solid')
    } else {
        $(this).removeClass('fa-solid')
        $(this).addClass('fa-regular')
    }
});
