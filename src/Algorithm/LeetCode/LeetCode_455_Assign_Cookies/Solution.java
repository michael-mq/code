package Algorithm.LeetCode.LeetCode_455_Assign_Cookies;

import java.util.Arrays;

//https://www.programmercarl.com/0455.分发饼干.html
class Solution {
    // 思路2：优先考虑胃口，先喂饱大胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if (start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}