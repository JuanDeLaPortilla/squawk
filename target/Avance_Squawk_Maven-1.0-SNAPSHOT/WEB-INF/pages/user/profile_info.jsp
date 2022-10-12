<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Formato para la fecha de creacion de la cuenta-->
<fmt:setLocale value="es"/>
<fmt:parseDate value="${sessionScope.user.get().creationDate}" type="date" pattern="yyyy-MM-dd" var="parsedCreationDate"/>
<fmt:formatDate value="${parsedCreationDate}" type="date" dateStyle="long" var="creationDate"/>

<div class="right first">
    <div class="profile-info">

        <div class="heading">
            <img class="profile-photo" src="${pageContext.request.contextPath}/images/logo.webp">
            <h4>${sessionScope.user.get().name}</h4>
            <p class="text-muted">Se uni&oacute; el <b>${creationDate}</b></p>
        </div>

        <div class="buttons">
            <label class="btn btn-primary" id="modalBtn">Actualizar Info</label>
            <a href="${pageContext.request.contextPath}/submit" class="btn btn-primary">Crear un Cuack</a>
        </div>

    </div>
</div>