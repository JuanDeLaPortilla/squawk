function doLike(cuackId,userId){
    const d = {
        userId: userId,
        cuackId: cuackId,
        action: 'likeCuack'
    }

    $.ajax({
        url: 'LikeServlet',
        data: d,
        type: "GET",
        success: function (response){
            let id = "#like-counter_"+d.cuackId
            let c = $(id).html();
            if(response.trim() === "true&1"){
                c++;
            }else{
                if (response.trim() === "true&0"){
                    c--;
                }
            }
            $(id).html(c);
        },
        error: function (jqXHR, exception){
            let msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status === 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status === 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            console.log(msg)
            console.log(jqXHR)
        }
    })
}