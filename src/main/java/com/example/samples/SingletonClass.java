package com.example.samples;

/**
 * Created by Menaka on 3/24/17.
 */

public class SingletonClass
{

    private static  volatile  SingletonClass uniqueInstance;

    private SingletonClass(){}

    public static   SingletonClass  getInstance()
    {
        if (uniqueInstance == null )
        {
            synchronized(SingletonClass.class)
            {
                if (uniqueInstance == null )
                {
                    uniqueInstance=new SingletonClass();
                }
            }
        }
        return uniqueInstance ;
    }

    // this is created with double locking approach
}