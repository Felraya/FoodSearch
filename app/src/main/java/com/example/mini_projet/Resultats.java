package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultats extends AppCompatActivity {

    ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            return; }


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //modifier les données que l'on passe à la troisième activité une fois que le JSON fonctionne
                //Recette current = recettes.courante();
                Intent detailIntent = new Intent(Resultats.this, Description.class);
                //detailIntent.putExtra("tout",current);
                startActivity(detailIntent);
            }
    });
    }


}
