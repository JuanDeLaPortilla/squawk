<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="feed">
    <div class="head">
        <div class="user">
            <a class="profile-photo" href="${pageContext.request.contextPath}/profile?id=${cuack.user.id}">
                <img class="profile-photo_img" src="${cuack.user.img}">
            </a>
            <div class="ingo">
                <div style="display: inline-flex; align-items: baseline; gap: 0.5rem">
                    <h3>${cuack.user.name}</h3>
                    <fmt:setLocale value="es"/>
                    <fmt:parseDate value="${cuack.creationDate}" type="date" pattern="yyyy-MM-dd"
                                   var="parsedCreationDate"/>
                    <fmt:formatDate value="${parsedCreationDate}" type="date" dateStyle="long" var="creationDate"/>
                    <small class="text-muted">(El ${creationDate})</small>
                </div>

                <h2>${cuack.title}</h2>
            </div>
        </div>
        <span class="edit">
            <i class="uil uil-ellipsis-h"></i>
        </span>
    </div>

    <div class="photo">
        <a class="photo_a" href="${cuack.url}" target="_blank">
            <img class="photo_img" src="${cuack.img}"/></a>
    </div>

    <div class="action-button">
        <div class="buttons-container">
            <div>
        <c:choose>
            <c:when test="${sessionScope.user.present}">

                    <span class="interaction-buttons_span"
                          onclick="doLike(${cuack.cuackID},${sessionScope.user.get().id})">
                        <c:choose>
                            <c:when test="${liked == 1}">
                                <i class="like fa-solid fa-thumbs-up"></i>
                            </c:when>
                            <c:otherwise>
                                <i class="like fa-regular fa-thumbs-up"></i>
                            </c:otherwise>
                        </c:choose>
                        <p>
                            <b>
                            <span class="like-counter"
                                  id="like-counter_${cuack.cuackID}">${likes}</span>
                            </b>Me gusta
                        </p>
                    </span>
                <span class="interaction-buttons_span"
                      onclick="doDislike(${cuack.cuackID},${sessionScope.user.get().id})">
                        <c:choose>
                            <c:when test="${disliked == 1}">
                                <i class="dislike fa-solid fa-thumbs-down"></i>
                            </c:when>
                            <c:otherwise>
                                <i class="dislike fa-regular fa-thumbs-down"></i>
                            </c:otherwise>
                        </c:choose>
                    <p>
                        <b>
                            <span class="dislike-counter"
                                  id="dislike-counter_${cuack.cuackID}">${dislikes}</span>
                        </b>No me gusta
                    </p>
                </span>
            </c:when>
            <c:otherwise>
                    <span onclick="sessionWarning()">
                        <i class="like fa-regular fa-thumbs-up"></i>
                    <p>
                        <b>
                            <span class="like-counter"
                                  id="like-counter_${cuack.cuackID}">${likes}</span>
                        </b>Me gusta
                    </p>
                    </span>
                <span onclick="sessionWarning()">
                        <i class="dislike fa-regular fa-thumbs-down"></i>
                    <p>
                        <b>
                            <span class="dislike-counter"
                                  id="dislike-counter_${cuack.cuackID}">${dislikes}</span>
                        </b>No me gusta
                    </p>
                </span>
            </c:otherwise>
        </c:choose>
            </div>
            <p class="text-muted"><b id="approval">${approval}</b> % de Aprobaci&oacute;n</p>
        </div>
    </div>


    <div class="caption">
        <p><b>${cuack.user.name}</b> ${cuack.content}
            <c:if test="${cuack.isEdited() == 1}">
                <b><i>&nbsp;(Editado)</i></b>
            </c:if>
            <a class="harsh-tag" href="${pageContext.request.contextPath}/cuack?action=viewByTag&id=${cuack.tag.tagID}"> <b>&nbsp;#${cuack.tag.desc}</b> </a></p>
    </div>
</div>