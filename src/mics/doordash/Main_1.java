package mics.doordash;

import java.util.*;

public class Main_1 {
    //    Asked this: https://leetcode.com/discuss/interview-question/846916/Validate-Orders-Path-(Doordash)
    //
    //    Follow up: Find the longest valid subarray
    //
    //    Ex 1: orders = ['P1', 'P1', 'D1'], return ['P1', 'D1']
    //    Ex 2: orders = ['P1', 'P1', 'D1', 'D1'], return ['P1', 'D1']

    static class Pair {
        boolean picked;
        int index;

        public Pair(boolean picked, int index) {
            this.picked = picked;
            this.index = index;
        }
    }

    public static int pickups(String[] arr) {
        Map<Integer, Pair> pickups = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String t = arr[i];
            int num = Character.getNumericValue(t.charAt(1));

            if (t.charAt(0) == 'P') {
                if (!pickups.containsKey(num)) {
                    pickups.put(num, new Pair(true, i));
                }
            } else {
                if (!pickups.containsKey(num)) {
                    continue;
                }
                if (pickups.get(num).picked) {
                    pickups.get(num).picked = false;
                    arr[pickups.get(num).index] = "p" + t.charAt(1);
                    arr[i] = "d" + t.charAt(1);
                }
            }
        }

        int ans = 0;

        for (String s : arr) {
            if (s.charAt(0) == 'p' || s.charAt(0) == 'd') {
                ans++;
                System.out.print(s);
                System.out.print(" ");
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        printValidPaths(2);
        System.out.println(pickups(new String[] {"P1", "P1", "D1", "D1"}));
    }
}
