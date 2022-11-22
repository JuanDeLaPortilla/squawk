<div class="feeds">
    <div class="feed">
        <div class="head">
            <div class="user">
                <a class="profile-photo"
                   href="${pageContext.request.contextPath}/profile?id=${cuack.user.id}">
                    <img src="${cuack.user.img}">
                </a>
                <div class="ingo">
                    <h3>${cuack.user.name}</h3>
                    <h2>${cuack.title}</h2>
                </div>
            </div>
            <span class="edit">
                <i class="uil uil-ellipsis-h"></i>
            </span>
        </div>

        <div class="photo">
            <a href="${cuack.url}" target="_blank"><img src="${cuack.img}"/></a>
        </div>

        <div class="action-button">
            <div class="interaction-buttons">
                <span><i class="uil uil-heart"></i></span>
                <span><i class="uil uil-comment-dots"></i></span>
            </div>
        </div>

        <div class="caption">
            <p><b>${cuack.user.name}</b> ${cuack.content}
                <span class="harsh-tag"> <b> #${cuack.tag.desc}</b> </span></p>
        </div>
    </div>
</div>