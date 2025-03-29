<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/5/2025
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; }
        .container { width: 30%; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        input { width: 100%; padding: 10px; margin: 5px 0; }
        button { width: 100%; padding: 10px; background-color: blue; color: white; border: none; cursor: pointer; }
        .error { color: red; }
    </style>
</head>
<body>

<div class="container">
    <h2>Login</h2>

    <% if (request.getParameter("error") != null) { %>
    <p class="error"><%= request.getParameter("error") %></p>
    <% } %>

    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>

