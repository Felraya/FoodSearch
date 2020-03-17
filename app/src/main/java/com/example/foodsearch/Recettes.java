package com.example.foodsearch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Recettes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recette);
    }
}



//search by ingredient avec parametre number pour limiter le nombre d'élément recherché
//autocomplete ingredient search

//requete :
//GET https://api.spoonacular.com/recipes/complexSearch?cuisine=italian&includeIngredients=cheese&number=5&apiKey=ba201988b5134067a8a4312ed8bf783c

