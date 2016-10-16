package com.example.springBoot;

import com.example.cassandra.LoginEvent;
import com.example.cassandra.LoginEventKey;
import com.example.cassandra.repository.LogEventRepository;
import com.example.cassandra.repository.LoginEventQueryBuilder;
import com.example.rxJava.SimpleObservable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.core.CassandraOperations;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import rx.Observable;
import sun.net.www.protocol.http.HttpURLConnection;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example" })
public class IssueResolverApplication {
    private static final char SEPARATOR = 0x20;
    private static final int MESSAGE_TYPE = 1;

    private final Character m_value = 'a';

    @Autowired
    private LoginEventQueryBuilder loginEventQueryBuilder;

    @Autowired
    CassandraOperations cassandraOperations;

    @Autowired
    LogEventRepository logEventRepository;

    public String toString() { return "" + m_value; }

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext context = SpringApplication.run(IssueResolverApplication.class, args);
        rxJavaExample();
        rxJavaExample2();
        rxJavaExample3();
        rxJavaExample4();


    }

    public void cassandraInsert(ConfigurableApplicationContext context) {
        LoginEvent loginEvent = new LoginEvent();
        LoginEventKey loginEventKey = new LoginEventKey();
        loginEventKey.setPersonId("1");
        loginEventKey.setEventTime(new Date());
        loginEvent.setPk(loginEventKey);
        loginEvent.setEventCode(01);
        loginEvent.setIpAddress("20.0.0.0");
        logEventRepository.executeLogEventQuery(loginEvent);
    }

    public static String concatStrings(List<String> strings) {

        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();

    }
    private static void rxJavaExample() {
        List<String> colorsList = Arrays.asList("red", "blue", "green", "yellow", "pink");
        Observable<String> observable = Observable.from(colorsList);
        observable.subscribe(new SimpleObservable());
    }

    private static void rxJavaExample2() {
        List<String> shapeList = Arrays.asList("circle", "square", "rectangle", "hexagon", "diamond");
        Observable.from(shapeList).subscribe(x -> System.out.println(x),
            x -> System.out.println("error"),() -> System.out.println("completed list using from"));
    }

    private static void rxJavaExample3() {
        List<String> shapeList = Arrays.asList("circle", "square", "rectangle", "hexagon", "diamond");
        Observable.just(shapeList).subscribe(
            x -> System.out.println(x),
            x -> System.out.println("error"), () -> System.out.println("completed list using just"));
    }

    private static void rxJavaExample4() {
        List<String> shapeList = Arrays.asList("circle", "square", "rectangle", "hexagon", "diamond");
        Observable.create(subscriber -> {
                try{
                    Iterator iterator = shapeList.iterator();
                    while ( iterator.hasNext()) {
                        if (subscriber.isUnsubscribed()) return;
                        subscriber.onNext(iterator.next());
                    }
                    if (!subscriber.isUnsubscribed()) subscriber.onCompleted();
                } catch (Exception e) {
                    if (!subscriber.isUnsubscribed()) subscriber.onError(e);
                }
            }).subscribe( x -> System.out.println(x),
            x -> System.out.println("error"), () -> System.out.println("completed list using complete"));
    }
}
