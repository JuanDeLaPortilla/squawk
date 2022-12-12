<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="feeds">
    <c:choose>
        <c:when test="${!requestScope.cuacks.isEmpty()}">
            <c:forEach items="${requestScope.cuacks}" var="cuack">
                <%@include file="/WEB-INF/pages/user/commons/feed.jsp"%>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="feed">
                <div class="photo">
                    <img style="max-height: 10rem"
                         src="${pageContext.request.contextPath}/images/error_duck_purple.png">
                    <c:choose>
                        <c:when test="${sessionScope.user.get().id != requestScope.user.id}">
                            <p style="font-size: medium; margin-top: 1rem;"><b>&iexcl;${requestScope.user.name}</b> no
                                ha
                                creado ning&uacute;n cuack todav&iacute;a!</p>
                        </c:when>
                        <c:otherwise>
                            <p style="font-size: medium; margin-top: 1rem;">&iexcl;No has creado ning&uacute;n cuack
                                todav&iacute;a!</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>