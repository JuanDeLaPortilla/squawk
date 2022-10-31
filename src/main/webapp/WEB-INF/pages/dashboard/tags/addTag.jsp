<!-- ADD USER BUTTON-->
<div class="right">
    <div class="sales-analytics">
        <div class="item add-product">
            <div id="modalBtn">
                <span class="material-icons-sharp">add</span>
                <h3>A&ntilde;adir Tag</h3>
            </div>
        </div>
    </div>
</div>

<!-- ADD TAG FORM-->
<div class="pop-up" id="modalForm">
    <div class="card">
        <span class="close" id="closeModalBtn">&times;</span>
        <h4>A&ntilde;adir Tag</h4><br>
        <form action="${pageContext.request.contextPath}/tags?action=add" method="POST" class="login-form">
            <label>Descripci&oacute;n del Tag</label><br>
            <input type="text" class="login-input" placeholder="Descripci&oacute;n" name="description" required><br>
            <input type="submit" value="Registrar" class="btn btn-primary"/>
        </form>
    </div>
</div>