package com.example.pimpmyfirm;

class Noeud {
    private int id;
    private int Choix1;
    private int Choix2;
    private int Choix3;
    private int Choix4;
    private int Choix5;
    private int Choix6;
    private int Choix7;
    private int Choix8;
    private int Choix9;
    private int Choix10;
    private String texte;
    private int image;
    private String interlocuteur;
    private int noeud_suivant;
    private int numero_modification;

    public Noeud() {
    }

    public Noeud(int id, int Choix1, int Choix2, int Choix3, int Choix4, int Choix5, int Choix6, int Choix7, int Choix8, int Choix9, int Choix10, String texte, int image, String interlocuteur, int noeud_suivant, int numero_modification) {
        this.id = id;
        this.Choix1 = Choix1;
        this.Choix2 = Choix2;
        this.Choix3 = Choix3;
        this.Choix4 = Choix4;
        this.Choix5 = Choix5;
        this.Choix6 = Choix6;
        this.Choix7 = Choix7;
        this.Choix8 = Choix8;
        this.Choix9 = Choix9;
        this.Choix10 = Choix10;
        this.texte = texte;
        this.image = image;
        this.interlocuteur = interlocuteur;
        this.noeud_suivant = noeud_suivant;
        this.numero_modification = numero_modification;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int[] getChoix() {
        int[] t = {Choix1,Choix2,Choix3,Choix4,Choix5,Choix6,Choix7,Choix8,Choix9,Choix10};
        return t;
    }
    public void setChoix( int[] Liste_choix){
        this.Choix1 = Liste_choix[0];
        this.Choix2 = Liste_choix[1];
        this.Choix3 = Liste_choix[2];
        this.Choix4 = Liste_choix[3];
        this.Choix5 = Liste_choix[4];
        this.Choix6 = Liste_choix[5];
        this.Choix7 = Liste_choix[6];
        this.Choix8 = Liste_choix[7];
        this.Choix9 = Liste_choix[8];
        this.Choix10 = Liste_choix[9];
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public String getTexte(){return texte;}

    public void setImage(int image) {
        this.image = image;
    }
    public int getImage(){return image;}

    public void setInterlocuteur(String interlocuteur) { this.interlocuteur = interlocuteur; }
    public String getInterlocuteur(){return interlocuteur;}

    public void setNoeud_suivant(int noeud_suivant) { this.noeud_suivant = noeud_suivant; }
    public int getNoeud_suivant(){return noeud_suivant;}

    public void setNumero_modification(int numero_modification) { this.numero_modification = numero_modification; }
    public int getNumero_modification(){return numero_modification;}

    public String toString() {
        return "ID : " + id + "\nNumero des choix : " + Choix1 + " " + Choix2 + " " + Choix3 + " " + Choix4 + " " + Choix5 + " "
                + Choix6 + " " + Choix7 + " " + Choix8 + " " + Choix9 + " " + Choix10 
                + "\nTexte : " + texte + "\nImage : " + image + "\nInterlocuteur : " + interlocuteur + "\nNoeud_suivant : " + noeud_suivant
                + "\nNumero_modification" + numero_modification;
    }
}

