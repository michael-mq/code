package mics;

import java.util.*;

public class Foo {

    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();

        List<String> temp = map.getOrDefault(1, new ArrayList<>());
        temp.add("ss");

        map.put(1, temp);

        System.out.println(Arrays.toString(map.get(1).toArray()));

        System.out.println(Arrays.toString((new ArrayList<String>(Collections.singleton("foo")).toArray())));
    }
}


