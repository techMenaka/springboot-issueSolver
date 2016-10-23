package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Menaka on 10/23/16.
 */
public class ForEach {

    public static void main(String[] args) {
        List<Integer> integerArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        //Stream count
        System.err.println(integerArray.stream()
                                        .count());

        // print all the elements
        integerArray.forEach(param -> System.err.println(" integer : " + param));

        //print double the value and the total
        System.err.println( "double sum of the list is: " +
            integerArray.stream()
                .map(param -> param * 2)
                .reduce(0, (c, e) -> c + e));

        //find even numbers
        System.err.println(" sum of the even numbers is :: " + ForEach.totalValues(x -> x%2 ==0, integerArray));

        // Find the double of the first even number greater than 5
        System.err.println(
            "double of the first even number greater than 5 is " +
                integerArray.stream()
                    .filter(x -> x > 5)
                    .filter(x -> x % 2 == 0)
                    .map(x -> x * 2)
                    .findFirst().get()
        );

        System.err.println(
            " elements greater than 5 is : ");
            integerArray.stream()
                        .filter(x -> x>5)
                        .forEach(x -> System.err.println(x));

        System.err.println(
            " elements lesser than 5 is : ");
        integerArray.stream().filter(x -> x<5)
            .forEach(x -> System.err.println(x));

    }

    public static Integer totalValues(Predicate<Integer> selector, List<Integer> numbers) {
      return numbers.stream()
                    .filter(selector)
                    .reduce(0, (c,e) -> c+e);

    }
}
