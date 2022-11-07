<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="recent-orders">
    <h2>Lista de Cuacks</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Usuario</th>
            <th>Correo</th>
            <th>Tag</th>
            <th>URL</th>
            <th>Calificaci&oacute;n</th>
            <th>Estado</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cuacks}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.tagId}</td>
            <td>${c.title}</td>
            <td>${c.tagId}</td>
            <td>${c.url}</td>
            <td>${c.rating}</td>
            <td>${c.status}</td>
            <td>
                <a onclick="return confirm('&iquest;Est&aacute; seguro que desea editar los datos del cuack?');"
                        href="${pageContext.request.contextPath}/cuacks?action=edit&idCuack=${c.id}"><span class="material-icons-sharp" style="color : #ffbb55"> edit </span></a>
            </td>
            <td>
                <a onclick="return confirm('&iquest;Est&aacute; seguro que desea eliminar el cuack?');"
                        href="${pageContext.request.contextPath}/cuacks?action=delete&idCuack=${c.id}"><span class="material-icons-sharp" style="color : #ff7782"> delete_forever </span></a>
            </td>
        </tr>
        </c:forEach>
        </tbody>

    </table>
</div>