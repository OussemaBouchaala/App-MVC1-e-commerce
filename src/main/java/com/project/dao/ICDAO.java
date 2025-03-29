package com.project.dao;

import com.project.metier.Client;

public interface ICDAO {
    abstract public Client validateClient(String email, String password);
    abstract public boolean addClient(Client client);
}
