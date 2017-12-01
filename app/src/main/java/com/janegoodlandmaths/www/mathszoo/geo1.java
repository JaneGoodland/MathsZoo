package com.janegoodlandmaths.www.mathszoo;

import android.util.Pair;

import java.util.Random;

/**
 * Created by Jamie on 13/08/2017.
 */

public class geo1 {

    public static Pair get_question() {
        Random r = new Random();
        int i = r.nextInt(4); // exclusive
        CharSequence question;
        CharSequence answer;
        if (i == 0) {
            question = "What is 2+2?";
            answer = "4";
        } else if (i == 1) {
            question = "What is 3+3?";
            answer = "6";
        } else if (i == 2) {
            question = "What is 5 cubed?";
            answer = "125";
        } else {
            question = "Simplify x+x+x.";
            answer = "3x";
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair PlaceValue() {
        CharSequence question;
        CharSequence answer;
        question = "What is?";
        answer = "2";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Bidmas() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int i = r.nextInt(3); // exclusive
        int a = r.nextInt(12);
        int b = r.nextInt(12);
        int c = r.nextInt(12);
        int d = r.nextInt(12);
        if(i==0) {
            question = String.format("%d + %d x %d" ,a,b,c);
            answer = Integer.toString(a + (b*c));
        } else if(i==1) {
            question = String.format("%d - %d x %d",a,b,c);
            answer = Integer.toString(a - (b*c));
        } else {
            question = String.format("%d x %d + %d x %d",a,b,c,d);
            answer = Integer.toString((a*b) + (c*d));
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair FractionOfAmount() {
        CharSequence question;
        CharSequence answer;
        question = "What is?";
        answer = "2";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair PercentageOfAmount() {
        CharSequence question;
        CharSequence answer;
        question = "What is?";
        answer = "2";
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
    public static Pair Rounding() {
        CharSequence question;
        CharSequence answer;
        question = "Q - TODO?";
        answer = "A - TODO";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }

    /*
    ordering numbers including use of signs
    the four operations
    primes, factors, multiples
    combinatorics
    powers and roots
    fractions
    standard form
    fdp
     */
}
