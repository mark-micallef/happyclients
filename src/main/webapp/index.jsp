<%@ page import="com.mea.happyclients.users.User" %>

<%@include file="header.jsp" %>


<html>
<title>The Happy Client</title>
<h1>The Happy Client</h1>

<% if (loggedUser == null) {%>
<a href="register.jsp">Register</a> <br/>
<a href="login.jsp">Log in</a><br/>
<% } else {%>
<a href="profile.jsp">Edit Profile</a>
<a href="logout.jsp">Log out <%= loggedUser.getEmail() %></a><br/>
<% } %>

</html>