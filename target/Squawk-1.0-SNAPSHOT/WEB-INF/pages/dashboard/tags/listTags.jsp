<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="recent-orders">
    <h2>Lista de Tags</h2>
    <div id="tag-table">
        <table class="datatable">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Descripci&oacute;n</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tags}" var="t">
                <tr>
                    <th scope="row">${t.tagID}</th>
                    <td>${t.desc}</td>
                    <td>
                        <a onclick="return confirm('&iquest;Est&aacute; seguro que desea editar los datos del Tag?');"
                           href="${pageContext.request.contextPath}/tags?action=edit&idTag=${t.tagID}"><span
                                class="material-icons-sharp" style="color : #ffbb55"> edit </span></a>
                    </td>
                    <td>
                        <a onclick="return confirm('&iquest;Est&aacute; seguro que desea eliminar el Tag?');"
                           href="${pageContext.request.contextPath}/tags?action=delete&idTag=${t.tagID}"><span
                                class="material-icons-sharp" style="color : #ff7782"> delete_forever </span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>