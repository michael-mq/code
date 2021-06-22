package Algorithm.LeetCode.LeetCode_567_Permutation_in_String;

class Solution_Two_Pointer {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < len2; right++) {
            int x = s2.charAt(right) - 'a';
            count[x]--;

            while (count[x] < 0) {
                int y = s2.charAt(left) - 'a';
                count[y]++;
                left++;
            }

            if (right - left + 1 == len1) {
                return true;
            }
        }

        return false;
    }
}
