<%@ page import="com.mea.happyclients.errors.ErrorList" %>
<%@ page import="com.mea.happyclients.database.DatabaseLayer" %>
<%@ page import="com.mea.happyclients.errors.Errors" %>
<%@ page import="com.mea.happyclients.users.User" %>


<%@include file="header.jsp" %>

<%
    if (loggedUser != null) {
        response.sendRedirect("index.jsp");
    }
%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boolean submitted = (request.getParameter("submitted") != null);

    ErrorList errorList = new ErrorList();
    String email = "";

    if (submitted) {
        DatabaseLayer dbLayer = DatabaseLayer.getInstance();
        email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!dbLayer.userLogin(email, password)) {
            errorList.addError(Errors.ERR_UI_LOGIN_FAILED, "Login failed.");
        }

        if (errorList.isOk()) {
            User user = dbLayer.getUserByEmail(email);
            if (user == null) {
                errorList.addError(Errors.ERR_UI_LOGIN_FAILED, "Unkown error occurred during login.");
            } else {
                session.setAttribute("loggedUser", user);
                response.sendRedirect("index.jsp");
            }
        }
    }
%>


<html>
<head>
    <title>Login</title>
    <H1>Log in</H1>

    <%= errorList.toHtmlString() %>

    <form method="post">
        <input type="hidden" name="submitted" value="true"/>
        <table>
            <tr>
                <td>e-mail address:</td>
                <td><input type="email" name="email" value="<%=email%>" title="Tell us your e-mail address so we can contact you" required autofocus>
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
