<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.user.name} | Squawk!</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <%@include file="/WEB-INF/pages/user/commons/head-imports.jsp"%>
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
                <div class="feeds" id="feeds"></div>
            </div>
        </div>
        <!-- RIGHT -->
        <jsp:include page="/WEB-INF/pages/user/profile/profile_info.jsp"/>
    </div>
</main>

<script>
    const id = ${requestScope.user.id};
</script>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp" %>

<c:choose>
    <c:when test="${sessionScope.user.get().id == requestScope.user.id}">
        <jsp:include page="/WEB-INF/pages/user/profile/profile_picture_form.jsp"/>
        <jsp:include page="/WEB-INF/pages/user/profile/update_form.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>
    </c:otherwise>
</c:choose>


<!-- Conexiones Js -->
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/modal-button.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/create-dynamic-cuack.js"></script>>
<script src="${pageContext.request.contextPath}/assets/js/ajax-profile.js?v=1.2"></script>
<c:choose>
    <c:when test="${sessionScope.user.isPresent()}">
        <script src="${pageContext.request.contextPath}/assets/js/modal-button-1.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/preview-image.js"></script>
    </c:when>
    <c:otherwise>
        <script src="${pageContext.request.contextPath}/assets/js/tab-form.js"></script>
    </c:otherwise>
</c:choose>

</body>
</html>
