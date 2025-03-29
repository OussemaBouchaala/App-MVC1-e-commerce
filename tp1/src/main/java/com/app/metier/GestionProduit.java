package com.app.metier;

import com.app.DAO.IGP;
import com.app.DAO.gestionProduitDAO;

import java.util.ArrayList;

public class GestionProduit implements IGPM{
    public IGP gestionProduits=new gestionProduitDAO();
    @Override
    public void ajouterProduit(String name, String description,int UserId,int prix,String image) {
        gestionProduits.ajouterProduit(name, description,UserId,prix,image);

    }
    @Override
    public Produit getProduit(int id){
        return gestionProduits.getProduit(id);
    }

    @Override
    public ArrayList<Produit> rechercherProduit(int UserId, String search) {
        return gestionProduits.rechercherProduit(UserId,search);
    }

    @Override
    public ArrayList<Produit> getProduits(int UserID) {
        return gestionProduits.getProduits(UserID);
    }

    @Override
    public void supprimerProduit(int id) {
    gestionProduits.supprimerProduit(id);
    }

    @Override
    public void modifProduit(int id, String name, String description,int prix,String image) {
    gestionProduits.modifProduit(id, name, description,prix,image);
    }

}
