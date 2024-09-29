package Algorithm.LeetCode.LeetCode_3_Longest_Substring_WIthout_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_MyOwn {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int max = 1;
        Set<Character> set = new HashSet<>();
        int i = 0;
        char[] arr = s.toCharArray();

        set.add(arr[i]);

        for (int j = 1; j < arr.length; j++) {
            if (set.contains(arr[j])) {
                while (arr[i] != arr[j]) {
                    set.remove(arr[i]);
                    i++;
                }

                max = Math.max(max, j - i);
                i++;
            } else {
                max = Math.max(max, j - i + 1);
            }

            set.add(arr[j]);
        }

        return max;
    }
}
