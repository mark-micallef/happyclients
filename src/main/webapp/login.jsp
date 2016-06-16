<%@ page import="com.mea.happyclients.errors.ErrorList" %>
<%@ page import="com.mea.happyclients.database.DatabaseLayer" %><%--
  Created by IntelliJ IDEA.
  User: markmicallef
  Date: 16/06/2016
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boolean submitted = (request.getParameter("submitted") != null);

    ErrorList errorList = new ErrorList();
    String email = "";

    if (submitted) {
        DatabaseLayer dbLayer = DatabaseLayer.getInstance();
        email = request.getParameter("email");
    }
%>


<html>
<head>
    <title>Login</title>
    <form method="post">
        <input type="hidden" name="submitted" value="true"/>
        <table>
            <tr>
                <td>e-mail address:</td>
                <td><input type="email" name="email" value="<%=email%>" title="Tell us your e-mail address so we can contact you" required>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" title="What would you like your password to be?" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Login" title="Complete registration"></td>
            </tr>
        </table>
    </form>
</head>
<body>

</body>
</html>