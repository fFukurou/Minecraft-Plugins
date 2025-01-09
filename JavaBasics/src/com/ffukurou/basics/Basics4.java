package com.ffukurou.basics;

import java.util.*;

public class Basics4 {
    public static void main(String[] args) {

        String[] array = new String[]{"Test1", "Test2", "Test3"};
        array[0] = "NEW VALUE!!";
        System.out.println(array[0]);

        List<String> list = new ArrayList<>();

        list.add("Test1");
        list.add("Test2");
        list.add("bruh");
        list.add("kekw");

        for (String item : list) {
            System.out.println(item);
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "Testing 5");
        System.out.println(map.get(5));

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addFirst("Test1");
        linkedList.add("Test2");

        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(5, "Testing 5");
        linkedMap.putLast(12, "ALLAHU");
        System.out.println(map.get(5));
        System.out.println(map.keySet().toArray()[0]);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < linkedMap.size(); i++) {
            System.out.println("Key: " + linkedMap.keySet().toArray()[i]);
            System.out.println("Value: " + linkedMap.values().toArray()[i]);
        }
    }
}
