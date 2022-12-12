<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:parseDate value="${requestScope.user.birthday}" type="date" pattern="yyyy-MM-dd" var="parsedBirthday"/>

<div class="pop-up" id="modalForm">
    <div class="card">
        <span class="close" id="closeModalBtn">&times;</span>
        <h4>Editar Un Usuario</h4><br>
        <form action="${pageContext.request.contextPath}/users?action=edit&idUser=${requestScope.user.id}"
              method="POST" class="login-form">
            <label>Nombre del Usuario</label><br>
            <input type="text" class="login-input" name="nickname" value="${requestScope.user.name}" required><br>
            <label>Fecha de Cumplea&ntilde;os</label><br>
            <input type="date" class="login-input" name="birthday" value="<fmt:formatDate value="${parsedBirthday}" type="date" pattern="yyyy-MM-dd"/>" required><br>
            <label>Correo Electr&oacute;nico</label><br>
            <input type="email" class="login-input" name="email" value="${requestScope.user.email}" required><br>
            <label>Contrase&ntilde;a</label><br>
            <input type="password" class="login-input" name="password" value="${requestScope.user.password}"
                   required><br>
            <label>Tipo de Usuario</label><br>
            <input type="number" class="login-input" name="type" value="${requestScope.user.type}" required min="1"
                   max="3"><br>
            <input type="submit" value="Editar" class="btn btn-primary"/>
        </form>
    </div>
</div>