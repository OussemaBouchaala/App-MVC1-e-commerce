<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/6/2025
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
</head>
<body>
<h2>You have successfully logged out.</h2>
<p>Thank you for visiting our website. You can <a href="login.jsp">login</a> again if you want.</p>

<%
    // Invalidate the session and remove the logged-in status
    session.invalidate(); // This removes all session attributes including "loggedIn"
%>

<p>You will be redirected to the homepage in a few seconds...</p>

<script>
    // Redirect the user to the homepage after 2 seconds
    setTimeout(function() {
        window.location.href = "index.jsp";
    }, 2000);
</script>
</body>
</html>

