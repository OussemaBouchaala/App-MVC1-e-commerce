package com.app.metier;

public class Produit {

    private String name;
    private int id;
    private int prix;
    private String image;
    private String description;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Produit(String name, int id, int prix, String image, String description) {
        this.name = name;
        this.id = id;
        this.prix = prix;
        this.image = image;
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
