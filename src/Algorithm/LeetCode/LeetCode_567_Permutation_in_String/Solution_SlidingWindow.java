package Algorithm.LeetCode.LeetCode_567_Permutation_in_String;

import java.util.Arrays;

class Solution_SlidingWindow {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 == 0 || len2 == 0 || len1 > len2) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < len1; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = 0, j = len1; j < len2; i++, j++) {
            cnt2[s2.charAt(i) - 'a']--;
            cnt2[s2.charAt(j) - 'a']++;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow foo = new Solution_SlidingWindow();
        System.out.println(foo.checkInclusion("ab", "eidbaooo"));
    }
}
