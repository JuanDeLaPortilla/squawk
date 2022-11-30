function doLike(cuackId, userId) {
    const d = {
        userId: userId,
        cuackId: cuackId,
        action: 'likeCuack'
    }

    $.ajax({
        url: 'LikeServlet',
        data: d,
        type: "GET",
        success: function (response) {
            let id = "#like-counter_" + d.cuackId
            let c = $(id).html();
            if (response.trim() === "true&1") {
                c++;
            } else {
                if (response.trim() === "true&0") {
                    c--;
                }
            }
            $(id).html(c);
        },
        error: function (jqXHR, exception) {
            printAjaxError(jqXHR, exception);
        }
    })
}