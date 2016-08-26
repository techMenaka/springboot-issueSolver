package com.example.rxJava;


import rx.Observer;

/**
 * Created by Menaka on 8/26/16.
 */
public class SimpleObservable implements Observer<String> {


    @Override
    public void onCompleted() {
        System.out.println("Observable has completed emission");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Error");

    }

    @Override
    public void onNext(String s) {
        System.out.println("String is : " + s);
    }
}
