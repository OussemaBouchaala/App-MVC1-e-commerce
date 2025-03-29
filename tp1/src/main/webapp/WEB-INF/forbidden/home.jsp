<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 26/02/2025
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
<style>
    /* General Styles */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 20px;
    }

    /* Table Styling */
    table {
        width: 80%;
        margin: 20px 0;
        border-collapse: collapse;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    td {
        background-color: #f9f9f9;
    }

    td button {
        padding: 5px 10px;
        border: none;
        background-color: #e74c3c;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    td button:hover {
        background-color: #c0392b;
    }

    /* Form Styling */
    form {
        display: inline-block;
        margin-top: 10px;
        text-align: center;
    }

    form button {
        padding: 10px 20px;
        background-color: #3498db;
        color: white;
        border: none;
        cursor: pointer;
        font-size: 16px;
        margin: 5px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    form button:hover {
        background-color: #2980b9;
    }

    /* Button Container */
    button {
        font-size: 16px;
    }

</style>
</head>
<body>
<%@ page import="java.util.ArrayList,com.app.metier.Produit,com.app.metier.User" %>
<jsp:useBean id="produits" scope="request" type="java.util.ArrayList<com.app.metier.Produit>" />

<jsp:useBean id="user" scope="session" type="com.app.metier.User" />

<h1><%= "Bonjour "+user.getNom() %></h1>
<form action="Search" method="post">
    <input type="text" id="search" name="search" placeholder="rechercher Produit...">
    <button type="submit">confirmer</button>
</form>

<table border="1">
<thead>
<tr>
    <th>nom</th>
    <th>description</th>
    <th>prix</th>
    <th>image</th>
    <th ></th>
    <th ></th>

</tr>
</thead>
    <tbody>


<%for (int i=0;i<produits.size();i++){%>



    <tr>
        <td><%= produits.get(i).getName()%></td>
        <td><%=produits.get(i).getDescription()%></td>
        <td><%=produits.get(i).getPrix()%>Dinars</td>
        <td><img src="<%=produits.get(i).getImage()%>"></td>
       <td> <form action="Delete" method="post">
           <input type="text" id="id" name="id" value=<%=produits.get(i).getId()%> hidden>

            <button type="submit">supprimer</button>
        </form></td>
        <td> <form action="Update" method="post">
            <input type="text"  name="id" value=<%=produits.get(i).getId()%> hidden>

            <button type="submit">modifier</button>
        </form></td>
    </tr>
   <%}%>
    </tbody>
</table>

<form action="Add" method="post">

    <button type="submit">ajouter produit</button>
</form>


<form action="Logout" method="post">

    <button type="submit">se déconnecter</button>
</form>
</body>
</html>
