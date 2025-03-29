package com.project.metier;

import com.project.dao.ClientDAO;

import java.sql.SQLException;

public class GestionClient implements IGC{

    private final ClientDAO clientDAO;

    public GestionClient() throws SQLException {
        this.clientDAO = new ClientDAO();
    }

    @Override
    public Client validateClient(String email, String password) {
        return clientDAO.validateClient(email,password);
    }

    @Override
    public boolean addClient(Client client) {
        return clientDAO.addClient(client);
    }


}
