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
    private Choix Choix_en_cours = null;
    private Noeud[] tableau_noeud1 = null;
    private Choix[] tableau_choix1 = null;
    ChoixBDD ChoixBDD = new ChoixBDD(this);

    //On définit les boutons qui serviront aux choix
    private Button bouton_choix1 = null;
    private Button bouton_choix2 = null;
    private Button bouton_choix3 = null;
    private Button bouton_choix4 = null;
    private Button[] liste_boutons_choix = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ChoixBDD.open();
        super.onCreate(savedInstanceState);
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_main, null);
        nom_personnage = layout.findViewById(R.id.nom_personnage);
        texte_du_noeud_en_cours = layout.findViewById(R.id.texte_du_noeud_en_cours);
        bouton_next = layout.findViewById(R.id.bouton_next);
        bouton_choix1 = layout.findViewById(R.id.bouton_choix1);
        bouton_choix2 = layout.findViewById(R.id.bouton_choix2);
        bouton_choix3 = layout.findViewById(R.id.bouton_choix3);
        bouton_choix4 = layout.findViewById(R.id.bouton_choix4);
        liste_boutons_choix = new Button[]{bouton_choix1,bouton_choix2, bouton_choix3, bouton_choix4};
        layout.setBackgroundResource(R.drawable.fond);

        Choix Choix101 = new Choix(101,102,"Visiter les locaux (tutoriel)");
        Choix Choix102 = new Choix(102,122,"Pas de temps à perdre, au travail !");
        Choix Choix103 = new Choix(103,128,"Acheter de meilleures chaises de bureau !");
        Choix Choix104 = new Choix(104,127,"Acheter des machines plus performantes ");
        Choix Choix105 = new Choix(105,126,"Organiser un afterwork au frais de LA COMPAGNIE ");

        Noeud Noeud001 = new Noeud(001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "Prêt à démarrer",R.drawable.fond_directeur_commercial,"LE JEU",101,0);
        Noeud Noeud101 = new Noeud(101, 101, 102, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud101),R.drawable.fond_directeur_commercial,"Directeur marketing",102,0);
        Noeud Noeud102 = new Noeud(102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud102),R.drawable.fond_directeur_commercial,"Directeur marketing",103,0);
        Noeud Noeud103 = new Noeud(103, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud103),R.drawable.fond_directeur_commercial, "Directeur marketing",104,0);
        Noeud Noeud104 = new Noeud(104, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud104),R.drawable.fond_directeur_technique,"Directeur technique",105,0);
        Noeud Noeud105 = new Noeud(105, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud105),R.drawable.fond_directeur_technique,"Directeur technique",106,0);
        Noeud Noeud106 = new Noeud(106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud106),R.drawable.fond_directeur_technique,"Directeur technique",107,0);
        Noeud Noeud107 = new Noeud(107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud107),R.drawable.fond_directeur_technique,"Directeur technique",108,0);
        Noeud Noeud108 = new Noeud(108, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud108),R.drawable.fond_directeur_technique,"Directeur technique",109,0);
        Noeud Noeud109 = new Noeud(109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud109),R.drawable.fond_directeur_technique,"Directeur technique",110,0);
        Noeud Noeud110 = new Noeud(110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud110),R.drawable.fond_directeur_technique,"Directeur technique",111,0);
        Noeud Noeud111 = new Noeud(111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud111),R.drawable.fond_directeur_technique,"Directeur technique",112,0);
        Noeud Noeud112 = new Noeud(112, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud112),R.drawable.fond_representant_des_actionnaires,"Directeur technique",113,0);
        Noeud Noeud113 = new Noeud(113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud113),R.drawable.fond_directeur_technique,"Directeur technique",114,0);
        Noeud Noeud114 = new Noeud(114, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud114),R.drawable.fond_directeur_technique,"Directeur technique",115,0);
        Noeud Noeud115 = new Noeud(115, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud115),R.drawable.fond_directeur_technique,"Directeur technique",116,0);
        Noeud Noeud116 = new Noeud(116, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud116),R.drawable.fond_directeur_technique,"Directeur technique",117,0);
        Noeud Noeud117 = new Noeud(117, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud117),R.drawable.fond_directeur_technique,"Directeur technique",118,0);
        Noeud Noeud118 = new Noeud(118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud118),R.drawable.fond_directeur_technique,"Directeur technique",119,0);
        Noeud Noeud119 = new Noeud(119, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud119),R.drawable.fond_directeur_technique,"Directeur technique",120,0);
        Noeud Noeud120 = new Noeud(120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud120),R.drawable.fond_directeur_technique,"Directeur technique",121,0);
        Noeud Noeud121 = new Noeud(121, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud121),R.drawable.fond_directeur_technique,"Directeur technique",122,0);
        Noeud Noeud122 = new Noeud(122, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud122),R.drawable.fond_directeur_technique,"Directeur technique",123,0);
        Noeud Noeud123 = new Noeud(123, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud123),R.drawable.fond_directeur_technique,"Directeur technique",124,0);
        Noeud Noeud124 = new Noeud(124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud124),R.drawable.fond_directeur_technique,"Directeur technique",125,0);
        Noeud Noeud125 = new Noeud(125, 103, 104, 105, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud125),R.drawable.fond_directeur_technique,"Directeur technique",0,0);
        Noeud Noeud126 = new Noeud(126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud126),R.drawable.fond_directeur_technique,"Directeur technique",129,0);
        Noeud Noeud127 = new Noeud(127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud127),R.drawable.fond_directeur_technique,"Directeur technique",129,0);
        Noeud Noeud128 = new Noeud(128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud128),R.drawable.fond_directeur_technique,"Directeur technique",129,0);
        Noeud Noeud129 = new Noeud(129, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud129),R.drawable.fond_directeur_technique,"Directeur technique",130,0);
        Noeud Noeud130 = new Noeud(130,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud130),R.drawable.fond_directeur_technique,"Directeur technique",201,0);
        Noeud Noeud131 = new Noeud(131, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud131),R.drawable.fond_directeur_technique,"Directeur technique",201,0);
        Noeud Noeud132 = new Noeud(132, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, getString(R.string.Noeud132),R.drawable.fond_directeur_technique,"Directeur technique",201,0);


        tableau_noeud1 = new Noeud[]{Noeud101, Noeud102, Noeud103, Noeud104, Noeud105, Noeud106, Noeud107, Noeud108, Noeud109, Noeud110, Noeud111, Noeud112, Noeud113, Noeud114, Noeud115, Noeud116, Noeud117, Noeud118, Noeud119, Noeud120, Noeud121, Noeud122, Noeud123, Noeud124,Noeud125, Noeud126, Noeud127, Noeud128, Noeud129, Noeud130, Noeud131, Noeud132};
        tableau_choix1 = new Choix[]{Choix101,Choix102,Choix103,Choix104,Choix105};
        // On vide et on re-remplit la base de données
        for (int i = 1; i < 200; i++) {
            ChoixBDD.removeNoeudWithID(i);
        }
        for (int i = 1; i < 200; i++) {
            ChoixBDD.removeChoixWithID(i);
        }
        for (int i = 0; i < tableau_noeud1.length; i++) { ChoixBDD.insertNoeud(tableau_noeud1[i]); }
        for (int i = 0; i < tableau_choix1.length; i++) { ChoixBDD.insertChoix(tableau_choix1[i]); }


        //initialisation
        Noeud_en_cours = Noeud001;
        bouton_next.setText("Next");
        texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
        nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
        layout.setBackgroundResource(Noeud_en_cours.getImage());
        setContentView(layout);

        // On désaffiche les boutons. Ils seront affichés quand on aura un choix à faire
        for(int i =0;i<liste_boutons_choix.length;i++){
            liste_boutons_choix[i].setVisibility(View.INVISIBLE);
            liste_boutons_choix[i].setOnClickListener(this);
        }
        bouton_next.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // Si on a cliquez sur continuer
        if (v.getId() == R.id.bouton_next) {
            // Si il n'y a pas de choix à faire :
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Noeud_en_cours.getNoeud_suivant());
            if (Noeud_en_cours.getChoix()[1] == 0) {
                texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
                nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
                layout.setBackgroundResource(Noeud_en_cours.getImage());
                setContentView(layout);
            } else {
                // Sinon cela signifie que le joueur doit selectionner un choix
                // On parcourt la liste des choix et on affiche les boutons correspondants
                for (int i = 0; i < Noeud_en_cours.getChoix().length; i++) {
                    if (Noeud_en_cours.getChoix()[i] != 0) {
                        liste_boutons_choix[i].setVisibility(View.VISIBLE);
                        Choix_en_cours = ChoixBDD.getChoixWithID(Noeud_en_cours.getChoix()[i]);
                        liste_boutons_choix[i].setText(Choix_en_cours.getNom_du_choix());
                    }
                }
                bouton_next.setVisibility(View.GONE);
                texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
                nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
                layout.setBackgroundResource(Noeud_en_cours.getImage());
                setContentView(layout);
            }
        }
        // Doublons de code à supprimer ici
        if (v.getId() == R.id.bouton_choix1 ){
            bouton_next.setVisibility(View.VISIBLE);
            Choix_en_cours = ChoixBDD.getChoixWithID(Noeud_en_cours.getChoix()[0]);
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Choix_en_cours.getNumero_du_noeud());
            texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
            nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
            layout.setBackgroundResource(Noeud_en_cours.getImage());
            for(int i =0;i<liste_boutons_choix.length;i++){
                liste_boutons_choix[i].setVisibility(View.INVISIBLE);
            }
            setContentView(layout);
        }
        if (v.getId() == R.id.bouton_choix2 ){
            bouton_next.setVisibility(View.VISIBLE);
            Choix_en_cours = ChoixBDD.getChoixWithID(Noeud_en_cours.getChoix()[1]);
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Choix_en_cours.getNumero_du_noeud());
            texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
            nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
            layout.setBackgroundResource(Noeud_en_cours.getImage());
            for(int i =0;i<liste_boutons_choix.length;i++){
                liste_boutons_choix[i].setVisibility(View.INVISIBLE);
            }
            setContentView(layout);
        }
        if (v.getId() == R.id.bouton_choix3 ){
            bouton_next.setVisibility(View.VISIBLE);
            Choix_en_cours = ChoixBDD.getChoixWithID(Noeud_en_cours.getChoix()[2]);
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Choix_en_cours.getNumero_du_noeud());
            texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
            nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
            layout.setBackgroundResource(Noeud_en_cours.getImage());
            for(int i =0;i<liste_boutons_choix.length;i++){
                liste_boutons_choix[i].setVisibility(View.INVISIBLE);
            }
            setContentView(layout);
        }
        if (v.getId() == R.id.bouton_choix4 ){
            bouton_next.setVisibility(View.VISIBLE);
            Choix_en_cours = ChoixBDD.getChoixWithID(Noeud_en_cours.getChoix()[3]);
            Noeud_en_cours = ChoixBDD.getNoeudWithID(Choix_en_cours.getNumero_du_noeud());
            texte_du_noeud_en_cours.setText(Noeud_en_cours.getTexte());
            nom_personnage.setText(Noeud_en_cours.getInterlocuteur());
            layout.setBackgroundResource(Noeud_en_cours.getImage());
            for(int i =0;i<liste_boutons_choix.length;i++){
                liste_boutons_choix[i].setVisibility(View.INVISIBLE);
            }
            setContentView(layout);
        }
    }

}
