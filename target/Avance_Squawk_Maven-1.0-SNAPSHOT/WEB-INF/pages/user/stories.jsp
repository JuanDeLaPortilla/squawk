<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="stories">
    <c:forEach items="${requestScope.stories}" end="5" var="c">
        <div class="story" style="background: url('${c.img}') no-repeat center center/cover">
            <div class="profile-photo">
                <img src="${c.user.img}"/>
            </div>
            <p class="name">${c.user.name}</p>
        </div>
    </c:forEach>
</div>

