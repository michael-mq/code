package Algorithm.LeetCode.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> subset =  new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        res.add(subset);

        preOrder(nums, 0, subset, res);

        return res;
    }

    private void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length)
            return;

        subset = new ArrayList<>(subset);

        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    private void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length)
            return;

        subset = new ArrayList<>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    private void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        res.add(subset);
    }
}
