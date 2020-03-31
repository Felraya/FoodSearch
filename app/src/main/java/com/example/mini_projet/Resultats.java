package com.example.mini_projet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class Resultats extends AppCompatActivity {

    ArrayList<String> list;
    ArrayList<Integer> listId;

    private String apiKey = "f4191411045d45d0aed31c69627d5499";
    ListView listview;

    String urlImg;
    String instruc;
    int temps;
    String titre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        Intent intent = getIntent();
        list = intent.getStringArrayListExtra("titre");
        listId = intent.getIntegerArrayListExtra("id");

        listview = findViewById(R.id.results);
        if(list != null) {
            ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            listview.setAdapter(aa);
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listview.getItemAtPosition(position);
                int i = listId.get(position);
                final Intent in = new Intent(Resultats.this,Description.class);
                Ion.with(view.getContext())
                        .load( "https://api.spoonacular.com/recipes/"+i+"/information?apiKey="+apiKey)
                        .setLogging("ION_LOGS", Log.DEBUG)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                // do stuff with the result of error
                                //System.out.println(result.get("image").getAsString());
                                System.out.println(result);
                                if(result.get("image") == null || result.get("image") instanceof JsonNull) {
                                    urlImg = "/ETCHEBOOMER.png";
                                } else {
                                    urlImg = result.get("image").getAsString();
                                }

                                if(result.get("instructions") == null || result.get("instructions") instanceof JsonNull) {
                                    instruc = "Pas d'instructions de recette";
                                } else {
                                    instruc = result.get("instructions").getAsString();
                                }
                                if(result.get("cookingMinutes") == null || result.get("cookingMinutes") instanceof JsonNull) {
                                    temps = 0;
                                } else {
                                    temps = result.get("cookingMinutes").getAsInt();
                                }

                                // Intent start other activity



                                in.putExtra("img",urlImg);
                                in.putExtra("recette",instruc);
                                in.putExtra("titre", titre);
                                in.putExtra("temps", temps);
                                in.putExtra("titre", item);
                                startActivity(in);
                                finish();

                            }

                        });
            }

        });



    }
}
