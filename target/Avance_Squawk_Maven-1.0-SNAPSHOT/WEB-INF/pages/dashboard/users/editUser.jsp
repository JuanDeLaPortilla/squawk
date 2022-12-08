<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Usuarios</title>
    <!-- Conexiones con CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/a-style-listas.css?v=12.98">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css"/>
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

        <div class="inline-centered">
            <!-- CUACKS -->
            <div class="middle second">
                <div class="submit-cuack">

                    <div class="heading">
                        <h4 style="font-size: x-large !important;">Cuacks publicados</h4>
                    </div>

                    <!-- USER FEEDS -->
                    <div class="feeds" id="feeds"></div>
                </div>
            </div>
            <!-- USER PROFILE INFO -->
            <jsp:include page="userProfileInfo.jsp"/>
        </div>
    </main>

</div>

<!-- EDIT USER PICTURE FORM -->
<jsp:include page="/WEB-INF/pages/user/profile/profile_picture_form.jsp"/>

<!-- EDIT USER FORM -->
<jsp:include page="./editUserForm.jsp"/>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp" %>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/js/dashboard-side-menu.js"></script>
<script src="${pageContext.request.contextPath}/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/preview-image.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button.js"></script>
<script src="${pageContext.request.contextPath}/js/modal-button-1.js"></script>
<script>
    const id = ${requestScope.user.id};
</script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/js/create-dynamic-cuack.js?v=1"></script>
<script src="${pageContext.request.contextPath}/js/ajax-profile.js"></script>


</body>
</html>