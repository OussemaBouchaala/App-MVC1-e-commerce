package com.app.metier;

import com.app.DAO.GestionUserDAO;
import com.app.DAO.IGU;
import com.app.metier.IGUM;

public class GerstionUser implements IGUM {
    IGU gestionUser=new GestionUserDAO();
    @Override
    public User validateUser(String email,String password){
    return gestionUser.validateUser(email,password);
}

    @Override
    public void saveUser(String email, String password,String nom) {
        gestionUser.saveUser(email,password,nom);
    }


}
