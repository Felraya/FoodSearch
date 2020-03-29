package com.example.mini_projet;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class ListGenre extends AppCompatActivity {

    private SeekBar resultats;
    private Spinner spinner;
    private Button bouton;
    private EditText search;
    private String itemSpinner;
    private int itemSeekBar;
    private String keyWord;
    private String apiKey = "f4191411045d45d0aed31c69627d5499";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultats = findViewById(R.id.seekBar);
        spinner = findViewById(R.id.spinner);
        bouton = findViewById(R.id.rechercher);
        search = findViewById(R.id.search);


        String [] place = { " African " ," American " ," British " ," Cajun " ," Caribbean " ," Chinese " ," Eastern European " ," European " ,
                " French " ," German " ," Greek " ," Indian " ," Irish " ," Italian " ," Japanese " ," Jewish " ," Korean " ,
                " Latin American " ," Mediterranean " ," Mexican " ," Middle Eastern " ," Nordic " ," Southern " ," Spanish " ," Thai " ,
                " Vietnamese " };

        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(place));
        /* afficher éléments de la liste
        int cpt = 1;
        for(String elem : list) {
            System.out.println(elem);
        }*/

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSpinner = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        resultats.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                itemSeekBar = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                keyWord = search.getText().toString();
                //String urlJson = "https://api.spoonacular.com/recipes/search?query="+keyWord+"&cuisine="+itemSpinner+"&number="+itemSeekBar+"&apiKey="+apiKey;
                Intent i = new Intent(ListGenre.this, Resultats.class);
                Ion.with(v.getContext())
                        .load("https://api.spoonacular.com/recipes/search?query="+keyWord+"&cuisine="+itemSpinner+"&number="+itemSeekBar+"&apiKey="+apiKey)
                        .setLogging("ION_LOGS", Log.DEBUG)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                // do stuff with the result of error
                                ArrayList<String> list = new ArrayList<>();
                                JsonArray res = result.get("results").getAsJsonArray();
                                for(int i = 0; i < res.size(); i++){
                                    list.add(res.get(i).getAsJsonObject().get("title").getAsString());
                                }
                                System.out.println(list);

                            }

                            });
                        }
            });





        }






}




