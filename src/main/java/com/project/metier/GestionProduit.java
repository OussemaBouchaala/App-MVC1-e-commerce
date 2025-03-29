package com.project.metier;

import com.project.dao.ProduitDAO;

import java.sql.SQLException;
import java.util.List;

public class GestionProduit implements IGP {
    private final ProduitDAO produitDAO;

    public GestionProduit() throws SQLException {
        this.produitDAO = new ProduitDAO();
    }

    @Override
    public boolean addProduit(Produit produit) {
        return produitDAO.addProduit(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitDAO.updateProduit(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitDAO.getAllProduits();
    }

    @Override
    public Produit getProduitById(int id) {
        return produitDAO.getProduitById(id);
    }

    @Override
    public void deleteProduit(int id) {
        produitDAO.deleteProduit(id);
    }

}
