<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Squawk! - Home</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Conexion con Iconos -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
    <!-- Conexcion con CSS -->
<<<<<<< HEAD
    <link rel="stylesheet" href="./css/style.css?v=15.1"/>
=======
    <link rel="stylesheet" href="./css/style.css?v=15"/>
>>>>>>> 19c5f7f (changed name to some methods)
</head>
<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/pages/user/commons/header.jsp"/>
<!-- MAIN -->
<main>
    <div class="container two-rows">
        <div></div>
        <!-- MIDDLE -->
        <div class="middle second">
            <div class="submit-cuack">

                <div class="heading">
                    <h4>Cuacks publicados</h4>
                </div>

                <!-- USER FEEDS -->
                <jsp:include page="/WEB-INF/pages/user/feeds.jsp"/>
            </div>
        </div>
        <!-- RIGHT -->
        <jsp:include page="/WEB-INF/pages/user/profile_info.jsp"/>
    </div>
</main>

<jsp:include page="/WEB-INF/pages/user/update_form.jsp"/>
<jsp:include page="/WEB-INF/pages/user/profile_picture_form.jsp"/>

<script src="./js/white-theme.js"></script>
<script src="./js/modal-button.js"></script>
<script src="./js/modal-button-1.js"></script>
<script src="./js/preview-image.js?v=6"></script>
</body>
</html>
