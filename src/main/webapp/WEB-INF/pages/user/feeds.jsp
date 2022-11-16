<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="feeds">
    <c:forEach items="${cuacks}" var="c">
        <div class="feed">
            <div class="head">
                <div class="user">
                    <div class="profile-photo">
                        <img src="${c.user.img}">
                    </div>
                    <div class="ingo">
                        <h3>${c.user.name}</h3>
                        <h2>${c.title}</h2>
                    </div>
                </div>
                <span class="edit">
                    <i class="uil uil-ellipsis-h"></i>
                </span>
            </div>

            <div class="photo">
                <a href="${c.url}" target="_blank"><img src="${c.img}"/></a>
            </div>

            <div class="action-button">
                <div class="interaction-buttons">
                    <span><i class="uil uil-heart"></i></span>
                    <span><i class="uil uil-comment-dots"></i></span>
                    <span><i class="uil uil-share-alt"></i></span>
                </div>
            </div>

            <div class="caption">
                <p><b>${c.user.name}</b> ${c.content}
                    <span class="harsh-tag"> <b> #${c.tag.desc}</b> </span></p>
            </div>
            <div class="comments text-muted">
                Mira todos los <b>277</b> comentarios
            </div>
        </div>
    </c:forEach>
</div>