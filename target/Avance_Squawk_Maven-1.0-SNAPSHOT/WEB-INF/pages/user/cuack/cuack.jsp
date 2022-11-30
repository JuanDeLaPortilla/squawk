<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.cuack.title} | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Conexion con Iconos -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
    <script src="https://kit.fontawesome.com/69e84cf231.js" crossorigin="anonymous"></script>

    <!-- Conexion con CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?v=1.3"/>
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
</head>

<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/pages/user/commons/header.jsp"/>
<!-- MAIN -->
<main>
    <div class="container">
        <div></div>
        <!-- MIDDLE -->
        <div class="middle">

            <!-- CUACK -->
            <div class="feeds">
                <jsp:include page="/WEB-INF/pages/user/commons/feed.jsp"/>
            </div>
        </div>
        <div></div>
    </div>
</main>

<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/tab-form.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comment-hover.js"></script>
<script src="${pageContext.request.contextPath}/js/sessionWarning.js"></script>
<c:if test="${sessionScope.user.isPresent()}">
    <script src="${pageContext.request.contextPath}/js/like.js"></script>
    <script src="${pageContext.request.contextPath}/js/like-click.js"></script>
</c:if>

</body>
</html>
