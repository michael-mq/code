package Algorithm.LeetCode.LeetCode_833_Find_And_Replace_in_String;

import java.util.Arrays;

// https://www.youtube.com/watch?v=ThbmDoZ7thk
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[] matches = new int[s.length()];
        Arrays.fill(matches, -1);

        for (int i = 0; i < n; i++) {
            int len = sources[i].length();

            if (indices[i] + len <= s.length() && s.substring(indices[i], indices[i] + len).equals(sources[i])) {
                matches[indices[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (matches[i] != -1) {
                sb.append(targets[matches[i]]);
                i += sources[matches[i]].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        int[] indices = new int[]{0, 2};
        String[] sources = new String[]{"a", "cd"};
        String[] targets = new String[]{"eee", "ffff"};

        System.out.println(solution.findReplaceString(s, indices, sources, targets));
    }
}