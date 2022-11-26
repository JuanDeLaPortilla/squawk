<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Cuacks</title>
    <!-- Conexiones con CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/a-style-listas.css?v=11">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="../commons/sidebar-header.jsp"/>
    <main>
        <div class="inline-centered">
        <!-- EDIT USER FORM -->
        <jsp:include page="./editCuackForm.jsp"/>
        <!-- EDIT USER PROFILE FORM -->
        <jsp:include page="./editCuackPictureForm.jsp"/>
        </div>
    </main>

    <!-- PROFILE AND DARK MODE-->
    <div class="right">
        <jsp:include page="../commons/profile-dark-mode.jsp"/>
    </div>
</div>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/dashboard-side-menu.js"></script>
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/preview-image.js"></script>
</body>
</html>