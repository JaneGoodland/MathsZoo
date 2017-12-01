package com.janegoodlandmaths.www.mathszoo;

import android.util.Pair;

import java.util.Random;

/**
 * Created by Jamie on 13/08/2017.
 */

public class number1 {

    public static Pair get_question() {
        Random r = new Random();
        int i = r.nextInt(4); // exclusive
        Pair<CharSequence, CharSequence> p;
        switch(i){
            case 0: p = Arithmetic(); break;
            case 1: p = Combinatorics(); break;
            case 2: p = Ordering(); break;
            default: p = Bidmas(); break;
        }
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
        switch(i) {
            case 0: {
                question = String.format("%d + %d x %d", a, b, c);
                answer = Integer.toString(a + (b * c));
                break;
            }
            case 1: {
                question = String.format("%d - %d x %d", a, b, c);
                answer = Integer.toString(a - (b * c));
                break;
            }
            default: {
                question = String.format("%d x %d + %d x %d", a, b, c, d);
                answer = Integer.toString((a * b) + (c * d));
                break;
            }
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Arithmetic() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int i = r.nextInt(4); // exclusive
        int a = r.nextInt(60);
        int b = r.nextInt(60);
        switch(i) {
            case 0: {
                question = String.format("Non-calc: %d + %d", a, b);
                answer = Integer.toString(a + b);
                break;
            }
            case 1: {
                question = String.format("Non-calc: %d x %d", a, b);
                answer = Integer.toString(a * b);
                break;
            }
            case 2: {
                question = String.format("Non-calc: %d divided by %d", a * b, b);
                answer = Integer.toString(a);
                break;
            }
            default: {
                question = String.format("Non-calc: %d - %d", a+b, b);
                answer = Integer.toString(a);
                break;
            }
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Combinatorics() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int i = r.nextInt(3); // exclusive
        int a = r.nextInt(12);
        int b = r.nextInt(12);
        int c = r.nextInt(12);
        int d = r.nextInt(12);
        switch(i) {
            case 0: {
                question = "How many ways are there to choose two different " +
                        "flavours of ice-cream if there are 4 to choose from?";
                answer = "12";
                break;
            }
            case 1: {
                question = "How many ways are there to make 5p from coins?";
                answer = "4";
                break;
            }
            default: {
                question = "How many different two-digit numbers can you " +
                        "make from the digits 4, 6, 6, 7?";
                answer = "7";
                break;
            }
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Ordering() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int i = r.nextInt(2); // exclusive
        double a = r.nextDouble()*10-5;
        double b = r.nextDouble()*10-5;
        switch(i) {
            case 0: {
                question = String.format("True or false: %f > %f", a, b);
                answer = (a>b) ? "True" : "False";
                break;
            }
            default: {
                question = String.format("True or false: %f < %f", a, b);
                answer = (a<b) ? "True" : "False";
            }
        }
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
}
