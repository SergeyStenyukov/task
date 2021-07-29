<%@ include file="taglib.jsp" %>

<html>
<body>
<h2>${user.login}</h2>
<h2>Personal information</h2>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<table class="table">
    <thead>
    <tr>
        <th>type</th>
        <th>amount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="balance" items="${user.balances}">
        <tr>
            <th>${balance.type}</th>
            <th>${balance.amount}</th>
        </tr>
    </c:forEach>
    </tbody>
    </form>
</table>
<form action="" method="POST">
    <h4>Add new balance:</h4>
    <div class="form-group">
        <select name="type">
            <c:forEach items="${types}" var="type">
                <option value="${type}">${type}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <input name="amount" type="number" max="999999999999999" value="" />
    </div>
    <div class="form-group">
        <input type="submit" value="Add" />
    </div>
</form>

</body>
</html>
