<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/submit?action=submit" method="post" class="submit-form" enctype='multipart/form-data'>
    <div class="content">
        <select class="cuack-input" name="idTag" required style="width: auto; cursor: pointer">
            <option value=0 selected>Selecciona una categor&iacute;a</option>
            <c:forEach items="${tags}" var="t">
                <option value="${t.tagID}">${t.desc}</option>
            </c:forEach>
        </select><br>
        <input type="text" class="cuack-input" placeholder="Escribe el t&iacute;tulo" name="title" required><br>
        <textarea placeholder="Redacta tu rese&ntilde;a" name="content"></textarea><br>
        <div class="cuack-input" style="margin-bottom: 0">
            <label for="inpFile" class="image-preview" id="imagePreview">
                <input type="file" name="img" id="inpFile" accept=".jpg, .jpeg, .png">
                <span class="default-text">Selecciona una imagen del producto <i class="uil uil-image-v"></i></span>
                <img src="">
            </label>
        </div>
        <br>
        <input type="url" class="cuack-input" placeholder="A&ntilde;ade una url del producto" name="url"
               style="margin-top: 0">
        <br>
        <input type="hidden" value="${sessionScope.user.get().id}" name="idUser">
        <input type="submit" class="btn btn-primary" value="Publicar">
    </div>
</form>