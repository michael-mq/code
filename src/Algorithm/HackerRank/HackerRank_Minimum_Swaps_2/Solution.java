package Algorithm.HackerRank.HackerRank_Minimum_Swaps_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        int result = 0;

        int[] sortedArr = Arrays.copyOfRange(arr, 0, len);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < len; i++) {
            int rightNumber = sortedArr[i];

            if (arr[i] != rightNumber) {
                int temp = arr[i];
                int indexOfOriginalNumber = map.get(rightNumber);

                swap(arr, i, indexOfOriginalNumber);

                map.put(temp, indexOfOriginalNumber);
                map.put(rightNumber, i);

                result++;
            }
        }

        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));

    }
}
