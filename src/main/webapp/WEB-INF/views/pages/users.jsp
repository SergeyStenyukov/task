<%@ include file="taglib.jsp" %>

<div class="table">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>login</th>
            <th>password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th>${user.id}</th>
                <th>${user.login}</th>
                <th>${user.password}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>