<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/24/2025
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h3>Error:</h3>
<p><%= request.getAttribute("error") %></p>
<a href="cart.jsp">Go back to profile</a>
</body>
</html>

