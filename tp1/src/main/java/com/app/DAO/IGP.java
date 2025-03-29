package com.app.DAO;
import com.app.metier.Produit;

import java.util.ArrayList;

public interface IGP {
    abstract public void ajouterProduit(String name, String description,int UserId,int prix,String image);
    abstract public ArrayList<Produit> getProduits(int UserId);
    abstract public void supprimerProduit(int id);
    abstract public void modifProduit(int id, String name, String description,int prix,String image);
    abstract public Produit getProduit(int id);
    abstract public ArrayList<Produit> rechercherProduit(int UserId,String search);
}
