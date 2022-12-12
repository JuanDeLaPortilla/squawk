<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Dashboard | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
          rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.js"></script>
</head>

<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="commons/sidebar-header.jsp"/>
    <main>
        <div class="right"></div>
        <div class="heading">
            <h1 style="padding: 1rem 1rem 0">Dashboard</h1>
        </div>

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
        <div class="statistics">
            <h1>Estadisticas</h1>
            <div class="charts-container">
                <div class="charts">
                    <canvas id="users"></canvas>
                </div>
                <div class="charts">
                    <canvas id="cuacks"></canvas>
                </div>
            </div>
        </div>
    </main>
    <!-----------END OF MAIN--------->

    <div class="right">
        <jsp:include page="commons/profile-dark-mode.jsp"/>
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

<script src="${pageContext.request.contextPath}/assets/js/dashboard-side-menu.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajax-cuacks-count.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajax-users-count.js"></script>

</body>
</html>