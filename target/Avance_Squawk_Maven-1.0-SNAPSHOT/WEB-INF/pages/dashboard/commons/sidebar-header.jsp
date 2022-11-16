<aside>
  <div class="top">
    <div class="logo">
      <img src="./images/logo-dashboard.png" id="myImage">
      <h2><span class="primary">SQU</span>AWK!</h2>
    </div>
    <div class="close" id="close-btn">
      <span class="material-icons-sharp">close</span>
    </div>
  </div>

  <div class="sidebar">
    <a href="${pageContext.request.contextPath}/dashboard">
      <span class="material-icons-sharp">grid_view</span>
      <h3>Dashboard</h3>
    </a>
    <a href="${pageContext.request.contextPath}/users">
      <span class="material-icons-sharp">diversity_2</span>
      <h3>Usuarios</h3>
    </a>
    <a href="${pageContext.request.contextPath}/cuacks">
      <span class="material-icons-sharp">forum</span>
      <h3>Cuacks</h3>
    </a>
    <a href="${pageContext.request.contextPath}/tags">
      <span class="material-icons-sharp">style</span>
      <h3>Tags</h3>
    </a>
    <!----- Contador de mensajes
    <a href="">
        <span class="material-icons-sharp">mail_outline</span>
        <h3>Messages</h3>
        <span class="message-count">26</span>
    </a>
        ------->
    <a href="${pageContext.request.contextPath}/staff">
      <span class="material-icons-sharp">groups_3</span>
      <h3>Staff</h3>
    </a>
    <a href="${pageContext.request.contextPath}/index">
      <span class="material-icons-sharp">logout</span>
      <h3>Salir</h3>
    </a>
  </div>
</aside>