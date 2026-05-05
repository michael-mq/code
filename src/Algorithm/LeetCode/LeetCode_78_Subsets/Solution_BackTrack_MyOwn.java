package Algorithm.LeetCode.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution_BackTrack_MyOwn {
    private List<List<Integer>> ans;
    private List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i);
        }

        ans.add(new ArrayList<>());

        return ans;
    }

    private void dfs(int[] nums, int index) {
        list.add(nums[index]);

        ans.add(new ArrayList<>(list));

        for (int i = index + 1; i < nums.length; i++) {
            dfs(nums, i);
        }

        list.removeLast();
    }
}