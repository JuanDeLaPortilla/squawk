let start = 0;
let working = false;

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "cuack?action=send&start=" + start + "&id=" + tagId,
        processData: false,
        contentType: "application/json",
        data: '',
        success: function (r) {
            printCuackArray(r);
        },
        error: function (jqXHR, exception) {
            printAjaxError(jqXHR, exception);
        }
    })
})

$(window).scroll(function () {
    if ($(this).scrollTop() + 1 >= $('body').height() - $(window).height()) {
        if (working === false) {
            working = true;
            $.ajax({
                type: "GET",
                url: "cuack?action=send&start=" + start + "&id=" + tagId,
                processData: false,
                contentType: "application/json",
                data: '',
                success: function (r) {
                    printCuackArray(r);
                    setTimeout(function () {
                        working = false;
                    }, 4000)
                },
                error: function (jqXHR, exception) {
                    printAjaxError(jqXHR, exception);
                }
            })
        }
    }
})
