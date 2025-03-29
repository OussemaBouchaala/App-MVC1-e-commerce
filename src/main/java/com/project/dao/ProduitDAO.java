package com.project.dao;

import com.project.metier.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO implements IPDAO{
    private final Connection con;

    public ProduitDAO() throws SQLException {
        this.con = DBConnection.getConnection();
    }

    @Override
    // Method to add a product
    public boolean addProduit(Produit produit) {
        String sql = "INSERT INTO produits (name, description, prix, image) VALUES (?, ?, ?, ?)";
        try {
            // Load the SQL Server JDBC Driver

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, produit.getName());
            ps.setString(2, produit.getDescription());
            ps.setDouble(3, produit.getPrix());
            ps.setString(4, produit.getImage());

            int rowsInserted = ps.executeUpdate();

            ps.close();
            con.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to get all products
    @Override
    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produits")) {

            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("prix"),
                        rs.getString("image")
                );
                produits.add(produit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produits;
    }


    // Method to update a product
    @Override
    public void updateProduit(Produit produit) {
        String sql = "UPDATE produits SET name=?, description=?, prix=?, image=? WHERE id=?";
        try {
            // Load the SQL Server JDBC Driver

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, produit.getName());
            ps.setString(2, produit.getDescription());
            ps.setDouble(3, produit.getPrix());
            ps.setString(4, produit.getImage());
            ps.setInt(5, produit.getId());
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a product by ID
    @Override
    public void deleteProduit(int id) {
        String sql = "DELETE FROM produits WHERE id=?";
        try {
            // Load the SQL Server JDBC Driver

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a product by ID
    @Override
    public Produit getProduitById(int id) {
        String sql = "SELECT * FROM produits WHERE id=?";
        try {
            // Load the SQL Server JDBC Driver

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Produit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("prix"),
                        rs.getString("image")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
