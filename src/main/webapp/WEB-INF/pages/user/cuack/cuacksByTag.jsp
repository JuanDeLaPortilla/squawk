<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <!-- Conexion con Iconos -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/solid.css">
    <script src="https://kit.fontawesome.com/69e84cf231.js" crossorigin="anonymous"></script>
    <!-- Conexion con CSS -->
    <link rel="stylesheet" href="./css/style.css?v=5.391"/>
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

            <!-- FEEDS -->
            <div class="feeds" id="feeds">
                <h1 style="padding: 0 1rem">Cuacks de la Categoria ${requestScope.tag.desc}</h1>
            </div>
        </div>
        <div></div>
    </div>
</main>

<!-- SIGNUP + LOGIN FORM TAB-->
<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp" %>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button.js"></script>
<script src="${pageContext.request.contextPath}/js/tab-form.js"></script>
<script src="${pageContext.request.contextPath}/js/sessionWarning.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/js/create-dynamic-cuack.js?v=1"></script>
<script>
    const tagId = ${requestScope.tag.tagID};
</script>
<script src="${pageContext.request.contextPath}/js/ajax-cuacks-by-tag.js?v=1"></script>
</body>
</html>
