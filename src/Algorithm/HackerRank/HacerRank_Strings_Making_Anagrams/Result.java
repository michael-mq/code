package Algorithm.HackerRank.HacerRank_Strings_Making_Anagrams;

import java.util.Arrays;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
    // Write your code here
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        int result = 0;

        while (p1 < a.length() && p2 < b.length()) {
             if (arr1[p1] == arr2[p2]) {
                 p1++;
                 p2++;
             } else if (arr1[p1] < arr2[p2]) {
                 result++;
                 p1++;
             } else {
                 result++;
                 p2++;
             }
        }

        if (p1 == a.length()) {
            result += b.length() - p2;
        } else {
            result += a.length() - p1;
        }

        return result;
    }

}
