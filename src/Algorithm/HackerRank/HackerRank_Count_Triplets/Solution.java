package Algorithm.HackerRank.HackerRank_Count_Triplets;

import java.util.*;

// https://www.youtube.com/watch?v=KZ8k9-22JmQ
public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;

        Map<Long, Long> beforeMap = new HashMap<>();
        Map<Long, Long> afterMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            afterMap.put(arr.get(i), afterMap.getOrDefault(arr.get(i), 0L) + 1);
        }

        for (long n : arr) {
            afterMap.put(n, afterMap.get(n) - 1);

            if (n % r == 0 && beforeMap.get(n / r) != null && afterMap.get(n * r) != null && afterMap.get(n * r) > 0) {
                count += beforeMap.get(n / r) * afterMap.get(n * r);
            }

            beforeMap.put(n, beforeMap.getOrDefault(n, 0L) + 1);
        }

        return count;
    }

}
