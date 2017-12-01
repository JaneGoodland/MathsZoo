package com.janegoodlandmaths.www.mathszoo;

import android.util.Pair;

import java.util.Random;

/**
 * Created by Jamie on 13/08/2017.
 */

public class number2 {

    // TODO:
    // - add an internal static variable that indicates what question you just
    // had to make sure you don't get the same one twice in a row
    // - make sure that 0 is removed from some of the questions, particularly
    // if it will result in a divide by 0 error (e.g. %)

    public static Pair get_question() {
        Random r = new Random();
        int i = r.nextInt(7); // exclusive
        Pair<CharSequence, CharSequence> p;
        switch(i){
            case 0: p = Primes(); break;
            case 1: p = Factors(); break;
            case 2: p = Multiples(); break;
            case 3: p = Powers(); break;
            case 4: p = Squares(); break;
            case 5: p = Cubes(); break;
            case 6: p = SquareRoots(); break;
            default: p = CubeRoots(); break;
        }
        return p;
    }
    public static Pair Primes() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(20); // exclusive
        question = String.format("True or False: %d is a prime number.",a);
        answer = "True";
        if(a%2==0) answer = "False";
        if(a==2) answer = "True";
        if(a==1) answer = "False";
        if(a%3==0) answer = "False";
        if(a==3) answer = "True";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Factors() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(11);
        int b = r.nextInt(31);
        question = String.format("True or False: %d is a factor of %d.",a,b);
        answer = (b%a==0) ? "True" : "False";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        // TODO HCF
        return p;
    }
    public static Pair Multiples() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(11);
        int b = r.nextInt(31);
        question = String.format("True or False: %d is a multiple of %d.",b,a);
        answer = (b%a==0) ? "True" : "False";
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        // TODO LCM
        return p;
    }
    public static Pair Powers() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(6);
        int b = r.nextInt(6);
        question = String.format("Calc allowed: What is %d to the power %d?",a,b);
        double double_result = java.lang.Math.pow(a,b);
        int result = (int) double_result;
        answer = String.format("%d",result);
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Squares() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(11);
        question = String.format("What is %d squared?",a);
        double double_result =java.lang.Math.pow(a,2);
        int result = (int) double_result;
        answer = String.format("%d",result);
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair Cubes() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(6);
        question = String.format("What is %d cubed?", a);
        double double_result = java.lang.Math.pow(a,3);
        int result = (int) double_result;
        answer = String.format("%d",result);
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
    public static Pair SquareRoots() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(11);
        double double_b = java.lang.Math.pow(a, 2);
        int b = (int) double_b;
        question = String.format("What is the square root of %d?", b);
        answer = Integer.toString(a);
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }

    public static Pair CubeRoots() {
        CharSequence question;
        CharSequence answer;
        Random r = new Random();
        int a = r.nextInt(6);
        double double_b = java.lang.Math.pow(a, 3);
        int b = (int) double_b;
        question = String.format("What is the cube root of %d?", b);
        answer = Integer.toString(a);
        Pair<CharSequence, CharSequence> p = new Pair(question, answer);
        return p;
    }
}
