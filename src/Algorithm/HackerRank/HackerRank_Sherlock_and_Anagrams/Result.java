package Algorithm.HackerRank.HackerRank_Sherlock_and_Anagrams;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                list.add(s.substring(i, j + 1));
            }
        }

        int result = 0;

        for (int k = 0; k < list.size(); k++) {
            for (int l = k + 1; l < list.size(); l++) {
                if (isAnagram(list.get(k), list.get(l))) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}
