let start = 0;
let working = false;

$(document).ready(function () {
    if (logged === 0) {//si no ha iniciado sesion
        $.ajax({
            type: "GET",
            url: "index?action=send&start=" + start + "&logged=" + logged,
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
    } else {
        if (logged === 1) {
            $.ajax({
                type: "GET",
                url: "index?action=send&start=" + start + "&logged=" + logged + "&id=" + id,
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
        }
    }
})

$(window).scroll(function () {
    if ($(this).scrollTop() + 1 >= $('body').height() - $(window).height()) {
        if (working === false) {
            working = true;
            if (logged === 0) {
                $.ajax({
                    type: "GET",
                    url: "index?action=send&start=" + start + "&logged=" + logged,
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
            } else {
                if (logged === 1) {
                    $.ajax({
                        type: "GET",
                        url: "index?action=send&start=" + start + "&logged=" + logged + "&id=" + id,
                        processData: false,
                        contentType: "application/json",
                        data: '',
                        success: function (r) {
                            printCuackArray(r);
                            setTimeout(function () {
                                working = false;
                            }, 2000)
                        },
                        error: function (jqXHR, exception) {
                            printAjaxError(jqXHR, exception);
                        }
                    })
                }
            }
        }
    }
})
