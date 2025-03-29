package com.project.metier;

public interface IGC {
    abstract public Client validateClient(String email, String password);
    abstract public boolean addClient(Client client);
}
