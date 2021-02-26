package Algorithm.LeetCode.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        recursion(nums, 0, res);

        return res;
    }

    private void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length)
            return;

        int size = res.size();

        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }

        recursion(nums, i + 1, res);
    }
}
