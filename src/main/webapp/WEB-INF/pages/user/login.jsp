<div class="pop-up" id="modalForm1">
<div class="card">
  <span class="close" id="closeModalBtn1">&times;</span>
  <h4>Iniciar Sesi&oacute;n</h4>
    <p class="text-muted">Al continuar, aceptas nuestros <a href="${pageContext.request.contextPath}/terms.jsp"><b>T&eacute;rminos y Condiciones</b></a></p><br>
    <form action="${pageContext.request.contextPath}/session?action=login" method="post">
      <label>Correo Electr&oacute;nico</label><br>
      <input type = "email" class="login-input" placeholder="Correo Electr&oacute;nico" name="email" required><br>
      <label>Contrase&ntilde;a</label><br>
      <input type = "password" class="login-input" placeholder="Contrase&ntilde;a" name="password" required>
      <p><a id="link" href="#">&iquest;Olvidaste tu contrase&ntilde;a?</a></p>
      <input type="submit" value="Ingresar" class="btn btn-primary"/>
    </form>
  </div>
</div>