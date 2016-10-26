package com.example.samples;

import java.util.concurrent.Callable;

/**
 * Created by Menaka on 3/24/17.
 */
public class NewThread implements Callable<String> {

    public String call() {
        return Thread.currentThread().getName() + " executing ...";
    }

}