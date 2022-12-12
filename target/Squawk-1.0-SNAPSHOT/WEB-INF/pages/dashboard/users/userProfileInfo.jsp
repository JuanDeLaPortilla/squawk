<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Formato para la fecha de creacion de la cuenta-->
<fmt:setLocale value="es"/>
<fmt:parseDate value="${requestScope.user.creationDate}" type="date" pattern="yyyy-MM-dd"
               var="parsedCreationDate"/>
<fmt:formatDate value="${parsedCreationDate}" type="date" dateStyle="long" var="creationDate"/>

<div class="right first" style="margin-top: 1rem;">
    <div class="pop-up inserted">
        <div class="card" style="margin: 0!important;">
            <div class="profile-head">
                <h4>${requestScope.user.name}</h4>
                <div style="margin-bottom: 1rem">
                    <img class="profile-photo" src="${requestScope.user.img}">
                    <i class="text-white uil uil-camera" id="modalBtn1"></i>
                </div>
            </div>
            <div class="profile-info">
                <p class="text-muted">Se uni&oacute; el <b>${creationDate}</b></p>

                <div class="buttons">
                    <label class="btn btn-primary" id="modalBtn">Editar Datos</label>
                    <c:choose>
                        <c:when test="${requestScope.user.status == 1}">
                            <a onclick="return confirm('&iquest;Est&aacute; seguro que desea eliminar al usuario?');"
                               href="${pageContext.request.contextPath}/users?action=delete&idUser=${requestScope.user.id}"
                               class="btn btn-primary">Eliminar Usuario</a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="return confirm('&iquest;Est&aacute; seguro que desea activar al usuario?');"
                               href="${pageContext.request.contextPath}/users?action=activate&idUser=${requestScope.user.id}"
                               class="btn btn-primary">Activar Usuario</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>


