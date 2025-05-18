package Algorithm.LeetCode.LeetCode_247_Strobogrammatic_Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }

    private List<String> build(int k, int n) {
        char[][] pairs = {
                {'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}
        };

        if (k == 0) {
            return Arrays.asList("");
        }

        if (k == 1) {
            return Arrays.asList("0", "1", "8");
        }

        List<String> middles = build(k - 2, n);
        List<String> result = new ArrayList<>();

        for (String middle : middles) {
            for (char[] pair : pairs) {
                if (k == n && pair[0] == '0') {
                    continue;
                }

                result.add(pair[0] + middle + pair[1]);
            }
        }

        return result;

    }
}