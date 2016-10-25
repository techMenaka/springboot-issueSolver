package com.example.java8.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.accessibility.AccessibleRelationSet;

/**
 * Created by Menaka on 10/24/16.
 */

@Setter
@Getter
@AllArgsConstructor
public class Invoice {

    private String title;
    private int amount;
    private int id;

}
