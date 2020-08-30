// https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-tao-mo-ban-ji-ke-by-jeromememory/

package Algorithm.LeetCode.LeetCode_31_Combination_Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CombinationSum1 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 排序的原因是在回溯的时候比较容易剪枝
        Arrays.sort(candidates);
        // 套用上面的公式，candidates是指选择列表，target用来判断是否结束以及用于剪枝
        // track则是路径，即已经做出的选择
        backtrack(candidates, 0, target, track, res);
        return res;
    }

    private static void backtrack(int[] candidates, int start, int target, LinkedList<Integer> track, List<List<Integer>> res) {
        //先判断结束条件
        if (target < 0) return;
        if (target == 0) {
            // 当target等于0的时候，将路径加入到结果列表中
            res.add(new LinkedList<>(track));
            return;
        }
        //下面会设置start，每次递归的时候只在candidates中当前及之后的数字中选择。
        for (int i = start; i < candidates.length; i++) {
            // 这就是排序的好处，可以直接这样剪枝，否则还得遍历
            if (target < candidates[i]) break;
            track.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], track, res);
            track.removeLast();
        }
    }
}

class CombinationSum1Main {
    public static void main(String[] args) {
        CombinationSum1 combinationSum = new CombinationSum1();
        List<List<Integer>> res = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }
}
