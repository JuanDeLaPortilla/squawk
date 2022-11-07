<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard-Cuacks</title>
    <link rel="stylesheet" href="./css/a-style-listas.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
    rel="stylesheet"> 
</head>
<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>
    <main>
        <h1>Cuacks</h1>

        <!-- LIST CUACKS -->
        <jsp:include page="WEB-INF/pages/dashboard/cuacks/listCuacks.jsp"/>

        <!-- ADD CUACKS -->
        <jsp:include page="WEB-INF/pages/dashboard/cuacks/addCuack.jsp"/>
    </main>

    <!-- PROFILE AND DARK MODE-->
    <div class="right">
        <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
    </div>
</div>

<!-- Conexiones con Js -->
<script src="./js/dashboard-side-menu.js"></script>
<script src="./js/white-theme.js"></script>
<script src="./js/modal-button.js?v=3"></script>
</body>
</html>