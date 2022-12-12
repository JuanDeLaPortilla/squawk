<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Editar Tag | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Conexiones con CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
</head>

<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="../commons/sidebar-header.jsp"/>
    <main style="padding: 0 !important;">
        <!-- PROFILE AND DARK MODE-->
        <div class="right">
            <jsp:include page="../commons/profile-dark-mode.jsp"/>
        </div>

        <!-- EDIT TAG FORM -->
        <jsp:include page="./editTagForm.jsp?v=2"/>
    </main>

</div>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/assets/js/dashboard-side-menu.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>

</body>
</html>