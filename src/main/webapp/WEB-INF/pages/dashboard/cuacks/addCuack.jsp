<!-- ADD USER BUTTON-->
<div class="right">
    <div class="sales-analytics">
        <div class="item add-product">
            <div id="modalBtn">
                <span class="material-icons-sharp">add</span>
                <h3>A&ntilde;adir Cuack</h3>
            </div>
        </div>
    </div>
</div>

<!-- ADD USER FORM-->
<div class="pop-up" id="modalForm">
    <div class="card">
        <span class="close" id="closeModalBtn">&times;</span>
        <h4>A&ntilde;adir Un Cuack</h4><br>
        <form action="${pageContext.request.contextPath}/cuacks?action=add" method="POST" class="login-form">
            <label>Descripci&oacute;n</label><br>
            <input type="text" class="login-input" placeholder="Descripci&oacute;n" name="description" required><br>
            <label>Tag</label><br>
            <input type="number" class="login-input" placeholder="Tag" name="tagId" required><br>
            <label>URL</label><br>
            <input type="text" class="login-input" placeholder="URL" name="url" required><br>
            <label>T&iacute;tulo</label><br>
            <input type="text" class="login-input" placeholder="T&iacute;tulo" name="title" required><br>
            <label>Precio</label><br>
            <input type="number" class="login-input" placeholder="Precio" name="price" required><br>
            <input type="submit" value="Registrar" class="btn btn-primary"/>
        </form>
    </div>
</div>