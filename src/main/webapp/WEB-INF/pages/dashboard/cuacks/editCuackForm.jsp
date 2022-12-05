<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:parseDate value="${requestScope.user.birthday}" type="date" pattern="yyyy-MM-dd" var="parsedBirthday"/>

<div class="pop-up inserted">
    <div class="card">
        <h4>Editar Cuack</h4><br>
        <form action="${pageContext.request.contextPath}/cuacks?action=edit&idUser=${requestScope.cuack.id}"
              method="POST" class="login-form">
            <label>Descripci&oacute;n</label><br>
            <input type="text" class="login-input" name="description" value="${requestScope.cuack.description}" required><br>
            <label>Tag</label><br>
            <input type="number" class="login-input" name="tagId" value="${requestScope.cuack.tagId}" required min="1"
                   max="10"><br>
            <label>URL</label><br>
            <input type="text" class="login-input" name="url" value="${requestScope.cuack.url}"required><br>
            <label>T&iacute;tulo</label><br>
            <input type="text" class="login-input" name="title" value="${requestScope.cuack.title}"required><br>
            <label>Precio</label><br>
            <input type="number" class="login-input" name="tagId" value="${requestScope.cuack.price}" required><br>
            <label>Estado</label><br>
            <input type="number" class="login-input" name="type" value="${requestScope.cuack.status}" required min="1"
                   max="2"><br>
            <input type="submit" value="Editar" class="btn btn-primary"/>
        </form>
    </div>
</div>