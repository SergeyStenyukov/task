<html>
<body>
<h3>User name or password is incorrect. Access denied.</h3>
<form action="<%=request.getContextPath()%>/" method="GET">
    <input type="submit" value="Try again"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>