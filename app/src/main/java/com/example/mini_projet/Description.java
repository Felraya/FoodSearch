package com.example.mini_projet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

public class Description extends AppCompatActivity {

    private ImageView image;
    private TextView titre;
    private TextView time;
    private TextView recette;
    private String apiKey = "f4191411045d45d0aed31c69627d5499";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        image = findViewById(R.id.image);
        titre = findViewById(R.id.titre);
        time = findViewById(R.id.time);
        recette = findViewById(R.id.recette);


    }
}
