package com.project.metier;

import java.util.List;

public interface IGP {
    abstract public boolean addProduit(Produit p);
    abstract public void updateProduit(Produit p);
    abstract public List<Produit> getAllProduits();
    abstract public Produit getProduitById(int id);
    abstract public void deleteProduit(int id);
}
