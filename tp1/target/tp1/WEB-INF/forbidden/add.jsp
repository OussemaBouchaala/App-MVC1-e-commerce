<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 01/03/2025
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <style>
        /* General Body Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Form Container */
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        /* Form Label Styling */
        label {
            font-size: 16px;
            color: #333;
            display: block;
            margin-bottom: 8px;
        }

        /* Input Field Styling */
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
            color: #333;
        }

        /* Submit Button Styling */
        button {
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<form action="Add" method="post">
    <label for="name">nom</label>
    <input type="text" id="name" name="name">

    <label for="description">description</label>
    <input type="text" id="description" name="description">

    <button type="submit">ajouter produit</button>
</form>
</body>
</html>
