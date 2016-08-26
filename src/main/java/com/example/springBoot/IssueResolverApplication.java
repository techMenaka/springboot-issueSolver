package com.example.springBoot;

import com.example.rxJava.SimpleObservable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

@SpringBootApplication
public class IssueResolverApplication {

	public static void main(String[] args) {

        SpringApplication.run(IssueResolverApplication.class, args);
        rxJavaExample();

	}

    private static void rxJavaExample() {

       List<String> colorsList = Arrays.asList("red", "blue", "green", "yellow", "pink");
        Observable<String> observable = Observable.from(colorsList);
        observable.subscribe(new SimpleObservable());
    }


}
