package Algorithm.LeetCode.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (Integer n : nums) {
            int size = res.size();

            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }

        return res;
    }
}
