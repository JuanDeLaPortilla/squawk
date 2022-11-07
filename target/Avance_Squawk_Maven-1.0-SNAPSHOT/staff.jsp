<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard-Staff</title>
    <link rel="stylesheet" href="./css/a-style-listas.css?v=1">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- SIDEBAR AND HEADER -->
    <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>

    <main>
        <h1>Staff</h1>

        <div class="recent-orders">
            <h2>Lista de Administradores</h2>
            <table>
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Cumplea&ntilde;os</th>
                    <th>Fotograf&iacute;a</th>
                    <th>Estado</th>
                    <th>Fecha de Creaci&oacute;n</th>
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
    </main>
    <!-----------EN OF MAIN--------->

    <div class="right">
        <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
    </div>
</div>

<script src="./js/users.js"></script>
<script src="./js/a-admin.js"></script>
<script src="./js/white-theme.js"></script>
</body>
</html>