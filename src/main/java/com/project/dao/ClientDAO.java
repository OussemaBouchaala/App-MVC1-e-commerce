package com.project.dao;

import com.project.metier.Client;

import java.sql.*;

public class ClientDAO implements ICDAO{
    private final Connection con;

    public ClientDAO() throws SQLException {
        this.con = DBConnection.getConnection();
    }

    @Override
    // ✅ Method to validate client login
    public Client validateClient(String email, String password) {
        String sql = "SELECT * FROM clients WHERE email = ? AND password_hash = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password); // ⚠️ Use hashed passwords in real applications

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password_hash")
                );
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // No user found
    }

    @Override
    // ✅ Other methods (unchanged)
    public boolean addClient(Client client) {
        String query = "INSERT INTO clients (name, email, password_hash) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPassword());

            int rowsInserted = ps.executeUpdate();

            ps.close();
            con.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
