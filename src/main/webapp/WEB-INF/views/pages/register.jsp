<%@ include file="taglib.jsp" %>

<html>
<body>
<h1>Register new user:</h1>
<form action="#" method="POST">
    <table>
        <tr>
            <td>Login:</td>
            <td><input name="login" type="text" value="" /></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><input name="password" type="text" value="" /></td>
        </tr>
        <td><span name="errors">${errors}</span></td>
        <tr>
            <td colspan="3">
                <input type="submit" value="Register" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
