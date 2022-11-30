let start = 0;
let working = false;
const feeds = document.getElementById('feeds');
const templateCuack = document.getElementById('template_cuack').content;
const fragment = document.createDocumentFragment();

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

function printCuackArray(r) {
    r = JSON.parse(r)
    for (let i = 0; i < r.length; i++) {
        printCuack(r, i);
    }
    feeds.appendChild(fragment);
    start += 5;
}

function printCuack(r, i) {
    let date = "";
    date = getLongDate(r, i, date);
    templateCuack.querySelector('.profile-photo').setAttribute("href", "./profile?id=" + r[i].user.id);
    templateCuack.querySelector('.profile-photo_img').setAttribute("src", r[i].user.img);
    templateCuack.querySelector('h3').textContent = r[i].user.name;
    templateCuack.querySelector('.text-muted').textContent = date;
    templateCuack.querySelector('h2').textContent = r[i].title;
    templateCuack.querySelector('.photo_a').setAttribute("href", r[i].url);
    templateCuack.querySelector('.photo_img').setAttribute("src", r[i].img);
    if (logged === 1) {
        templateCuack.querySelector('.interaction-buttons_span').setAttribute("onclick", "doLike(" + r[i].cuackID + "," + id + ")")
        if (r[i].liked === 1) {
            templateCuack.querySelector('.like').classList.remove('fa-regular');
            templateCuack.querySelector('.like').classList.add('fa-solid');
        }
    } else {
        templateCuack.querySelector('.interaction-buttons_span').setAttribute("onclick", "sessionWarning()");
    }
    templateCuack.querySelector('.comment_a').setAttribute("href", "./cuack?id=" + r[i].cuackID);
    templateCuack.querySelector('.like-counter').setAttribute("id","like-counter_" + r[i].cuackID);
    templateCuack.querySelector('.like-counter').textContent = r[i].likes;
    templateCuack.querySelector('.cuack-author').textContent = r[i].user.name;
    templateCuack.querySelector('.cuack-content').textContent = r[i].content;
    if (r[i].isEdited === 1) {
        templateCuack.querySelector('.cuack-edited').textContent = "(Editado)";
    }
    templateCuack.querySelector('.tag').textContent = "#" + r[i].tag.desc;

    const clone = templateCuack.cloneNode(true);
    fragment.appendChild(clone);
}

function getLongDate(r, i, date) {
    switch (r[i].creationDate.date.month) {
        case 1:
            date = "(El " + r[i].creationDate.date.day + " de enero de " + r[i].creationDate.date.year + ")";
            break;
        case 2:
            date = "(El " + r[i].creationDate.date.day + " de febrero de " + r[i].creationDate.date.year + ")";
            break;
        case 3:
            date = "(El " + r[i].creationDate.date.day + " de marzo de " + r[i].creationDate.date.year + ")";
            break;
        case 4:
            date = "(El " + r[i].creationDate.date.day + " de abril de " + r[i].creationDate.date.year + ")";
            break;
        case 5:
            date = "(El " + r[i].creationDate.date.day + " de mayo de " + r[i].creationDate.date.year + ")";
            break;
        case 6:
            date = "(El " + r[i].creationDate.date.day + " de junio de " + r[i].creationDate.date.year + ")";
            break;
        case 7:
            date = "(El " + r[i].creationDate.date.day + " de julio de " + r[i].creationDate.date.year + ")";
            break;
        case 8:
            date = "(El " + r[i].creationDate.date.day + " de agosto de " + r[i].creationDate.date.year + ")";
            break;
        case 9:
            date = "(El " + r[i].creationDate.date.day + " de setiembre de " + r[i].creationDate.date.year + ")";
            break;
        case 10:
            date = "(El " + r[i].creationDate.date.day + " de octubre de " + r[i].creationDate.date.year + ")";
            break;
        case 11:
            date = "(El " + r[i].creationDate.date.day + " de noviembre de " + r[i].creationDate.date.year + ")";
            break;
        case 12:
            date = "(El " + r[i].creationDate.date.day + " de diciembre de " + r[i].creationDate.date.year + ")";
            break;
    }
    return date;
}