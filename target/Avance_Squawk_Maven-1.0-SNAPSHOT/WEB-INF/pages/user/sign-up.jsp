<div class="pop-up" id="modalForm">
    <div class="card">
        <span class="close" id="closeModalBtn">&times;</span>
        <h4>Registrarse</h4>
        <p class="text-muted">Al continuar,<a href="#"><b> est&aacute; configurando un cuenta de Squawk!</b></a></p><br>
        <form action="${pageContext.request.contextPath}/users?action=sign-up" method="post">
            <label>Nombre del Usuario</label><br>
            <input type="text" class="login-input" placeholder="Nombre de Usuario" name="nickname" required><br>
            <label>Fecha de Cumplea&ntilde;os</label><br>
            <input type="date" class="login-input" name="birthday" required><br>
            <label>Url de tu Foto de Perfil</label><br>
            <input type="url" class="login-input" placeholder="Url de tu foto de perfil" name="img"><br>
            <label>Correo Electr&oacute;nico</label><br>
            <input type="email" class="login-input" placeholder="Correo Electr&oacute;nico" name="email"
                   required><br>
            <label>Contrase&ntilde;a</label><br>
            <input type="password" class="login-input" placeholder="Contrase&ntilde;a" name="password" required><br>
            <input type="submit" value="Registrar" class="btn btn-primary"/>
        </form>
    </div>
</div>