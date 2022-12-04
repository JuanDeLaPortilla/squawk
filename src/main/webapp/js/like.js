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
            let likeId = "#like-counter_" + d.cuackId;
            let dislikeId = "#dislike-counter_" + d.cuackId;
            let likeCounter = $(likeId).html();
            let dislikeCounter = $(dislikeId).html();
            if (response.trim() === "true&0true&1") {
                dislikeCounter--;
                likeCounter++;
            } else {
                if (response.trim() === "true&0") {
                    likeCounter--;
                }else{
                    if(response.trim() === "true&1"){
                        likeCounter++;
                    }
                }
            }
            $(likeId).html(likeCounter);
            $(dislikeId).html(dislikeCounter);
        },
        error: function (jqXHR, exception) {
            printAjaxError(jqXHR, exception);
        }
    })
}

function doDislike(cuackId, userId) {
    const d = {
        userId: userId,
        cuackId: cuackId,
        action: 'dislikeCuack'
    }

    $.ajax({
        url: 'LikeServlet',
        data: d,
        type: "GET",
        success: function (response) {
            let likeId = "#like-counter_" + d.cuackId;
            let dislikeId = "#dislike-counter_" + d.cuackId;
            let likeCounter = $(likeId).html();
            let dislikeCounter = $(dislikeId).html();
            if (response.trim() === "true&0true&1") {
                likeCounter--;
                dislikeCounter++;
            } else {
                if (response.trim() === "true&0") {
                    dislikeCounter--;
                }else{
                    if(response.trim() === "true&1"){
                        dislikeCounter++;
                    }
                }
            }
            $(likeId).html(likeCounter);
            $(dislikeId).html(dislikeCounter);
        },
        error: function (jqXHR, exception) {
            printAjaxError(jqXHR, exception);
        }
    })
}