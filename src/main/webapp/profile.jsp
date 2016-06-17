<%@ page import="com.mea.happyclients.users.plans.Plan" %>
<%@include file="header.jsp" %>

<%
    if (loggedUser == null) {
        response.sendRedirect("login.jsp");
    }

    String senderIDEnabled = "disabled";
    if (loggedUser.getPlan().getMaxSenderIDs() != 0) {
        senderIDEnabled = "";
    }

    //Process Form
    loggedUser.setName(request.getParameter("name"));
    loggedUser.setSenderID(request.getParameter("senderID"));



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
        <td>Default Sender ID:</td>
        <td><input type="text" name="senderID" value="<%= loggedUser.getSenderID() %>" maxlength="11" <%= senderIDEnabled %>></td>
    </tr>
    <tr>
        <td>Plan:</td>
        <td>
            <select name="plan">
                <% for (Plan plan : Plan.plans) { %>
                <option value="<%= plan.getName() %>"
                <% if (loggedUser.getPlan().getName().equalsIgnoreCase(plan.getName())) { %>
                        selected
                        <% } %>
                ><%= plan.toString() %></option>
                <% } %>
            </select>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Update Profile"/>
        </td>
    </tr>
</table>

<datalist id="plans">

</datalist>

</body>
</html>
