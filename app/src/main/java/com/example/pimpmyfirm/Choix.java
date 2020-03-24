package com.example.pimpmyfirm;

class Choix {
    private int id;
    private int numero_du_noeud;
    private String nom_du_choix;

    public Choix() {
    }

    public Choix(int id, int numero_du_noeud, String nom_du_choix) {
        this.id = id;
        this.numero_du_noeud = numero_du_noeud;
        this.nom_du_choix = nom_du_choix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_du_noeud() {
        return numero_du_noeud;
    }

    public void setNumero_du_noeud(int numero_du_noeud) {
        this.numero_du_noeud = numero_du_noeud;
    }

    public String getNom_du_choix() {
        return nom_du_choix;
    }

    public void setNom_du_choix(String nom_du_choix) {
        this.nom_du_choix = nom_du_choix;
    }

    public String toString() {
        return "ID : " + id + "\nNumero du Noeud : " + numero_du_noeud + "\nNom du choix : " + nom_du_choix;
    }
}
