<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="top-cuacks">
    <h1>Cuacks En Tendencia</h1>

    <c:choose>
        <c:when test="${!requestScope.stories.isEmpty()}">
            <div class="swiper-container mySwiper" style="overflow: hidden">
                <div class="stories swiper-wrapper">
                    <c:forEach items="${requestScope.stories}" end="5" var="c">
                        <a class="story swiper-slide" href="${pageContext.request.contextPath}/cuack?id=${c.cuackID}"
                           style="background: url('${c.img}') no-repeat center center/cover">
                            <div class="profile-photo">
                                <img src="${c.user.img}"/>
                            </div>
                            <p class="name">${c.user.name}</p>
                        </a>
                    </c:forEach>
                </div>
                <div class="swiper-scrollbar"></div>
            </div>
        </c:when>
        <c:otherwise>
            <div style="display: flex; align-items: center; flex-direction: column; gap: 0.5rem">
                <img style="max-height: 10rem; width: auto;"
                     src="${pageContext.request.contextPath}/images/error_duck_purple.png">
                <p>
                    &iexcl;Vaya no hay ning&uacute;n cuack en tendencia!
                    <c:if test="${sessionScope.user.present}">
                        &nbsp;&iexcl;S&eacute; el primero en crear uno!
                    </c:if>
                </p>
            </div>
        </c:otherwise>
    </c:choose>
</div>

