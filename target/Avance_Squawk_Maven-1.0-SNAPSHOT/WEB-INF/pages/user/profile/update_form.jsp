<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:parseDate value="${sessionScope.user.get().birthday}" type="date" pattern="yyyy-MM-dd" var="parsedBirthday"/>
<div class="pop-up" id="modalForm">
    <div class="card">
        <span class="close" id="closeModalBtn">&times;</span>
        <h4>Actualizar Datos</h4>
        <p class="text-muted">Al continuar, est&aacute; <a href="${pageContext.request.contextPath}/terms.jsp"><b>aceptando los T&eacute;rminos y Condiciones de Squawk!</b></a></p><br>
        <form action="${pageContext.request.contextPath}/users?action=update" method="post">
            <label>Nombre del Usuario</label><br>
            <input type="text" class="login-input" value="${sessionScope.user.get().name}" name="nickname" required><br>
            <label>Fecha de Cumplea&ntilde;os</label><br>
            <input type="date" class="login-input" value="<fmt:formatDate value="${parsedBirthday}" type="date" pattern="yyyy-MM-dd"/>" name="birthday" required><br>
            <label>Correo Electr&oacute;nico</label><br>
            <input type="email" class="login-input" value="${sessionScope.user.get().email}" name="email"
                   required><br>
            <label>Contrase&ntilde;a</label><br>
            <input type="password" class="login-input" value="${sessionScope.user.get().password}" name="password" required><br>
            <input type="hidden" value="${sessionScope.user.get().id}" name="idUser">
            <input type="hidden" value="${sessionScope.user.get().type}" name="type">
            <input type="submit" value="Guardar" class="btn btn-primary"/>
        </form>
    </div>
</div>