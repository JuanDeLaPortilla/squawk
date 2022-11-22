<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Formato para la fecha de creacion de la cuenta-->
<fmt:setLocale value="es"/>
<fmt:parseDate value="${requestScope.user.creationDate}" type="date" pattern="yyyy-MM-dd"
               var="parsedCreationDate"/>
<fmt:formatDate value="${parsedCreationDate}" type="date" dateStyle="long" var="creationDate"/>

<div class="right first">
    <div class="profile-info">

        <div class="heading">
            <div class="centered">
                <img class="profile-photo" src="${requestScope.user.img}">

                <c:if test="${sessionScope.user.get().id == requestScope.user.id}">
                <i class="text-white uil uil-camera" id="modalBtn1"></i>
                </c:if>
            </div>
            <h4>${requestScope.user.name}</h4>
            <p class="text-muted">Se uni&oacute; el <b>${creationDate}</b></p>
        </div>

        <c:if test="${sessionScope.user.get().id == requestScope.user.id}">
        <div class="buttons">
            <label class="btn btn-primary" id="modalBtn">Actualizar Info</label>
            <a href="${pageContext.request.contextPath}/submit" class="btn btn-primary">Crear un Cuack</a>
        </div>
        </c:if>
    </div>
</div>