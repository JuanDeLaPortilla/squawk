<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Conexion con Iconos -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/solid.css">
    <script src="https://kit.fontawesome.com/69e84cf231.js" crossorigin="anonymous"></script>

    <!-- Conexion con CSS -->
    <link rel="stylesheet" href="./css/style.css?v=5.17"/>
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

            <!-- LAST CUACKS -->
            <h1 style="margin: 1rem 0">Cuacks En Tendencia</h1>
            <jsp:include page="/WEB-INF/pages/user/stories.jsp"/>
            <!-- CREATE CUACK -->
            <c:if test="${sessionScope.user.present}">
                <a class="create-post" href="${pageContext.request.contextPath}/submit">
                    <div class="profile-photo">
                        <c:choose>
                            <c:when test="${sessionScope.user.present}">
                                <img src="${sessionScope.user.get().img}"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/profile_pictures/default.webp"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <p class="text-muted">&iexcl;Crea un cuack ahora!</p>
                    <label class="btn btn-primary">Crear</label>
                </a>
            </c:if>
            <!-- FEEDS -->
            <jsp:include page="/WEB-INF/pages/user/feeds.jsp"/>
        </div>
        <div></div>
    </div>
</main>

<!-- SIGNUP + LOGIN FORM TAB-->
<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- Conexiones con Js -->
<script src="./js/white-theme.js"></script>
<script src="./js/modal-button.js"></script>
<script src="./js/tab-form.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="./js/buttons-hover.js"></script>
<script src="./js/like.js"></script>
<script src="${pageContext.request.contextPath}/js/like-click.js"></script>
<script src="${pageContext.request.contextPath}/js/sessionWarning.js"></script>

</body>
</html>
