package com.example.pimpmyfirm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView texte_du_noeud_en_cours = null;
    ConstraintLayout layout = null;
    private Button bouton_next = null;
    private TextView nom_personnage = null;
    private Noeud Noeud_en_cours = null;
    private Noeud[] tableau_noeud1 = null;
    ChoixBDD ChoixBDD = new ChoixBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ChoixBDD.open();
        super.onCreate(savedInstanceState);
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_main, null);
        nom_personnage = layout.findViewById(R.id.nom_personnage);
        texte_du_noeud_en_cours = layout.findViewById(R.id.texte_du_noeud_en_cours);
        bouton_next = layout.findViewById(R.id.bouton_next);
        layout.setBackgroundResource(R.drawable.fond);

        Noeud Noeud101 = new Noeud(101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud101),R.drawable.fond_directeur_commercial,"Directeur marketing",102,0);
        Noeud Noeud102 = new Noeud(102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud102),R.drawable.fond_directeur_commercial,"Directeur marketing",103,0);
        Noeud Noeud103 = new Noeud(103, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud103),R.drawable.fond_directeur_commercial, "Directeur marketing",104,0);
        Noeud Noeud104 = new Noeud(104, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud104),R.drawable.fond_directeur_technique,"Directeur technique",105,0);

        tableau_noeud1 = new Noeud[]{Noeud101, Noeud102, Noeud103, Noeud104};
        for (int i = 1; i < 200; i++) {
            ChoixBDD.removeNoeudWithID(i);
        }
        for (int i = 0; i < tableau_noeud1.length; i++) { ChoixBDD.insertNoeud(tableau_noeud1[i]); }


        //initialisation
        Noeud_en_cours = Noeud101;
        bouton_next.setText("Next");
        texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
        nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
        setContentView(layout);
        bouton_next.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bouton_next) {
            int t = Noeud_en_cours.getNoeud_suivant();
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Noeud_en_cours.getNoeud_suivant());
            texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
            nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
            layout.setBackgroundResource(Noeud_en_cours.getImage());
            setContentView(layout);
        }
    }

}
