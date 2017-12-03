package com.janegoodlandmaths.www.mathszoo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class animal_view extends AppCompatActivity {

    Pair <CharSequence,CharSequence> p;
    CharSequence curr_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // obtain data passed through from previous activity
        // username, zone_name and animal_name for this zone/animal
        Bundle extras = getIntent().getExtras();
        final String animal_name = extras.getString("key1");
        final String zone_name = extras.getString("zone_name");
        final String username = extras.getString("username");
        // set username
        final TextView text_user = (TextView) findViewById(R.id.text_user_animal);
        text_user.setText(username);
        // declare text boxes, buttons and global variables
        TextView tv = (TextView) findViewById(R.id.text_animal_name);
        TextView t_name = (TextView) findViewById(R.id.text_parent_zone);
        Button back_to_zoo_map = (Button) findViewById(R.id.btn_back_to_map);
        Button back_to_zone = (Button) findViewById(R.id.btn_back_to_zone);
        final Button submit = (Button) findViewById(R.id.btn_submit);
        final TextView correct_message = (TextView) findViewById(R.id.label_correct);
        final EditText answer = (EditText) findViewById(R.id.txt_answer);
        answer.setEnabled(false); // can only edit the answer using the buttons
        // set animal and zone names
        tv.setText(animal_name);
        t_name.setText(zone_name+" zone");
        back_to_zone.setText("Back to "+zone_name+" zone");
        // obtain question and answer (depending on zone/animal)
        final TextView text_question = (TextView) findViewById(R.id.label_question);
        p = get_question_and_answer_pair(animal_name);
        text_question.setText(p.first);
        curr_answer = p.second;
        // set hunger levels (based on which animal it is)
        SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
        int hunger_val = hunger_levels.getInt(animal_name,0);
        final ProgressBar hunger = (ProgressBar) findViewById(R.id.bar_hunger);
        hunger.setProgress(hunger_val);

        // set up back buttons:
        back_to_zoo_map.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(animal_view.this, ZooMap.class);
                Bundle extras = new Bundle();
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        back_to_zone.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                Intent intent = new Intent(animal_view.this, zone_view.class);
                Bundle extras = new Bundle();
                extras.putString("zone_name", zone_name);
                extras.putString("username", username);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // set up a submit button
        submit.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_text = answer.getText();
                String answer_string = answer_text.toString();
                int len = answer_string.length();
                if(len>0) {
                    int hunger_val = hunger.getProgress();
                    if (answer_string.equals(curr_answer)) {
                        hunger.incrementProgressBy(1);
                        answer.setText("");
                        SharedPreferences hunger_levels = getSharedPreferences("hungers", 0);
                        SharedPreferences.Editor editor = hunger_levels.edit();
                        editor.putInt(animal_name, hunger_val+1);
                        editor.commit();
                        if (hunger_val < 10) {
                            correct_message.setText("Correct! Your " + animal_name + " has been fed.");
                        } else {
                            correct_message.setText("Correct! But your " + animal_name + " was already full!");
                        }
                        p = get_question_and_answer_pair(animal_name);
                        text_question.setText(p.first);
                        curr_answer = p.second;
                    } else {
                        //submit.setText("Try again");
                        answer.setText("");
                        if (hunger_val < 10) {
                            correct_message.setText("Please try again - your " + animal_name + " is hungry.");
                        } else {
                            correct_message.setText("Incorrect, but your " + animal_name + " is not hungry");
                        }
                    }
                }
            }
        });

        Button add_0 = (Button) findViewById(R.id.ans_0);
        Button add_1 = (Button) findViewById(R.id.ans_1);
        Button add_2 = (Button) findViewById(R.id.ans_2);
        Button add_3 = (Button) findViewById(R.id.ans_3);
        Button add_4 = (Button) findViewById(R.id.ans_4);
        Button add_5 = (Button) findViewById(R.id.ans_5);
        Button add_6 = (Button) findViewById(R.id.ans_6);
        Button add_7 = (Button) findViewById(R.id.ans_7);
        Button add_8 = (Button) findViewById(R.id.ans_8);
        Button add_9 = (Button) findViewById(R.id.ans_9);
        Button add_x = (Button) findViewById(R.id.ans_x);
        Button add_y = (Button) findViewById(R.id.ans_y);
        Button add_x2 = (Button) findViewById(R.id.ans_x2);
        Button add_bl = (Button) findViewById(R.id.ans_bl);
        Button add_br = (Button) findViewById(R.id.ans_br);
        Button add_dp = (Button) findViewById(R.id.ans_dp);
        Button add_t = (Button) findViewById(R.id.ans_t);
        Button add_f = (Button) findViewById(R.id.ans_f);
        Button add_bksp = (Button) findViewById(R.id.ans_bksp);
        add_0.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"0");
                correct_message.setText("");
            };
        });
        add_1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"1");
                correct_message.setText("");
            };
        });
        add_2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"2");
                correct_message.setText("");
            };
        });
        add_3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"3");
                correct_message.setText("");
            };
        });
        add_4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"4");
                correct_message.setText("");
            };
        });
        add_5.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"5");
                correct_message.setText("");
            };
        });
        add_6.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"6");
                correct_message.setText("");
            };
        });
        add_7.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"7");
                correct_message.setText("");
            };
        });
        add_8.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"8");
                correct_message.setText("");
            };
        });
        add_9.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"9");
                correct_message.setText("");
            };
        });
        add_x.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"x");
                correct_message.setText("");
            };
        });
        add_y.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"y");
                correct_message.setText("");
            };
        });
        add_x2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"x^2");
                correct_message.setText("");
            };
        });
        add_bl.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"(");
                correct_message.setText("");
            };
        });
        add_br.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+")");
                correct_message.setText("");
            };
        });
        add_dp.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+".");
                correct_message.setText("");
            };
        });
        add_t.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"True");
                correct_message.setText("");
            };
        });
        add_f.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                answer.setText(answer_so_far+"False");
                correct_message.setText("");
            };
        });
        add_bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence answer_so_far = answer.getText();
                int len = answer_so_far.length();
                if(len>0) {
                    answer_so_far = answer_so_far.subSequence(0, len - 1);
                }
                answer.setText(answer_so_far);
                correct_message.setText("");
            };
        });

        // this does nothing
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Pair get_question_and_answer_pair(String animal_name){
        Pair<CharSequence, CharSequence> p;
        switch (animal_name) {
            case "Owl": p = number1.get_question(); break;
            case "Bat": p = number2.get_question(); break;
            case "Hedgehog": p = number3.get_question(); break;
            case "Sloth": p = number4.get_question(); break;

            case "Tiger": p = geo1.get_question(); break;
            case "Parrot": p = geo2.get_question(); break;
            case "Monkey": p = geo3.get_question(); break;
            case "Orangutan": p = geo4.get_question(); break;

            case "Elephant": p = stats1.get_question(); break;
            case "Lion": p = stats2.get_question(); break;
            case "Giraffe": p = stats3.get_question(); break;
            case "Zebra": p = stats4.get_question(); break;

            case "Rabbit": p = prob1.get_question(); break;
            case "Lamb": p = prob2.get_question(); break;
            case "Mouse": p = prob3.get_question(); break;
            case "Chick": p = prob4.get_question(); break;

            case "Penguin": p = algebra1.get_question(); break;
            case "Polar Bear": p = algebra2.get_question(); break;
            case "Fish": p = algebra3.get_question(); break;
            case "Whale": p = algebra4.get_question(); break;

            case "Snake": p = ratio1.get_question(); break;
            case "Crocodile": p = ratio2.get_question(); break;
            case "Dinosaur": p = ratio3.get_question(); break;
            default: p = ratio4.get_question(); break; // Turtle
        }
        return p;
    }
}
