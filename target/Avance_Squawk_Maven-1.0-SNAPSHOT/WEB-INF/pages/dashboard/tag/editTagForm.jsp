<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:parseDate value="${requestScope.user.birthday}" type="date" pattern="yyyy-MM-dd" var="parsedBirthday"/>

<div class="pop-up inserted">
    <div class="card">
        <h4>Editar Tag</h4><br>
        <form action="${pageContext.request.contextPath}/tag?action=edit&idTag=${requestScope.tag.id}"
              method="POST" class="login-form">
            <label>Descripci&oacute;n</label><br>
            <input type="text" class="login-input" name="description" value="${requestScope.tag.description}" required><br>
            <input type="submit" value="Editar" class="btn btn-primary"/>
        </form>
    </div>
</div>