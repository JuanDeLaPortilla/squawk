<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <%@include file="/WEB-INF/pages/user/commons/head-imports.jsp"%>
</head>

<body>
<!-- HEADER -->
<jsp:include page="/WEB-INF/pages/user/commons/header.jsp"/>
<!-- MAIN -->
<main>
    <div class="container">
        <div></div>
        <!-- MIDDLE -->
        <div class="middle">

            <!-- TOP CUACKS -->
            <jsp:include page="/WEB-INF/pages/user/top-cuacks.jsp"/>

            <!-- CREATE CUACK -->
            <c:if test="${sessionScope.user.present}">
                <a class="create-post" href="${pageContext.request.contextPath}/submit">
                    <div class="profile-photo">
                        <c:choose>
                            <c:when test="${sessionScope.user.present}">
                                <img src="${sessionScope.user.get().img}"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/profile_pictures/default.webp"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <p class="text-muted">&iexcl;Crea un cuack ahora!</p>
                    <label class="btn btn-primary">Crear</label>
                </a>
            </c:if>

            <!-- FEEDS -->
            <div class="feeds" id="feeds"></div>
        </div>
        <div></div>
    </div>
</main>

<!-- SIGNUP + LOGIN FORM TAB-->
<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp"%>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/create-dynamic-cuack.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajax-index.js"></script>
<c:choose>
    <c:when test="${sessionScope.user.isPresent()}">
    </c:when>
    <c:otherwise>
        <script src="${pageContext.request.contextPath}/assets/js/modal-button.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/tab-form.js"></script>
    </c:otherwise>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/top-cuacks-swiper.js"></script>

</body>
</html>
