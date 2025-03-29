package com.project.dao;

import com.project.metier.Produit;

import java.util.List;

public interface IPDAO {
    abstract public boolean addProduit(Produit produit);
    abstract public void updateProduit(Produit produit);
    abstract public void deleteProduit(int id);
    abstract public Produit getProduitById(int id);
    abstract public List<Produit> getAllProduits();
}
