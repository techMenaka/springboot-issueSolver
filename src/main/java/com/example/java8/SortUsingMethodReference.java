package com.example.java8;

import com.example.java8.pojo.Invoice;

import java.util.*;

/**
 * Created by Menaka on 10/24/16.
 */
public class SortUsingMethodReference {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("C", "a", "A", "b");

        System.out.println("Unsorted list >> " + strs);
        Collections.sort(strs, String::compareToIgnoreCase);
        System.out.println("Sorted list >> " + strs);

        java7SortedList();

        /* Thread creation in JAVA 8*/
        new Thread(() -> System.out.println("Hi")).start();

       // java7InvocieSort();

    }

   /* private static void java7InvocieSort() {

        List<Invoice> trainingInvoices = new ArrayList<>();
        Invoice invoice = new Invoice("Training", 10, 1);
        Invoice[] invoices = invoice;
        for (Invoice inv : invoices) {
            if (inv.getTitle().contains("Training")) {
                trainingInvoices.add(inv);
            }
        }
        Collections.sort(trainingInvoices, new Comparator() {
                public int compare(Invoice inv1, Invoice inv2) {
                    return inv2.getAmount().compareTo(inv1.getAmount());
                }
            });
        List<Integer> invoiceIds = new ArrayList<>();
        for (Invoice inv : trainingInvoices) {
            invoiceIds.add(inv.getId());
        }
    }*/

    private static void java7SortedList() {

        List<String> strs = Arrays.asList("C", "a", "A", "b");
        System.out.println("Unsorted list for java 7 >> " + strs);
        Collections.sort(
            strs, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            }
        );

        System.out.println("Sorted list for java 7 >> " + strs);
    }
}
