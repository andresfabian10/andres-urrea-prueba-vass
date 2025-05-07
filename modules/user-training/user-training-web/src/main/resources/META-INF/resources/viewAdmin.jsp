<%@ include file="./init.jsp" %>
<h3>Registros guardados</h3>
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
        </tr>
        <c:forEach var="item" items="${registers}">
            <tr>
                <td>${item.trainingId}</td>
                <td>${item.userName}</td>
                <td>${item.email}</td>
            </tr>
        </c:forEach>
    </table>