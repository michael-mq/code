package Algorithm.LeetCode.LeetCode_300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://shangan.gitbook.io/gong-kai-ke/untitled-5/ke-hou-lian-xi/increasing-subsequences
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> numbers) {
        if (numbers.size() > 1) {
            result.add(new ArrayList<>(numbers));
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            if (!numbers.isEmpty() && numbers.get(numbers.size() - 1) > nums[i]) {
                continue;
            }
            visited.add(nums[i]);
            numbers.add(nums[i]);
            helper(nums, i + 1, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
}