package ru.polovinko.generics.examples.heapPollution;

import java.util.ArrayList;
import java.util.List;

public class HeapPollutionExample {

    public static List<String> heapPollution() {
        List list = new ArrayList<String>();
        list.add("Hello");
        list.add(1);
        return list;
    }

    public static void main(String[] args) {
        List<String> strings = heapPollution();
        for (String str : strings) {
            System.out.println(str.toUpperCase());
        }
    }
}
