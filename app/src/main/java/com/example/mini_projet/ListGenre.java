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


public class ListGenre extends AppCompatActivity {

    private SeekBar resultats;
    private Spinner spinner;
    private Button bouton;
    private EditText search;
    private String itemSpinner;
    private int itemSeekBar;
    private String keyWord;
    private String apiKey = "f4191411045d45d0aed31c69627d5499";
    private TextView nbsearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultats = findViewById(R.id.seekBar);
        nbsearch = findViewById(R.id.NbSearch);
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

        nbsearch.setText("0");

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
                nbsearch.setText(String.valueOf(progress));
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
            }
        });



        String jsonText = "https://api.spoonacular.com/recipes/search?query="+keyWord+"&cuisine="+itemSpinner+"&number="+itemSeekBar+"&apiKey=" + apiKey;
        //https://api.spoonacular.com/recipes/search?query=cheese&cuisine=Nordic&number=10&apiKey=f4191411045d45d0aed31c69627d5499
        //info par id :
        //https://api.spoonacular.com/recipes/{id}/information?apiKey=f4191411045d45d0aed31c69627d5499
        //130953

        //JSONObject json = JSONReader.readJsonFromUrl("https://api.spoonacular.com/recipes/search?query=cheese&cuisine=italian&number=3&apiKey=" + apiKey);

        }


}




