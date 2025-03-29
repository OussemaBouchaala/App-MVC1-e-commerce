package com.app.metier;

public interface IGUM {
    abstract public void saveUser(String email, String password,String nom);
    abstract public User validateUser(String email, String password);

}
