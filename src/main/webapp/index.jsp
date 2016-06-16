<%
    String loggedUser = session.getAttribute("loggedUser");
%>

<html>
<title>The Happy Client</title>
<h1>The Happy Client</h1>
<a href="register.jsp">Register</a> <br/>
<% if (loggedUser == null) {%>
<a href="login.jsp">Log in</a><br/>
<% } else {%>
<a href="logout.jsp">Log out</a><br/>
<% } %>

</html>