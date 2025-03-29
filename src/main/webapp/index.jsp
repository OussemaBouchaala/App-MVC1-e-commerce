<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.metier.Produit" %>
<%@ page import="com.project.dao.ProduitDAO" %>

<%
    ProduitDAO produitDAO = new ProduitDAO();
    List<Produit> produits = produitDAO.getAllProduits();
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home - Product List</title>
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
                                    <%
                                        List<Produit> cart = (List<Produit>) session.getAttribute("userCart");
                                        int cartSize = (cart != null) ? cart.size() : 0;
                                        out.print(cartSize);
                                    %>
                                </span>
                            </a>
                        </li>

                        <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>

                        <%-- Check if the user is logged in --%>
                        <% if (session != null && session.getAttribute("client") != null) {
                            com.project.metier.Client client = (com.project.metier.Client) session.getAttribute("client");
                        %>

                        <li class="nav-item">
                            <form action="logout" method="post">
                                <button class="nav-link btn btn-link text-white" type="submit" style="border: none; background: none;">
                                    Logout
                                </button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <a href="profile.jsp" class="nav-link btn btn-link fw-bold text-info" style="padding-left: 30px;">
                        <%= client.getName() %>
                            </a>
                        </li>

                        <% } else { %>
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- 🔹 Product List -->
        <form action="product" method="get">
            <input type="hidden" name="action" value="new">
            <button type="submit" class="add-btn">➕ Add Product</button>
        </form>
        <div class="container mt-4">
            <h2 class="text-center">Available Products</h2>
            <div class="row">
                <% for (Produit produit : produits) { %>
                <div class="col-md-4">
                    <div class="card mb-3">
                        <img src="<%= produit.getImage() %>" class="card-img-top" alt="Product Image">
                        <div class="card-body">
                            <h5 class="card-title"><%= produit.getName() %></h5>
                            <p class="card-text"><%= produit.getDescription() %></p>
                            <p class="card-text"><strong>Price:</strong> $<%= produit.getPrix() %></p>
                            <form action="product" method="post">
                                <input type="hidden" name="action" value="addToCart">
                                <input type="hidden" name="id" value="<%= produit.getId() %>">
                                <button type="submit" class="btn btn-primary">Add to Cart</button>
                            </form>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
        <style>
            .badge {
                font-size: 0.8rem;
                padding: 5px 8px;
                border-radius: 50%;
            }
        </style>


        <!-- 🔹 Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>