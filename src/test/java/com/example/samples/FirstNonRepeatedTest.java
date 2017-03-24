package com.example.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.samples.FirstNonRepeated.firstNonRepeatedCharacter;

/**
 * Created by Menaka on 3/24/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class FirstNonRepeatedTest {

    @Test
    public void findNonRepeatedCharacter() {
        System.out.println(" Please enter the input string :" );
        //Scanner in = new Scanner (System.in);
        //String s=in.nextLine();
        char c=firstNonRepeatedCharacter("teeser");
        System.out.println("The first non repeated character is :  " + c);
    }

}