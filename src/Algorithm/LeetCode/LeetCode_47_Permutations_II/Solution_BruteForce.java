package Algorithm.LeetCode.LeetCode_47_Permutations_II;

import java.util.*;

class Solution_BruteForce {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<String> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        if (nums.length == 0) return result;
        backtrack(nums, path, used);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length && !set.contains(path.toString())) {
            result.add(new ArrayList<>(path));
            set.add(path.toString());
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果path中已有，则跳过
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}