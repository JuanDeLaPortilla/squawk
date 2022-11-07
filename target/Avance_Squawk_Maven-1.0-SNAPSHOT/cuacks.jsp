<<<<<<< HEAD
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

>>>>>>> 19c5f7f (changed name to some methods)
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard-Cuacks</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="./css/a-style-listas.css?v=1">
=======
    <link rel="stylesheet" href="./css/a-style-listas.css">
>>>>>>> 19c5f7f (changed name to some methods)
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
    rel="stylesheet"> 
</head>
<body>
<<<<<<< HEAD
    <div class="container">
        <!-- SIDEBAR AND HEADER -->
        <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>

        <main>
            <h1>Cuacks</h1>

            <div class="recent-orders">
                <h2>Lista de Cuacks</h2>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th>Correo</th>
                            <th>Tag</th>
                            <th>URL</th>
                            <th>Calificaci&oacute;n</th>
                            <th>Estado</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--
                        <tr>
                            <td>Foldable Mini Drone</td>
                            <td>85631</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                    </tbody>
                        -->
                        
                </table>
            </div>
            
            <div class="right">
                <div class="sales-analytics">
                    <div class="item add-product">
                        <div>
                            <span class="material-icons-sharp">add</span>
                            <h3>A&ntilde;adir Cuack</h3>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        
        <!-----------EN OF MAIN--------->

        <div class="right">
            <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
        </div>
    </div>

    <script src="./js/cuacks.js"></script>
    <script src="./js/a-cuacks.js"></script>
    <script src="./js/white-theme.js"></script>
=======
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
>>>>>>> 19c5f7f (changed name to some methods)
</body>
</html>