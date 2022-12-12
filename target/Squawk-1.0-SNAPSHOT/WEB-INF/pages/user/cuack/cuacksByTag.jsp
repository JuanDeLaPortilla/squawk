<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categoria ${requestScope.tag.desc} | Squawk!</title>
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

            <!-- FEEDS -->
            <div class="feeds" id="feeds">
                <h1 style="padding: 0 1rem">Cuacks de la Categoria ${requestScope.tag.desc}</h1>
            </div>
        </div>
        <div></div>
    </div>
</main>

<!-- SIGNUP + LOGIN FORM TAB-->
<jsp:include page="/WEB-INF/pages/user/login-signup/signup_login_form_tab.jsp"/>

<!-- CUACK TEMPLATE -->
<%@include file="/WEB-INF/pages/user/commons/feed-template.jsp" %>

<!-- Conexiones con Js -->
<script src="${pageContext.request.contextPath}/assets/js/white-theme.js"></script>
<c:choose>
    <c:when test="${sessionScope.user.isPresent()}">
    </c:when>
    <c:otherwise>
        <script src="${pageContext.request.contextPath}/assets/js/modal-button.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/tab-form.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sessionWarning.js"></script>
    </c:otherwise>
</c:choose>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ajaxError.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/create-dynamic-cuack.js"></script>
<script>
    const tagId = ${requestScope.tag.tagID};
</script>
<script src="${pageContext.request.contextPath}/assets/js/ajax-cuacks-by-tag.js"></script>
</body>
</html>
