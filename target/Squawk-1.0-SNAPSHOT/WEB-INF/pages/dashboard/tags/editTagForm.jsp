<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="pop-up inserted">
    <div class="card" style="margin: 5rem auto !important;">
        <h4>Editar Tag</h4><br>
        <form action="${pageContext.request.contextPath}/tags?action=edit&idTag=${requestScope.tag.tagID}"
              method="POST" class="login-form">
            <label>Descripci&oacute;n</label><br>
            <input type="text" class="login-input" name="description" value="${requestScope.tag.desc}" required><br>
            <input type="submit" value="Editar" class="btn btn-primary"/>
        </form>
    </div>
</div>