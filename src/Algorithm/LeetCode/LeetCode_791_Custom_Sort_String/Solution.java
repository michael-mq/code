package Algorithm.LeetCode.LeetCode_791_Custom_Sort_String;

class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                sb.append(c);
            }

            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
