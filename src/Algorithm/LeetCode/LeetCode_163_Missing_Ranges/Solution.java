package Algorithm.LeetCode.LeetCode_163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lo;

        for (int j : a) {
            // not within the range yet
            if (j < next) continue;

            // continue to find the next one
            if (j == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, j - 1));

            // now we need to find the next number
            next = j + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
