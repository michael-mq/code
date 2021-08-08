package Algorithm.LeetCode.LeetCode_1229_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_Two_Pointers {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int len1 = slots1.length;
        int len2 = slots2.length;
        List<Integer> res = new ArrayList<>();

        if (len1 == 0 || len2 == 0)
            return res;

        Comparator<int[]> comparator = (a, b) -> a[0] - b[0];

        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < len1 && pointer2 < len2) {
            int start = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int end = Math.min(slots1[pointer1][1], slots2[pointer2][1]);

            if (end - start >= duration) {
                res.add(start);
                res.add(start + duration);
                return res;
            }

            if (slots1[pointer1][1] < slots2[pointer2][1])
                pointer1++;
            else if (slots1[pointer1][1] > slots2[pointer2][1])
                pointer2++;
            else {
                pointer1++;
                pointer2++;
            }
        }

        return res;
    }
}
