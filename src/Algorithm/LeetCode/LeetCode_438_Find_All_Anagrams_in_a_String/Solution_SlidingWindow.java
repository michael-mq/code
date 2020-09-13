package Algorithm.LeetCode.LeetCode_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_SlidingWindow {
    public List<Integer> findAnagrams(String s, String p) {

        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int[] pArr = new int[26];
        int[] sArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = p.length();

        // 窗口大小固定为p的长度
        while (j < s.length()) {
            if (isSame(pArr, sArr))
                list.add(i);
            //sArr[s.charAt(i) - 'a']-- 左指针位置处字母减1
            sArr[s.charAt(i) - 'a']--;
            i++;
            //sArr[s.charAt(j) - 'a']++ 右指针位置处字母加1
            sArr[s.charAt(j) - 'a']++;
            j++;
        }

        if (isSame(pArr, sArr))
            list.add(i);

        return list;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow foo = new Solution_SlidingWindow();
        System.out.println(Arrays.toString(foo.findAnagrams("abab", "ab").toArray()));
    }
}
