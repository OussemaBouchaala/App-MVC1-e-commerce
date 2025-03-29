package com.project.metier;

public class Produit {
    private int id;
    private String name;
    private String description;
    private double prix;
    private String image;

    public Produit(int id ,  String name, String description, double prix, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
