<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="feed">
    <div class="head">
        <div class="user">
            <a class="profile-photo" href="${pageContext.request.contextPath}/profile?id=${cuack.user.id}">
                <img src="${cuack.user.img}">
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
        <a href="${cuack.url}" target="_blank"><img src="${cuack.img}"/></a>
    </div>

    <div class="action-button">
        <div class="interaction-buttons">
            <c:choose>
                <c:when test="${sessionScope.user.present}">
                    <span onclick="doLike(${cuack.cuackID},${sessionScope.user.get().id})">
                        <c:choose>
                            <c:when test="${cuack.liked == 1}">
                                <i class="like fa-solid fa-heart"></i>
                            </c:when>
                            <c:otherwise>
                                <i class="like fa-regular fa-heart"></i>
                            </c:otherwise>
                        </c:choose>
                    </span>
                </c:when>
                <c:otherwise>
                    <span onclick="sessionWarning()"><i class="like fa-regular fa-heart"></i></span>
                </c:otherwise>
            </c:choose>

            <a href="${pageContext.request.contextPath}/cuack?id=${cuack.cuackID}"><span><i
                    class="comment fa-regular fa-comment-dots"></i></span></a>
        </div>
    </div>

    <p style="margin-bottom: 0.5rem"><b><span id="like-counter_${cuack.cuackID}">${cuack.likes}</span></b> Me gusta</p>

    <div class="caption">
        <p><b>${cuack.user.name}</b> ${cuack.content}
            <c:if test="${cuack.isEdited() == 1}">
                <b><i>&nbsp;(Editado)</i></b>
            </c:if>
            <span class="harsh-tag"> <b>&nbsp;#${cuack.tag.desc}</b> </span></p>
    </div>
</div>