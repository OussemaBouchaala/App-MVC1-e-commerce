package com.app.DAO;

import com.app.metier.User;

public interface IGU {
    abstract public void saveUser(String email, String password,String nom);
    abstract public User validateUser(String email, String password);
}
