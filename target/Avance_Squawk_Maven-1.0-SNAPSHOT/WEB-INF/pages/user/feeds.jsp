<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="feeds">
    <c:choose>
        <c:when test="${!requestScope.cuacks.isEmpty()}">
            <c:forEach items="${requestScope.cuacks}" var="c">
                <div class="feed">
                    <div class="head">
                        <div class="user">
                            <a class="profile-photo" href="${pageContext.request.contextPath}/profile?id=${c.user.id}">
                                <img src="${c.user.img}">
                            </a>
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
                            <a href="${pageContext.request.contextPath}/cuack?id=${c.cuackID}"><span><i class="comment uil uil-comment-dots"></i></span></a>
                        </div>
                    </div>

                    <div class="caption">
                        <p><b>${c.user.name}</b> ${c.content}
                            <span class="harsh-tag"> <b> #${c.tag.desc}</b> </span></p>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="feed">
                <div class="photo">
                    <img style="max-height: 10rem"
                         src="${pageContext.request.contextPath}/images/error_duck_purple.png">
                    <c:choose>
                        <c:when test="${sessionScope.user.get().id != requestScope.user.id}">
                            <p style="font-size: medium; margin-top: 1rem;"><b>&iexcl;${requestScope.user.name}</b> no ha
                                creado ning&uacute;n cuack todav&iacute;a!</p>
                        </c:when>
                        <c:otherwise>
                            <p style="font-size: medium; margin-top: 1rem;">&iexcl;No has creado ning&uacute;n cuack todav&iacute;a!</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>