<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard-Tags</title>
    <link rel="stylesheet" href="./css/a-style-listas.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
    rel="stylesheet"> 
</head>
<body>
    <div class="container">
        <!-- SIDEBAR AND HEADER -->
        <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>

        <main>
            <h1>Tags</h1>

            <div class="recent-orders">
                <h2>Lista de Tags</h2>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descripci&oacute;n</th>
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
                            <h3>A&ntilde;adir Tag</h3>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-----------EN OF MAIN--------->

        <!-- PROFILE AND DARK MODE-->
        <div class="right">
            <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
        </div>
    </div>

    <script src="./js/tags.js"></script>
    <script src="./js/a-tags.js"></script>
    <script src="./js/white-theme.js"></script>
</body>
</html>