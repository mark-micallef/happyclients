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
        <td>Username:</td>
    </tr>
</table>

</body>
</html>
