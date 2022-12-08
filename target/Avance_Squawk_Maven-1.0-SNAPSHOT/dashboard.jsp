<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard | Squawk!</title>
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
    <link rel="stylesheet" href="./css/a-style.css?v=1">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
          rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.js"></script>
</head>
<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>
    <main>
        <h1>Dashboard</h1>

        <div class="insights">
            <div class="sales">
                <span class="material-icons-sharp">markunread_mailbox</span>
                <div class="middle">
                    <div class="left">
                        <h3>Cuacks Publicados Durante el Mes</h3>
                        <h1>${requestScope.cuacks}</h1>
                    </div>
                </div>
            </div>
            <!-----END OF SALES-------->
            <div class="expenses">
                <span class="material-icons-sharp">group</span>
                <div class="middle">
                    <div class="left">
                        <h3>Usuarios Registrados Durante el Mes</h3>
                        <h1>${requestScope.usuariosRegistrados}</h1>
                    </div>
                </div>
            </div>
            <!-----END OF EXPENSES-------->
            <div class="income">
                <span class="material-icons-sharp">workspace_premium</span>
                <div class="middle">
                    <div class="left">
                        <h3>Usuarios Activos Actualmente</h3>
                        <h1>${requestScope.usuariosActivos} - ${requestScope.porcentage}%</h1>
                    </div>
                </div>
            </div>
            <!-----END OF INCOME-------->
        </div>
        <!-----END OF INSIGHTS-------->

        <div class="recent-orders">
            <h2>Estadisticas</h2>
            <div>
                <canvas id="users"></canvas>
                <canvas id="cuacks"></canvas>
            </div>
        </div>
    </main>
    <!-----------END OF MAIN--------->

    <div class="right">
        <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
        <!----------END OF TOP---------->
        <div class="recent-updates">
            <h2>Miembros de Squawk!</h2>
            <div class="updates">
                <c:forEach items="${requestScope.staff}" var="p">
                    <div class="update">
                        <div class="profile-photo">
                            <img src="${p.img}">
                        </div>
                        <div class="message">
                            <p>${p.name}</p>
                            <small class="text-muted">${p.email}</small>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/dashboard-side-menu.js"></script>
<script src="./js/users.js?v=1"></script>
<script src="./js/white-theme.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/js/ajax-cuacks-count.js?v=2"></script>
<script src="${pageContext.request.contextPath}/js/ajax-users-count.js?v=2"></script>

</body>
</html>