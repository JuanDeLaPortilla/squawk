<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.user.name} | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Conexion con Iconos -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
    <!-- Conexcion con CSS -->
    <link rel="stylesheet" href="./css/style.css?v=15.42"/>
    <script src="https://kit.fontawesome.com/69e84cf231.js" crossorigin="anonymous"></script>
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
</head>
<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/pages/user/commons/header.jsp"/>
<!-- MAIN -->
<main>
    <div class="container two-rows">
        <div></div>
        <!-- MIDDLE -->
        <div class="middle second">
            <div class="submit-cuack">

                <div class="heading">
                    <h4>Cuacks publicados</h4>
                </div>

                <!-- USER FEEDS -->
                <div class="feeds" id="feeds"></div>
            </div>
        </div>
        <!-- RIGHT -->
        <jsp:include page="/WEB-INF/pages/user/profile/profile_info.jsp"/>
    </div>
</main>

<c:choose>
    <c:when test="${sessionScope.user.isPresent()}">
        <jsp:include page="/WEB-INF/pages/user/profile/update_form.jsp"/>
        <jsp:include page="/WEB-INF/pages/user/profile/profile_picture_form.jsp"/>
        <script>
            const logged = 1;
            const id = ${requestScope.user.id};
            const sessionId = ${sessionScope.user.get().id};
        </script>
    </c:when>
    <c:otherwise>
        <!-- SIGNUP + LOGIN FORM TAB-->
        <jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>
        <script>
            const logged = 0;
            const id = ${requestScope.user.id};
        </script>
    </c:otherwise>
</c:choose>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp"%>

<!-- Conexiones Js -->
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/tab-form.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button-1.js"></script>
<script src="${pageContext.request.contextPath}/js/preview-image.js?v=6"></script>
<script src="${pageContext.request.contextPath}/js/sessionWarning.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/js/create-dynamic-cuack.js"></script>
<script src="${pageContext.request.contextPath}/js/ajax-profile.js?v=1"></script>
<script src="${pageContext.request.contextPath}/js/comment-hover.js"></script>
<c:if test="${sessionScope.user.isPresent()}">
    <script src="${pageContext.request.contextPath}/js/like.js"></script>
    <script src="${pageContext.request.contextPath}/js/like-click.js"></script>
</c:if>

</body>
</html>
