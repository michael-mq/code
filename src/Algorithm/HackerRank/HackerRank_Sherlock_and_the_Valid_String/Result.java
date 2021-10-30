package Algorithm.HackerRank.HackerRank_Sherlock_and_the_Valid_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (map.size() == 1) {
            return "YES";
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        int[] arr = new int[map.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = iterator.next().getValue();
        }

        Arrays.sort(arr);

        int first = arr[0];
        int second = arr[1];
        int secondLast = arr[arr.length - 2];
        int last = arr[arr.length - 1];

        // If first and last are same, then all frequencies are same
        if (first == last) {
            return "YES";
        }

        // If first is 1, and all other characters have 1 frequency
        if (first == 1 && second == last) {
            return "YES";
        }

        // If all are same and last character has just 1 extra count
        if (first == second && second == secondLast && secondLast == last - 1) {
            return "YES";
        }

        return "NO";
    }
}
