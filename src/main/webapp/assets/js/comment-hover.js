$(document).on("mouseenter",".comment",function (){
    $(this).removeClass('fa-regular')
    $(this).addClass('fa-solid')
});

$(document).on("mouseleave",".comment",function (){
    $(this).removeClass('fa-solid')
    $(this).addClass('fa-regular')
});