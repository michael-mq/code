package Algorithm.HackerRank.HackerRank_Count_Triplets;

import java.util.Collections;
import java.util.List;

public class Solution_Failed {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        int result = 0;
        int len = arr.size();

        if (len < 3) {
            return result;
        }

        Collections.sort(arr);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr.get(j) > arr.get(i) * 3) {
                    break;
                }

                for (int k = j + 1; k < len; k++) {
                    if (arr.get(k) > arr.get(j) * 3) {
                        break;
                    }

                    if (arr.get(k) == arr.get(j) * 3 && arr.get(j) == arr.get(i) * 3) {
                        result++;
                    }
                }
            }
        }

        return result;

    }
}
