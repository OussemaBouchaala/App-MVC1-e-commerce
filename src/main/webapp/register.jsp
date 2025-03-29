<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/26/2025
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>Register</h2>

<%-- Display error message if any --%>
<%
    String error = request.getParameter("error");
    if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<%
    }
%>

<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>
</body>
</html>

