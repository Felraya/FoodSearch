package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

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

    private String img;
    private String title;
    private int temps;
    private String desc;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        image = findViewById(R.id.image);
        titre = findViewById(R.id.titre);
        time = findViewById(R.id.time);
        recette = findViewById(R.id.recette);

        Intent intent = getIntent();
        img = intent.getStringExtra("img");
        //title = intent.getStringExtra("titre");
        desc = intent.getStringExtra("recette");
        temps = intent.getIntExtra("temps", 0);
        //System.out.println(img);
        Picasso.get().load(img).into(image);
        titre.setText(title);
        recette.setText(desc);
        time.setText(String.valueOf(temps)+"'");
        recette.setMovementMethod(new ScrollingMovementMethod());



    }
}
