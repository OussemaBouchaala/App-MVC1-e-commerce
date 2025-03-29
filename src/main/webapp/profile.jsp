<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/28/2025
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.metier.Client" %>
<%@ page import="com.project.metier.Produit" %>

<%
    // Fetch logged-in client details
    Client client = (Client) session.getAttribute("client");
    if (client == null) {
        response.sendRedirect("login.jsp"); // Redirect to login if not authenticated
        return;
    }

    // Fetch cart products from session
    List<Produit> cart = (List<Produit>) session.getAttribute("userCart");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile - <%= client.getName() %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<!-- 🔹 Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Product Store</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a href="cart.jsp" class="nav-link position-relative">
                        🛒 Cart
                        <span class="badge bg-danger position-absolute top-0 start-100 translate-middle">
                            <%= (cart != null) ? cart.size() : 0 %>
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="index.jsp" class="nav-link btn btn-link">Home</a>
                </li>


                <li class="nav-item">
                    <form action="logout" method="post">
                        <button class="nav-link btn btn-link text-white" type="submit" style="border: none; background: none;">
                            Logout
                        </button>
                    </form>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-link fw-bold text-info">
                        <%= client.getName() %>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 🔹 Profile Details -->
<div class="container mt-4">
    <h2 class="text-center">👤 Profile</h2>
    <div class="card p-3">
        <p><strong>Name:</strong> <%= client.getName() %></p>
        <p><strong>Email:</strong> <%= client.getEmail() %></p>
    </div>
</div>

<!-- 🔹 Shopping Cart Section -->
<div class="container mt-4">
    <h3 class="text-center">🛒 Your Cart</h3>

    <% if (cart != null && !cart.isEmpty()) { %>
    <table class="table table-bordered text-center">
        <thead class="table-dark">
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Price</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <% for (Produit produit : cart) { %>
        <tr>
            <td><%= produit.getName() %></td>
            <td><%= produit.getDescription() %></td>
            <td>$<%= produit.getPrix() %></td>
            <td>
                <form action="product" method="post">
                    <input type="hidden" name="productId" value="<%= produit.getId() %>">
                    <button type="submit" class="btn btn-danger">🗑 Remove</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p class="text-center text-muted">Your cart is empty.</p>
    <% } %>
</div>

<!-- 🔹 Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
