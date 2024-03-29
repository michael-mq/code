package Algorithm.LeetCode.LeetCode_22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_DFS {
    // 做加法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);

        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝，重要！！
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }

        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {
        Solution_DFS foo = new Solution_DFS();

        List<String> result = foo.generateParenthesis(3);

        System.out.println(Arrays.toString(result.toArray()));
    }
}
