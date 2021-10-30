package Algorithm.HackerRank.HackRank_Counting_Universal_Subarrays_LintCode_264;

import java.util.ArrayList;
import java.util.List;

// https://www.codeleading.com/article/54243958174/
public class Solution1 {
    public int subarrays(int[] array) {
        int len = array.length;
        List<Integer> list = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }

        list.add(count);

        int result = 0;

        for (int j = 0; j < list.size() - 1; j++) {
            result += Math.min(list.get(j), list.get(j + 1));
        }

        return result;
    }
}
