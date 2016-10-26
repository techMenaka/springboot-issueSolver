package com.example.samples;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FirstNonRepeated {


    public static Character firstNonRepeatedCharacter(String str)
    {
        HashMap<Character,Integer>  characterMap= new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();
        for (i=0;i < length;i++)
        {
            c=str.charAt(i);
            if(characterMap.containsKey(c))
            {
                // increment count corresponding to c
                characterMap.put(  c ,  characterMap.get(c) +1 );
            }
            else
            {
                characterMap.put( c , 1 ) ;
            }
        }
        // Search characterMap in in order of string str

        for (i =0 ; i < length ; i++ )
        {
            c= str.charAt(i);
            if( characterMap.get(c)  == 1 )
                return c;
        }
        return null ;
    }
}

