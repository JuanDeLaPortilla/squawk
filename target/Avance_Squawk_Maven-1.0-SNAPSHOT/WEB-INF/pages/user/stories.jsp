<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="stories">
    <c:choose>
    <c:when test="${!requestScope.tc.isEmpty()}">

    <c:forEach items="${requestScope.tc}" var="tc">
        <div class="story" style="background: url('${tc.img}') no-repeat center center/cover">
            <div class="profile-photo">
                <img src="${tc.user.img}"/>
            </div>
            <p class="name">${tc.user.name}</p>
        </div>
    </c:forEach>
    </c:when>
        <c:otherwise>
            <div class="story">
                <div class="profile-photo">
                    <img src=""/>
                </div>
                <p class="name">:(</p>
            </div>
        </c:otherwise>
    </c:choose>
</div>