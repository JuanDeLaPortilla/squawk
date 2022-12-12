<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.cuack.title} | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <%@include file="/WEB-INF/pages/user/commons/head-imports.jsp"%>
</head>

<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/pages/user/commons/header.jsp"/>
<!-- MAIN -->
<main>
    <div class="container two-rows">
        <div></div>
        <!-- MIDDLE -->
        <div class="middle">
            <div class="submit-cuack">
                <!-- CUACK -->
                <div class="feeds">
                    <jsp:include page="/WEB-INF/pages/user/commons/feed.jsp"/>
                </div>
            </div>
        </div>
        <!-- RIGHT -->
        <div class="right">
            <div class="profile-info">
                <jsp:include page="/WEB-INF/pages/user/cuack/disqus_comment_section.jsp"/>
            </div>
        </div>
    </div>
</main>

<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/comment-hover.js"></script>
<c:choose>
    <c:when test="${sessionScope.user.isPresent()}">
        <script src="${pageContext.request.contextPath}/assets/js/like.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/like-click.js"></script>
    </c:when>
    <c:otherwise>
        <script src="${pageContext.request.contextPath}/assets/js/modal-button.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/tab-form.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sessionWarning.js"></script>
    </c:otherwise>
</c:choose>
<script id="dsq-count-scr" src="//squawk-1.disqus.com/count.js" async></script>

</body>
</html>
