package com.janegoodlandmaths.www.mathszoo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class zone_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // get the data that was passed here from the previous screen
        // username and zone name
        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("username");
        final String zone_name = extras.getString("zone_name");
        // set up global variables
        TextView text_user = (TextView) findViewById(R.id.text_user_zone);
        TextView tv1 = (TextView) findViewById(R.id.btn_animal1);
        TextView tv2 = (TextView) findViewById(R.id.btn_animal2);
        TextView tv3 = (TextView) findViewById(R.id.btn_animal3);
        TextView tv4 = (TextView) findViewById(R.id.btn_animal4);
        TextView t_name = (TextView) findViewById(R.id.text_zone_name);
        final String animal_1_name;
        final String animal_2_name;
        final String animal_3_name;
        final String animal_4_name;
        // fill in text boxes with relevant username, zone name and animal name
        text_user.setText(username);
        t_name.setText(zone_name+ " zone");
        if(zone_name.equals("number")){
            animal_1_name = getResources().getString(R.string.number_animal_1);
            animal_2_name = getResources().getString(R.string.number_animal_2);
            animal_3_name = getResources().getString(R.string.number_animal_3);
            animal_4_name = getResources().getString(R.string.number_animal_4);
        } else if(zone_name.equals("algebra")){
            animal_1_name = getResources().getString(R.string.algebra_animal_1);
            animal_2_name = getResources().getString(R.string.algebra_animal_2);
            animal_3_name = getResources().getString(R.string.algebra_animal_3);
            animal_4_name = getResources().getString(R.string.algebra_animal_4);
        } else if(zone_name.equals("ratio")){
            animal_1_name = getResources().getString(R.string.ratio_animal_1);
            animal_2_name = getResources().getString(R.string.ratio_animal_2);
            animal_3_name = getResources().getString(R.string.ratio_animal_3);
            animal_4_name = getResources().getString(R.string.ratio_animal_4);
        } else if(zone_name.equals("stats")){
            animal_1_name = getResources().getString(R.string.stats_animal_1);
            animal_2_name = getResources().getString(R.string.stats_animal_2);
            animal_3_name = getResources().getString(R.string.stats_animal_3);
            animal_4_name = getResources().getString(R.string.stats_animal_4);
        } else if(zone_name.equals("prob")){
            animal_1_name = getResources().getString(R.string.prob_animal_1);
            animal_2_name = getResources().getString(R.string.prob_animal_2);
            animal_3_name = getResources().getString(R.string.prob_animal_3);
            animal_4_name = getResources().getString(R.string.prob_animal_4);
        } else if(zone_name.equals("geometry")){
            animal_1_name = getResources().getString(R.string.geometry_animal_1);
            animal_2_name = getResources().getString(R.string.geometry_animal_2);
            animal_3_name = getResources().getString(R.string.geometry_animal_3);
            animal_4_name = getResources().getString(R.string.geometry_animal_4);
        } else {
            animal_1_name = "NO ZONE SELECTED";
            animal_2_name = "NO ZONE SELECTED";
            animal_3_name = "NO ZONE SELECTED";
            animal_4_name = "NO ZONE SELECTED";
        }
        tv1.setText(animal_1_name);
        tv2.setText(animal_2_name);
        tv3.setText(animal_3_name);
        tv4.setText(animal_4_name);

        // get the hunger levels and update them:
        SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
        int hunger_val_1 = hunger_levels.getInt(animal_1_name,0);
        int hunger_val_2 = hunger_levels.getInt(animal_2_name,0);
        int hunger_val_3 = hunger_levels.getInt(animal_3_name,0);
        int hunger_val_4 = hunger_levels.getInt(animal_4_name,0);
        final ProgressBar hunger1 = (ProgressBar) findViewById(R.id.bar_hunger1);
        final ProgressBar hunger2 = (ProgressBar) findViewById(R.id.bar_hunger2);
        final ProgressBar hunger3 = (ProgressBar) findViewById(R.id.bar_hunger3);
        final ProgressBar hunger4 = (ProgressBar) findViewById(R.id.bar_hunger4);
        hunger1.setProgress(hunger_val_1);
        hunger2.setProgress(hunger_val_2);
        hunger3.setProgress(hunger_val_3);
        hunger4.setProgress(hunger_val_4);

        // set up buttons for each animal, and a back button
        Button animal1 = (Button) findViewById(R.id.btn_animal1);
        animal1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(zone_view.this, animal_view.class);
                Bundle extras = new Bundle();
                extras.putString("key1", animal_1_name);
                extras.putString("zone_name", zone_name);
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button animal2 = (Button) findViewById(R.id.btn_animal2);
        animal2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(zone_view.this, animal_view.class);
                Bundle extras = new Bundle();
                extras.putString("key1", animal_2_name);
                extras.putString("zone_name", zone_name);
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button animal3 = (Button) findViewById(R.id.btn_animal3);
        animal3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(zone_view.this, animal_view.class);
                Bundle extras = new Bundle();
                extras.putString("key1", animal_3_name);
                extras.putString("zone_name", zone_name);
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button animal4 = (Button) findViewById(R.id.btn_animal4);
        animal4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(zone_view.this, animal_view.class);
                Bundle extras = new Bundle();
                extras.putString("key1", animal_4_name);
                extras.putString("zone_name", zone_name);
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        Button back = (Button) findViewById(R.id.btn_back_to_map);
        back.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(zone_view.this, ZooMap.class);
                Bundle extras = new Bundle();
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // does nothing
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
