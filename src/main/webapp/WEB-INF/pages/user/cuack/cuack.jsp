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
    <link rel="stylesheet" href="./css/style.css?v=1.2"/>
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

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/buttons-hover.js"></script>
<script src="${pageContext.request.contextPath}/js/like.js"></script>
<script src="${pageContext.request.contextPath}/js/sessionWarning.js"></script>
</body>
</html>
