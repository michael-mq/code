package Algorithm.LeetCode.LeetCode_216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;
// https://www.programmercarl.com/0216.组合总和III.html
class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtracking(k, n, 1, 0, path, res);

        return res;
    }

    private void backtracking(int k, int n, int startIndex, int sum, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }

            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, i + 1, sum, path, res);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}