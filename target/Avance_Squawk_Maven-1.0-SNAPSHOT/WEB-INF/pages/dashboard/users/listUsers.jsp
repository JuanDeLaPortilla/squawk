<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="recent-orders" style="overflow: hidden;">
    <h2>Lista de Usuarios</h2>
    <table class="datatable">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Correo</th>
                <th scope="col">Fotograf&iacute;a</th>
                <th scope="col">Estado</th>
                <th scope="col">Fecha de Creaci&oacute;n</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">
                <tr>
                    <th scope="row">${u.id}</th>
                    <td>${u.name}</td>
                    <td>${u.email}</td>
                    <td>
                        <div class="profile-photo">
                            <img src="${u.img}">
                        </div>
                    </td>
                    <td>${u.status}</td>
                    <td>${u.creationDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/users?action=edit&idUser=${u.id}">Ver detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>