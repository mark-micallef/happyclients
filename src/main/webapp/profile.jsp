<%@include file="header.jsp" %>

<%
    if (loggedUser == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>

<table>
    <tr>
        <td>email:</td>
        <td><input type="text" value="<%= loggedUser.getEmail() %>" disabled/></td>
    </tr>
    <tr>
        <td>Business Name:</td>
        <td><input type="text" name="name" value="<%= loggedUser.getName() %>" autofocus/></td>
    </tr>
    <tr>
        <td>SenderID:</td>
        <td><input type="text" name="senderID" value="<%= loggedUser.getSenderID() %>" maxlength="11"></td>
    </tr>
    <tr>
        <td>Plan:</td>
        <td><input list="plans"> </td>
    </tr>
</table>

<datalist id="plans">
    <option value="Free"/>
    <option value="Basic"/>
    <option value="Premium"/>
    <option value="Platinum"/>
</datalist>

</body>
</html>
