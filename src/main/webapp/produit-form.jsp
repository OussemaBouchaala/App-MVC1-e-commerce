<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/24/2025
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.metier.Produit" %>

<%
  Produit produit = (Produit) request.getAttribute("produit");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Product Form</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
  <h2 class="text-center"><%= produit != null ? "Edit Product" : "Add Product" %></h2>
  <form action="product" method="post">
    <input type="hidden" name="id" value="<%= produit != null ? produit.getId() : "" %>">

    <div class="mb-3">
      <label for="name" class="form-label">Name</label>
      <input id="name" type="text" name="name" class="form-control" required value="<%= produit != null ? produit.getName() : "" %>">
    </div>

    <div class="mb-3">
      <label for="desc" class="form-label">Description</label>
      <textarea id="desc" name="description" class="form-control" required><%= produit != null ? produit.getDescription() : "" %></textarea>
    </div>

    <div class="mb-3">
      <label for="prix" class="form-label">Price ($)</label>
      <input id="prix" type="number" step="0.01" name="prix" class="form-control" required value="<%= produit != null ? produit.getPrix() : "" %>">
    </div>

    <div class="mb-3">
      <label for="image" class="form-label">Image URL</label>
      <input id="image" type="text" name="image" class="form-control" required value="<%= produit != null ? produit.getImage() : "" %>">
    </div>

    <button type="submit" class="btn btn-success">Save</button>
    <a href="product" class="btn btn-secondary">Cancel</a>
  </form>
</div>

</body>
</html>

