package com.example.pimpmyfirm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String TABLE_CHOIX = "table_choix";
    private static final String COL_ID_CHOIX = "ID";
    private static final String COL_NUMERO_NOEUD = "Numero_du_noeud";
    private static final String COL_NOM_DU_CHOIX = "Nom_du_choix";


    private static final String TABLE_NOEUDS = "table_noeuds";
    private static final String COL_ID_NOEUD = "ID";
    private static final String COL_NUM_CHOIX1 = "Numero_choix1";
    private static final String COL_NUM_CHOIX2 = "Numero_choix2";
    private static final String COL_NUM_CHOIX3 = "Numero_choix3";
    private static final String COL_NUM_CHOIX4 = "Numero_choix4";
    private static final String COL_NUM_CHOIX5 = "Numero_choix5";
    private static final String COL_NUM_CHOIX6 = "Numero_choix6";
    private static final String COL_NUM_CHOIX7 = "Numero_choix7";
    private static final String COL_NUM_CHOIX8 = "Numero_choix8";
    private static final String COL_NUM_CHOIX9 = "Numero_choix9";
    private static final String COL_NUM_CHOIX10 = "Numero_choix10";
    private static final String COL_TEXTE = "Texte";
    private static final String COL_IMAGE = "Image";
    private static final String COL_INTERLOCUTEUR = "Interlocuteur";
    private static final String COL_NOEUD_SUIVANT = "Texte_suivant";
    private static final String COL_NUMERO_MODIFICATIONS = "Numero_modification";

    private static final String CREATE_BDD_CHOIX = "CREATE TABLE " + TABLE_CHOIX + " (" +
            COL_ID_CHOIX + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NUMERO_NOEUD + " INTEGER, " +
            COL_NOM_DU_CHOIX + " TEXT);";

    private static final String CREATE_BDD_NOEUDS = "CREATE TABLE " + TABLE_NOEUDS + " (" +
            COL_ID_NOEUD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NUM_CHOIX1 + " INTEGER, " +
            COL_NUM_CHOIX2 + " INTEGER, " +
            COL_NUM_CHOIX3 + " INTEGER, " +
            COL_NUM_CHOIX4 + " INTEGER, " +
            COL_NUM_CHOIX5 + " INTEGER, " +
            COL_NUM_CHOIX6 + " INTEGER, " +
            COL_NUM_CHOIX7 + " INTEGER, " +
            COL_NUM_CHOIX8 + " INTEGER, " +
            COL_NUM_CHOIX9 + " INTEGER, " +
            COL_NUM_CHOIX10 + " INTEGER, " +
            COL_TEXTE + " TEXT, " +
            COL_IMAGE + " INTEGER, " +
            COL_INTERLOCUTEUR + " TEXT, " +
            COL_NOEUD_SUIVANT + " INTEGER, " +
            COL_NUMERO_MODIFICATIONS + " INTEGER);";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD_CHOIX);
        db.execSQL(CREATE_BDD_NOEUDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_CHOIX + ";");
        db.execSQL("DROP TABLE " + TABLE_NOEUDS + ";");
        onCreate(db);
    }

}