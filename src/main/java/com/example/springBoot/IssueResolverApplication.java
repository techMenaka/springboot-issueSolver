package com.example.springBoot;

import com.example.cassandra.LoginEvent;
import com.example.cassandra.LoginEventKey;
import com.example.cassandra.repository.LogEventRepository;
import com.example.cassandra.repository.LoginEventQueryBuilder;
import com.example.rxJava.SimpleObservable;
import com.example.samples.NewThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.core.CassandraOperations;
import rx.Observable;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.example.samples.FirstNonRepeated.firstNonRepeatedCharacter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example" })
public class IssueResolverApplication {
    private static final char SEPARATOR = 0x20;
    private static final int MESSAGE_TYPE = 1;
    private static final int THREAD_POOL_SIZE = 2;

    private final Character m_value = 'a';

    @Autowired
    private LoginEventQueryBuilder loginEventQueryBuilder;

    @Autowired
    CassandraOperations cassandraOperations;
    /*Static variables cant be autowired*/

    @Autowired
    LogEventRepository logEventRepository;

    public String toString() { return "" + m_value; }

    public static void main(String[] args) throws IOException {

      ConfigurableApplicationContext context = SpringApplication.run(IssueResolverApplication.class, args);
        rxJavaExamples();

        /* Undo the comment to run the MVC example and comment the run on IssueResolverApplication*/
       //SpringApplication.run(CustomerRestController.class, args);

        findNonRepeatedCharacter();
        try {
            newThread();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void rxJavaExamples() {
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

    public static void findNonRepeatedCharacter() {
        System.out.println(" Please enter the input string :" );
         Scanner in = new Scanner (System.in);
         String s=in.nextLine();
        char c=firstNonRepeatedCharacter(s);
        System.out.println("The first non repeated character is :  " + c);
    }

    public static void newThread() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors
                .newFixedThreadPool(THREAD_POOL_SIZE);

        Future<String> future1 = executor.submit(new NewThread());
        Future<String> future2 = executor.submit(new NewThread());

        System.out.println(Thread.currentThread().getName() + " executing ...");

        //asynchronously get from the worker threads
        System.out.println(future1.get());
        System.out.println(future2.get());
    }

}
