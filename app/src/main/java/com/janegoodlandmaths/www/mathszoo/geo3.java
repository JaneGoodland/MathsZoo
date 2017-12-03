package com.janegoodlandmaths.www.mathszoo;

import android.util.Pair;

import java.util.Random;

/**
 * Created by Jamie on 13/08/2017.
 */

// TODO:
// module still needs writing

public class geo3 {

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
}
