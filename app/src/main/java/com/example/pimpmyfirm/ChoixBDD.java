package com.example.pimpmyfirm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ChoixBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "choix.db";

    private static final String TABLE_CHOIX = "table_choix";
    private static final String COL_ID_CHOIX = "ID";
    private static final int NUM_COL_ID_CHOIX = 0;
    private static final String COL_NUMERO_NOEUD = "Numero_du_noeud";
    private static final int NUM_COL_NUMERO_NOEUD = 1;
    private static final String COL_NOM_DU_CHOIX = "Nom_du_choix";
    private static final int NUM_COL_NOM_DU_CHOIX = 2;

    private static final String TABLE_NOEUDS = "table_noeuds";
    private static final String COL_ID_NOEUD = "ID";
    private static final int NUM_COL_ID_NOEUD = 0;
    private static final String COL_CHOIX1 = "Numero_choix1";
    private static final int NUM_COL_CHOIX1 = 1;
    private static final String COL_CHOIX2 = "Numero_choix2";
    private static final int NUM_COL_CHOIX2 = 2;
    private static final String COL_CHOIX3 = "Numero_choix3";
    private static final int NUM_COL_CHOIX3 = 3;
    private static final String COL_CHOIX4 = "Numero_choix4";
    private static final int NUM_COL_CHOIX4 = 4;
    private static final String COL_CHOIX5 = "Numero_choix5";
    private static final int NUM_COL_CHOIX5 = 5;
    private static final String COL_CHOIX6 = "Numero_choix6";
    private static final int NUM_COL_CHOIX6 = 6;
    private static final String COL_CHOIX7 = "Numero_choix7";
    private static final int NUM_COL_CHOIX7 = 7;
    private static final String COL_CHOIX8 = "Numero_choix8";
    private static final int NUM_COL_CHOIX8 = 8;
    private static final String COL_CHOIX9 = "Numero_choix9";
    private static final int NUM_COL_CHOIX9 = 9;
    private static final String COL_CHOIX10 = "Numero_choix10";
    private static final int NUM_COL_CHOIX10 = 10;
    private static final String COL_TEXTE = "Texte";
    private static final int NUM_COL_TEXTE = 11;
    private static final String COL_IMAGE = "Image";
    private static final int NUM_COL_IMAGE= 12;
    private static final String COL_INTERLOCUTEUR = "Interlocuteur";
    private static final int NUM_COL_INTERLOCUTEUR = 13;
    private static final String COL_NOEUD_SUIVANT = "Texte_suivant";
    private static final int NUM_COL_NOEUD_SUIVANT = 14;
    private static final String COL_NUMERO_MODIFICATION = "Numero_modification";
    private static final int NUM_COL_NUMERO_MODIFICATION = 15;

    private SQLiteDatabase bdd;

    private DatabaseHandler DatabaseHandler;

    public ChoixBDD(Context context){
        //On crée la BDD et sa table
        DatabaseHandler = new DatabaseHandler(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = DatabaseHandler.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertChoix(Choix Choix){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID_CHOIX, Choix.getId());
        values.put(COL_NUMERO_NOEUD, Choix.getNumero_du_noeud());
        values.put(COL_NOM_DU_CHOIX, Choix.getNom_du_choix());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_CHOIX, null, values);
    }
    public long insertNoeud(Noeud Noeud){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ID_NOEUD, Noeud.getId());
        values.put(COL_CHOIX1, Noeud.getChoix()[0]);
        values.put(COL_CHOIX2, Noeud.getChoix()[1]);
        values.put(COL_CHOIX3, Noeud.getChoix()[2]);
        values.put(COL_CHOIX4, Noeud.getChoix()[3]);
        values.put(COL_CHOIX5, Noeud.getChoix()[4]);
        values.put(COL_CHOIX6, Noeud.getChoix()[5]);
        values.put(COL_CHOIX7, Noeud.getChoix()[6]);
        values.put(COL_CHOIX8, Noeud.getChoix()[7]);
        values.put(COL_CHOIX9, Noeud.getChoix()[8]);
        values.put(COL_CHOIX10, Noeud.getChoix()[9]);
        values.put(COL_TEXTE, Noeud.getTexte());
        values.put(COL_IMAGE, Noeud.getImage());
        values.put(COL_INTERLOCUTEUR, Noeud.getInterlocuteur());
        values.put(COL_NOEUD_SUIVANT, Noeud.getNoeud_suivant());
        values.put(COL_NUMERO_MODIFICATION, Noeud.getNumero_modification());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_NOEUDS, null, values);
    }

    public int updateChoix(int id, Choix Choix){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_NUMERO_NOEUD, Choix.getNumero_du_noeud());
        values.put(COL_NOM_DU_CHOIX, Choix.getNom_du_choix());
        return bdd.update(TABLE_CHOIX, values, COL_ID_CHOIX + " = " +id, null);
    }
    public int updateNoeud(int id, Noeud Noeud){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_CHOIX1, Noeud.getChoix()[0]);
        values.put(COL_CHOIX2, Noeud.getChoix()[1]);
        values.put(COL_CHOIX3, Noeud.getChoix()[2]);
        values.put(COL_CHOIX4, Noeud.getChoix()[3]);
        values.put(COL_CHOIX5, Noeud.getChoix()[4]);
        values.put(COL_CHOIX6, Noeud.getChoix()[5]);
        values.put(COL_CHOIX7, Noeud.getChoix()[6]);
        values.put(COL_CHOIX8, Noeud.getChoix()[7]);
        values.put(COL_CHOIX9, Noeud.getChoix()[8]);
        values.put(COL_CHOIX10, Noeud.getChoix()[9]);
        values.put(COL_TEXTE, Noeud.getTexte());
        values.put(COL_IMAGE, Noeud.getImage());
        values.put(COL_INTERLOCUTEUR, Noeud.getInterlocuteur());
        values.put(COL_NOEUD_SUIVANT, Noeud.getNoeud_suivant());
        values.put(COL_NUMERO_MODIFICATION, Noeud.getNumero_modification());
        return bdd.update(TABLE_NOEUDS, values, COL_ID_NOEUD + " = " +id, null);
    }

    public void removeChoixWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        bdd.delete(TABLE_CHOIX, COL_ID_CHOIX + " = " +id, null);
    }

    public void removeNoeudWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        bdd.delete(TABLE_NOEUDS, COL_ID_NOEUD + " = " +id, null);
    }

    public Choix getChoixWithNOM(String nom){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.rawQuery("SELECT * FROM " + TABLE_CHOIX + " WHERE " + COL_NOM_DU_CHOIX + " = ?", new String[]{nom});
        return cursorToChoix(c);
    }

    public Choix getChoixWithID(int id){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.rawQuery("SELECT * FROM " + TABLE_CHOIX + " WHERE " + COL_ID_CHOIX + " = " + Integer.toString(id), null);
        return cursorToChoix(c);
    }
    public Noeud getNoeudWithID(int id){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        //Cursor c = bdd.query(TABLE_NOEUDS, new String[] {COL_ID_NOEUD, COL_CHOIX1,COL_CHOIX2,COL_CHOIX3, COL_CHOIX4, COL_CHOIX5, COL_CHOIX6, COL_CHOIX7, COL_CHOIX8, COL_CHOIX9, COL_CHOIX10, COL_TEXTE, COL_IMAGE, COL_INTERLOCUTEUR, COL_NOEUD_SUIVANT, COL_NUMERO_MODIFICATION},COL_ID_NOEUD + " = " + Integer.toString(id), null, null, null, null);
        Cursor c = bdd.rawQuery("SELECT * FROM " + TABLE_NOEUDS + " WHERE " + COL_ID_NOEUD + " = " + Integer.toString(id), null);

        return cursorToNoeud(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Choix cursorToChoix(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0) {
            return null;
        }
        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Choix Choix = new Choix();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        Choix.setId(c.getInt(NUM_COL_ID_CHOIX));
        Choix.setNumero_du_noeud(c.getInt(NUM_COL_NUMERO_NOEUD));
        Choix.setNom_du_choix(c.getString(NUM_COL_NOM_DU_CHOIX));
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return Choix;
    }
    private Noeud cursorToNoeud(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0) {
            return null;
        }
        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Noeud Noeud = new Noeud();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        Noeud.setId(c.getInt(NUM_COL_ID_NOEUD));
        Noeud.setChoix(new int[]{c.getInt(NUM_COL_CHOIX1), c.getInt(NUM_COL_CHOIX2), c.getInt(NUM_COL_CHOIX3), c.getInt(NUM_COL_CHOIX4), c.getInt(NUM_COL_CHOIX5), c.getInt(NUM_COL_CHOIX6), c.getInt(NUM_COL_CHOIX7), c.getInt(NUM_COL_CHOIX8), c.getInt(NUM_COL_CHOIX9), c.getInt(NUM_COL_CHOIX10)});
        Noeud.setTexte(c.getString(NUM_COL_TEXTE));
        Noeud.setImage(c.getInt(NUM_COL_IMAGE));
        Noeud.setNumero_modification(c.getInt(NUM_COL_NUMERO_MODIFICATION));
        Noeud.setInterlocuteur(c.getString(NUM_COL_INTERLOCUTEUR));
        Noeud.setNoeud_suivant(c.getInt(NUM_COL_NOEUD_SUIVANT));
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return Noeud;
    }
}