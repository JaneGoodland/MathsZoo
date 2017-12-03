package com.janegoodlandmaths.www.mathszoo;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ZooMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set up global variables
        final TextView text_user = (TextView) findViewById(R.id.include);
        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final String n1 = getResources().getString(R.string.number_animal_1);
        final String n2 = getResources().getString(R.string.number_animal_2);
        final String n3 = getResources().getString(R.string.number_animal_3);
        final String n4 = getResources().getString(R.string.number_animal_4);
        final String a1 = getResources().getString(R.string.algebra_animal_1);
        final String a2 = getResources().getString(R.string.algebra_animal_2);
        final String a3 = getResources().getString(R.string.algebra_animal_3);
        final String a4 = getResources().getString(R.string.algebra_animal_4);
        final String r1 = getResources().getString(R.string.ratio_animal_1);
        final String r2 = getResources().getString(R.string.ratio_animal_2);
        final String r3 = getResources().getString(R.string.ratio_animal_3);
        final String r4 = getResources().getString(R.string.ratio_animal_4);
        final String s1 = getResources().getString(R.string.stats_animal_1);
        final String s2 = getResources().getString(R.string.stats_animal_2);
        final String s3 = getResources().getString(R.string.stats_animal_3);
        final String s4 = getResources().getString(R.string.stats_animal_4);
        final String p1 = getResources().getString(R.string.prob_animal_1);
        final String p2 = getResources().getString(R.string.prob_animal_2);
        final String p3 = getResources().getString(R.string.prob_animal_3);
        final String p4 = getResources().getString(R.string.prob_animal_4);
        final String g1 = getResources().getString(R.string.geometry_animal_1);
        final String g2 = getResources().getString(R.string.geometry_animal_2);
        final String g3 = getResources().getString(R.string.geometry_animal_3);
        final String g4 = getResources().getString(R.string.geometry_animal_4);

        // look at the data that was passed here
        // it's possible that we've only just opened the app
        // in which case there is no data, and no-one is logged in
        Bundle extras = getIntent().getExtras();
        if(extras==null) {
            // no-one is logged in so hunger_levels are all 0
            SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
            SharedPreferences.Editor editor = hunger_levels.edit();
            editor.putInt(n1, 0);
            editor.putInt(n2, 0);
            editor.putInt(n3, 0);
            editor.putInt(n4, 0);
            editor.putInt(a1,0);
            editor.putInt(a2,0);
            editor.putInt(a3,0);
            editor.putInt(a4,0);
            editor.putInt(r1,0);
            editor.putInt(r2,0);
            editor.putInt(r3,0);
            editor.putInt(r4, 0);
            editor.putInt(p1, 0);
            editor.putInt(p2, 0);
            editor.putInt(p3, 0);
            editor.putInt(p4, 0);
            editor.putInt(g1, 0);
            editor.putInt(g2, 0);
            editor.putInt(g3, 0);
            editor.putInt(g4,0);
            editor.putInt(s1,0);
            editor.putInt(s2,0);
            editor.putInt(s3,0);
            editor.putInt(s4,0);
            editor.commit();
        } else {
            // we are returning here from zone view or animal view
            // so there is a user already logged in
            // and shared preferences will already be set for hunger levels
            final String username = extras.getString("username");
            text_user.setText(username);
        }

        // display hunger levels
        putHungerLevelsFromSharedPreferencesIntoProgressBars(n1, n2, n3, n4,
                a1, a2, a3, a4, g1, g2, g3, g4, s1, s2, s3, s4,
                p1, p2, p3, p4, r1, r2, r3, r4);

        // set up buttons for all zones
        Button number = (Button) findViewById(R.id.btn_number);
        number.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name", "number");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
        Button algebra = (Button)findViewById(R.id.btn_algebra);
        algebra.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name","algebra");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
        Button geometry = (Button)findViewById(R.id.btn_geometry);
        geometry.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name","geometry");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
        Button ratio = (Button)findViewById(R.id.btn_ratio);
        ratio.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name","ratio");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
        Button stats = (Button)findViewById(R.id.btn_stats);
        stats.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name","stats");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
        Button prob = (Button)findViewById(R.id.btn_prob);
        prob.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence username = text_user.getText();
                if(username.equals("Please log in")) {
                } else {
                    Intent intent = new Intent(ZooMap.this, zone_view.class);
                    Bundle extras = new Bundle();
                    extras.putString("zone_name","prob");
                    extras.putString("username", username.toString());
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });

        // set up a button for "save to database" for this user
        Button save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                String user_message = text_user.getText().toString();
                int length = user_message.length();
                String username = user_message.substring(0,length-6);
                FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                SharedPreferences h = getSharedPreferences("hungers", 0);

                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_USERNAME+" = ?";
                String[] selectionArgs = {username};
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_USERNAME, username);
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD,"p");
                values.put(FeedReaderContract.FeedEntry.HUNGERS_n1,h.getInt(n1,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_n2,h.getInt(n2,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_n3,h.getInt(n3,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_n4,h.getInt(n4,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_a1,h.getInt(a1,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_a2,h.getInt(a2,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_a3,h.getInt(a3,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_a4,h.getInt(a4,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_r1,h.getInt(r1,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_r2,h.getInt(r2,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_r3,h.getInt(r3,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_r4,h.getInt(r4,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_s1,h.getInt(s1,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_s2,h.getInt(s2,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_s3,h.getInt(s3,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_s4,h.getInt(s4,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_p1,h.getInt(p1,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_p2,h.getInt(p2,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_p3,h.getInt(p3,0));
                values.put(FeedReaderContract.FeedEntry.HUNGERS_p4,h.getInt(p4,0));
                int count = db.update(FeedReaderContract.FeedEntry.TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);
            }
        });

        // if someone clicks in the username box, the text should go blank:
        final EditText new_username = (EditText) findViewById(R.id.et_username);
        new_username.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                new_username.setText("");
            }
        });
        // if someone clicks on the login button, log them in
        Button login = (Button)findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                String username = et_username.getText().toString();
                String user_message = username+"'s Zoo";

                FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());
                // first, check if this username already exists
                SQLiteDatabase db_reader = mDbHelper.getReadableDatabase();
                String[] projection = {FeedReaderContract.FeedEntry._ID,
                        FeedReaderContract.FeedEntry.HUNGERS_a1,
                        FeedReaderContract.FeedEntry.HUNGERS_a2,
                        FeedReaderContract.FeedEntry.HUNGERS_a3,
                        FeedReaderContract.FeedEntry.HUNGERS_a4,
                        FeedReaderContract.FeedEntry.HUNGERS_n1,
                        FeedReaderContract.FeedEntry.HUNGERS_n2,
                        FeedReaderContract.FeedEntry.HUNGERS_n3,
                        FeedReaderContract.FeedEntry.HUNGERS_n4,
                        FeedReaderContract.FeedEntry.HUNGERS_s1,
                        FeedReaderContract.FeedEntry.HUNGERS_s2,
                        FeedReaderContract.FeedEntry.HUNGERS_s3,
                        FeedReaderContract.FeedEntry.HUNGERS_s4,
                        FeedReaderContract.FeedEntry.HUNGERS_p1,
                        FeedReaderContract.FeedEntry.HUNGERS_p2,
                        FeedReaderContract.FeedEntry.HUNGERS_p3,
                        FeedReaderContract.FeedEntry.HUNGERS_p4,
                        FeedReaderContract.FeedEntry.HUNGERS_r1,
                        FeedReaderContract.FeedEntry.HUNGERS_r2,
                        FeedReaderContract.FeedEntry.HUNGERS_r3,
                        FeedReaderContract.FeedEntry.HUNGERS_r4,
                        FeedReaderContract.FeedEntry.HUNGERS_g1,
                        FeedReaderContract.FeedEntry.HUNGERS_g2,
                        FeedReaderContract.FeedEntry.HUNGERS_g3,
                        FeedReaderContract.FeedEntry.HUNGERS_g4};
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_USERNAME+" = ?";
                String[] selectionArgs = {username};
                String sortOrder = FeedReaderContract.FeedEntry._ID+" ASC"; // not important
                Cursor cursor = db_reader.query(
                        FeedReaderContract.FeedEntry.TABLE_NAME, projection,
                        selection, selectionArgs, null, null, sortOrder);
                Long id = 0L;
                if(cursor.moveToNext()) {
                    // upload data from before
                    id = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
                    Long n1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_n1));
                    Long n2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_n2));
                    Long n3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_n3));
                    Long n4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_n4));
                    Long a1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_a1));
                    Long a2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_a2));
                    Long a3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_a3));
                    Long a4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_a4));
                    Long g1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_g1));
                    Long g2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_g2));
                    Long g3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_g3));
                    Long g4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_g4));
                    Long r1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_r1));
                    Long r2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_r2));
                    Long r3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_r3));
                    Long r4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_r4));
                    Long s1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_s1));
                    Long s2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_s2));
                    Long s3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_s3));
                    Long s4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_s4));
                    Long p1_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_p1));
                    Long p2_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_p2));
                    Long p3_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_p3));
                    Long p4_hunger = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.HUNGERS_p4));

                    et_username.setText("");//exists, id = "+id.toString());
                    text_user.setText(user_message);
                    SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
                    SharedPreferences.Editor editor = hunger_levels.edit();
                    editor.putInt(n1, n1_hunger.intValue());
                    editor.putInt(n2, n2_hunger.intValue());
                    editor.putInt(n3, n3_hunger.intValue());
                    editor.putInt(n4, n4_hunger.intValue());
                    editor.putInt(a1, a1_hunger.intValue());
                    editor.putInt(a2, a2_hunger.intValue());
                    editor.putInt(a3, a3_hunger.intValue());
                    editor.putInt(a4, a4_hunger.intValue());
                    editor.putInt(r1, r1_hunger.intValue());
                    editor.putInt(r2, r2_hunger.intValue());
                    editor.putInt(r3, r3_hunger.intValue());
                    editor.putInt(r4, r4_hunger.intValue());
                    editor.putInt(p1, p1_hunger.intValue());
                    editor.putInt(p2, p2_hunger.intValue());
                    editor.putInt(p3, p3_hunger.intValue());
                    editor.putInt(p4, p4_hunger.intValue());
                    editor.putInt(g1, g1_hunger.intValue());
                    editor.putInt(g2, g2_hunger.intValue());
                    editor.putInt(g3, g3_hunger.intValue());
                    editor.putInt(g4, g4_hunger.intValue());
                    editor.putInt(s1, s1_hunger.intValue());
                    editor.putInt(s2, s2_hunger.intValue());
                    editor.putInt(s3, s3_hunger.intValue());
                    editor.putInt(s4, s4_hunger.intValue());
                    editor.commit();
                    putHungerLevelsFromSharedPreferencesIntoProgressBars(n1, n2, n3, n4, a1, a2, a3, a4, g1, g2, g3, g4,
                            s1, s2, s3, s4, p1, p2, p3, p4, r1, r2, r3, r4);
                } else {
                    // create new user
                    et_username.setText("New user created");
                    SQLiteDatabase db_writer = mDbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_USERNAME, username);
                    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PASSWORD,"p");
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_n1,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_n2,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_n3,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_n4,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_a1,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_a2,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_a3,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_a4,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_r1,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_r2,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_r3,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_r4,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_s1,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_s2,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_s3,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_s4,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_p1,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_p2,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_p3,0);
                    values.put(FeedReaderContract.FeedEntry.HUNGERS_p4,0);
                    long newRowId = db_writer.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
                    text_user.setText(user_message);
                    SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
                    SharedPreferences.Editor editor = hunger_levels.edit();
                    editor.putInt(n1, 0);
                    editor.putInt(n2, 0);
                    editor.putInt(n3, 0);
                    editor.putInt(n4, 0);
                    editor.putInt(a1, 0);
                    editor.putInt(a2, 0);
                    editor.putInt(a3, 0);
                    editor.putInt(a4, 0);
                    editor.putInt(r1, 0);
                    editor.putInt(r2, 0);
                    editor.putInt(r3, 0);
                    editor.putInt(r4, 0);
                    editor.putInt(p1, 0);
                    editor.putInt(p2, 0);
                    editor.putInt(p3, 0);
                    editor.putInt(p4, 0);
                    editor.putInt(g1, 0);
                    editor.putInt(g2, 0);
                    editor.putInt(g3, 0);
                    editor.putInt(g4, 0);
                    editor.putInt(s1, 0);
                    editor.putInt(s2, 0);
                    editor.putInt(s3, 0);
                    editor.putInt(s4, 0);
                    editor.commit();
                    putHungerLevelsFromSharedPreferencesIntoProgressBars(
                            n1, n2, n3, n4, a1, a2, a3, a4, g1, g2, g3, g4,
                            s1, s2, s3, s4, p1, p2, p3, p4, r1, r2, r3, r4);
                }
                cursor.close();

            }
        });

        // DOES NOTHING:
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void putHungerLevelsFromSharedPreferencesIntoProgressBars(
            String n1, String n2, String n3, String n4,
        String a1, String a2, String a3, String a4,
        String g1, String g2, String g3, String g4,
        String s1, String s2, String s3, String s4,
        String p1, String p2, String p3, String p4,
        String r1, String r2, String r3, String r4) {
        SharedPreferences h = getSharedPreferences("hungers", 0);
        int n_val = h.getInt(n1,0) + h.getInt(n2,0) + h.getInt(n3,0) + h.getInt(n4,0);
        int a_val = h.getInt(a1,0) + h.getInt(a2,0) + h.getInt(a3,0) + h.getInt(a4,0);
        int p_val = h.getInt(p1,0) + h.getInt(p2,0) + h.getInt(p3,0) + h.getInt(p4,0);
        int g_val = h.getInt(g1,0) + h.getInt(g2,0) + h.getInt(g3,0) + h.getInt(g4,0);
        int r_val = h.getInt(r1,0) + h.getInt(r2,0) + h.getInt(r3,0) + h.getInt(r4,0);
        int s_val = h.getInt(s1,0) + h.getInt(s2,0) + h.getInt(s3,0) + h.getInt(s4,0);
        ProgressBar bar_n = (ProgressBar) findViewById(R.id.bar_number);
        ProgressBar bar_a = (ProgressBar) findViewById(R.id.bar_algebra);
        ProgressBar bar_g = (ProgressBar) findViewById(R.id.bar_geometry);
        ProgressBar bar_p = (ProgressBar) findViewById(R.id.bar_prob);
        ProgressBar bar_r = (ProgressBar) findViewById(R.id.bar_ratio);
        ProgressBar bar_s = (ProgressBar) findViewById(R.id.bar_stats);
        bar_n.setProgress(n_val);
        bar_a.setProgress(a_val);
        bar_p.setProgress(p_val);
        bar_r.setProgress(r_val);
        bar_g.setProgress(g_val);
        bar_s.setProgress(s_val);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_zoo_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
