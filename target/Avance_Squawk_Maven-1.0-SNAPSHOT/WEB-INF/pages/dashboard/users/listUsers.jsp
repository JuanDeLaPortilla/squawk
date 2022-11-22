<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="recent-orders">
    <h2>Lista de Usuarios</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Cumplea&ntilde;os</th>
            <th>Fotograf&iacute;a</th>
            <th>Estado</th>
            <th>Fecha de Creaci&oacute;n</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.birthday}</td>
            <td>
                <div class="profile-photo">
                    <img src="${u.img}">
                </div>
            </td>
            <td>${u.status}</td>
            <td>${u.creationDate}</td>
            <td>
                <a onclick="return confirm('&iquest;Est&aacute; seguro que desea editar los datos del usuario?');"
                        href="${pageContext.request.contextPath}/users?action=edit&idUser=${u.id}"><span class="material-icons-sharp" style="color : #ffbb55"> edit </span></a>
            </td>
            <td>
                <a onclick="return confirm('&iquest;Est&aacute; seguro que desea eliminar al usuario?');"
                        href="${pageContext.request.contextPath}/users?action=delete&idUser=${u.id}"><span class="material-icons-sharp" style="color : #ff7782"> delete_forever </span></a>
            </td>
        </tr>
        </c:forEach>
        </tbody>

    </table>
</div>