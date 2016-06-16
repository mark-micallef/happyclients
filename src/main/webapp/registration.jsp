<%@ page import="com.mea.happyclients.database.DatabaseLayer" %>
<%@ page import="com.mea.happyclients.errors.ErrorList" %>
<%@ page import="com.mea.happyclients.errors.Errors" %>
<%@ page import="com.mea.happyclients.infrastructure.Utils" %><%--
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

<%

    boolean submitted = (request.getParameter("submitted") != null);

    ErrorList errorList = new ErrorList();

    if (submitted) {
        submitted = true;

        DatabaseLayer dbLayer = DatabaseLayer.getInstance();
        String email = request.getParameter("password");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");


        //Process form
        //1. Check that passwords match
        if (password.equals(confirmPassword)) {
            errorList.addError(Errors.ERR_UI_REG_PASSWORDS_DONT_MATCH, "The password and confirmation password do not match.");
        }

        //2. Check that password is strong enough
     /*   if (password.length() < 8) {
            errorList.addError(Errors.ERR_UI_REG_PASSWORD_WEAK, "The selected password needs to be at least 8 characters long.");
        }*/

        //3. Check that a user with the same e-mail address does not exist
        if (dbLayer.userWithEmailExists(email)) {
            errorList.addError(Errors.ERR_DB_DUPLICATE_ENTRY, "A user with that e-mail address already exists.");
        }

        if (errorList.isOk()) {
            errorList.mergeErrorLists(dbLayer.createUserInDB(email, Utils.encodePassword(password)));
        }
    }

%>

<% if (submitted && errorList.isOk()) {%>
<H1>User created</H1>
<%} else {%>

<H1>Create a new account</H1>

<% if (!errorList.isOk()) { %>
<%= errorList.toHtmlString()%>
<%}%>

<form method="post">
    <input type="hidden" name="submitted" value="true"/>
    <table>
        <tr>
            <td>e-mail address:</td>
            <td><input type="email" name="email" title="Tell us your e-mail address so we can contact you" required>
            </td>
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

<%}%>

</body>
</html>
