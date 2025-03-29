<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.metier.Produit" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.project.metier.Client" %>
<%
    // Get client name from session
    Client client = (Client) session.getAttribute("client");
    String clientName = client.getName();

    // Get list of products (assuming this is set in a Servlet)
    List<Produit> produits = (List<Produit>) session.getAttribute("userProducts");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home - Welcome <%= clientName %></title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; }
        .container { width: 50%; margin: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #4CAF50; color: white; }
        button { padding: 10px; margin: 5px; cursor: pointer; }
        .add-btn { background-color: blue; color: white; border: none; }
        .delete-btn { background-color: red; color: white; border: none; }
    </style>
</head>
<body>

<div class="container">
    <h2>Hello, <%= clientName != null ? clientName : "Guest" %>!</h2>
    <h3>Welcome to your dashboard</h3>

    <!-- Add Product Button -->


    <h3>Your Products in the cart</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Action</th>
        </tr>

        <% if (produits != null && !produits.isEmpty()) {
            for (Produit produit : produits) { %>
        <tr>
            <td><%= produit.getId() %></td>
            <td><%= produit.getName() %></td>
            <td><%= produit.getDescription() %></td>
            <td><%= produit.getPrix() %> $</td>
            <td>
                <!-- Delete Product Button -->
                <form action="product" method="get">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="productId" value="<%= produit.getId() %>">
                    <button type="submit" class="delete-btn">🗑 Delete</button>
                </form>
            </td>
        </tr>
        <% }
        } else { %>
        <tr>
            <td colspan="5">No products added yet.</td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>
