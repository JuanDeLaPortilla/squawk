<div class="pop-up" id="modalForm1">
    <div class="card">
        <span class="close" id="closeModalBtn1">&times;</span>
        <h4>Actualizar foto del perfil</h4>
        <form action="${pageContext.request.contextPath}/users?action=updateProfile" method="post">
            <br>
            <label for="inpFile" class="image-preview" id="imagePreview">
                <input type="file" name="img" id="inpFile" accept=".jpg, .jpeg, .png">
                <span class="default-text">Selecciona una Imagen <i class="uil uil-camera"></i></span>
                <img src="">
            </label>
            <input type="hidden" value="${sessionScope.user.get().id}" name="idUser"><br>
            <input type="submit" value="Guardar" class="btn btn-primary"/>
        </form>
    </div>
</div>


