package com.janegoodlandmaths.www.mathszoo;

import android.util.Pair;

import java.util.Random;

/**
 * Created by Jamie on 13/08/2017.
 */

// TODO:
// estimating
// rounding
// standard form
// converting units

public class number3 {

    static int previous_i = 0;

    public static Pair get_question() {
        Random r = new Random();
        int i = r.nextInt(4); // exclusive
        // make sure that i is not the same as previous i
        while(i==previous_i) i = r.nextInt(7);
        previous_i = i;
        // get question and answer pair
        Pair<CharSequence, CharSequence> p;
        switch(i){
            default: p = Rubbish(); break;
        }
        return p;
    }

    public static Pair Rubbish() {
        CharSequence question;
        CharSequence answer;
        question = "Questions not written yet (answer = 0)";
        answer = "0";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }

    public static Pair Estimating() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int i = r.nextInt(2); // exclusive
        double a = r.nextDouble()*100 + 100.0;
        double b = r.nextDouble()*100;
        if(i==0){
            question = String.format("Estimate the value of %f x %f.",a,b);
            answer = "TODO";
        } else if(i==1) {
            question = String.format("Estimate the value of %f + %f.",a,b);
            answer = "TODO";
        } else {
            question = String.format("Estimate the value of %f - %f.",a,b);
            answer = "TODO";
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
}
