<%--
  Created by IntelliJ IDEA.
  User: markmicallef
  Date: 15/06/2016
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register as a Business User</title>
</head>
<body>
<H1>Create a new account</H1>
<form method="post">
    <table>
        <tr>
            <td>Business Name:</td>
            <td><input type="text" name="businessName" title="Tell us the name of your business" required></td>
        </tr>

        <tr>
            <td>e-mail address:</td>
            <td><input type="text" name="email" title="Tell us your e-mail address so we can contact you" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" title="What would you like your password to be?" required></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirmPassword" title="Confirm your password for us" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Register" title="Complete registration"></td>
        </tr>

    </table>
</form>

</body>
</html>
