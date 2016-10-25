package com.example.java8.pojo;

/**
 * Created by Menaka on 10/24/16.
 */
public class Snippet {

    public static void main(String[] args) {
        stringComparision();
    }

    private static void stringComparision() {
        String s1="12345";

        String s2="1234" + s1.length();

        if(s1==s2)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

        System.out.println(" the value of S1 is : " + s1);
        System.out.println(" the value of S2 is : " + s2);
        System.out.println(" the hashCode of S1 is : " + s1.hashCode());
        System.out.println(" the hashCode of S2 is : " + s2.hashCode());

    }
}
