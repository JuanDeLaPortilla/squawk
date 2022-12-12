<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios | Squawk!</title>
    <!-- Conexiones con CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/a-style-listas.css?v=1.76">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple-datatables.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
</head>
<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>

    <main>
        <!-- PROFILE AND DARK MODE-->
        <div class="right">
            <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
        </div>

        <div class="heading">
            <h1>Usuarios</h1>
            <!-- ADD USER BUTTON-->
            <div class="right" style="margin: 0 !important; width: auto !important;">
                <div class="sales-analytics" style="margin: 0 !important;">
                    <div class="item add-product">
                        <div id="modalBtn">
                            <span class="material-icons-sharp">add</span>
                            <h3>A&ntilde;adir Usuario</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- LIST USERS -->
        <%@include file="WEB-INF/pages/dashboard/users/listUsers.jsp" %>

    </main>
</div>

<!-- ADD USERS -->
<jsp:include page="WEB-INF/pages/dashboard/users/addUser.jsp"/>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/dashboard-side-menu.js"></script>
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button.js?v=3"></script>
<script src="${pageContext.request.contextPath}/js/simple-datatables.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js?v=1.3"></script>

</body>
</html>