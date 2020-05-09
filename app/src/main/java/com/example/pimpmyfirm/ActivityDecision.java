package com.example.pimpmyfirm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityDecision extends AppCompatActivity {
    private int[] liste_choix = {0,0,0,0,0,0,0,0,0,0};
    private Noeud noeud_en_cours = null;
    private int numero_noeud = 0;
    private TextView texte = null;
    private ConstraintLayout layout = null;
    private Button bouton_choix1 = null;
    private Button bouton_choix2 = null;
    private Button bouton_choix3 = null;
    private Button bouton_choix4 = null;
    private Button bouton_choix5 = null;
    private Button bouton_choix6 = null;
    private Button bouton_choix7 = null;
    private Button bouton_choix8 = null;
    private Button bouton_choix9 = null;
    private Button bouton_choix10 = null;
    private Button[] liste_bouton = null;
    ChoixBDD ChoixBDD = new ChoixBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On récupére le noeux en cours (la seule chose importante)
        ChoixBDD.open();
        Intent intent = getIntent();
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_decision, null);
        texte = layout.findViewById(R.id.texte);
        numero_noeud = intent.getIntExtra("Noeud",0);
        noeud_en_cours = ChoixBDD.getNoeudWithID(numero_noeud);
        texte.setText(noeud_en_cours.getTexte());

        // On créé tous les boutons
        bouton_choix1 = layout.findViewById(R.id.button_choix1);
        bouton_choix2 = layout.findViewById(R.id.button_choix2);
        bouton_choix3 = layout.findViewById(R.id.button_choix3);
        bouton_choix4 = layout.findViewById(R.id.button_choix4);
        bouton_choix5 = layout.findViewById(R.id.button_choix5);
        bouton_choix6 = layout.findViewById(R.id.button_choix6);
        bouton_choix7 = layout.findViewById(R.id.button_choix7);
        bouton_choix8 = layout.findViewById(R.id.button_choix8);
        bouton_choix9 = layout.findViewById(R.id.button_choix9);
        bouton_choix10 = layout.findViewById(R.id.button_choix10);
        liste_bouton = new Button[]{bouton_choix1, bouton_choix2, bouton_choix3, bouton_choix4, bouton_choix5, bouton_choix6, bouton_choix7, bouton_choix8, bouton_choix9, bouton_choix10};

        setContentView(layout);

       for (int i = 0; i < 10; i++) {
           if (liste_choix[i] != 0){

           }
       }
    }
}
