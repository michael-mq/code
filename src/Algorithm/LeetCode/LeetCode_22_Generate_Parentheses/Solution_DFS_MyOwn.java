package Algorithm.LeetCode.LeetCode_22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution_DFS_MyOwn {
    List<String> ans;
    StringBuilder sb;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        ans = new ArrayList<>();
        sb = new StringBuilder();

        dfs(0, 0);

        return ans;
    }

    private void dfs(int cntLeft, int cntRight) {
        if (cntLeft == cntRight && cntLeft == n) {
            ans.add(sb.toString());

            return;
        }

        if (cntRight > cntLeft) {
            return;
        }

        if (cntLeft > n || cntRight > n) {
            return;
        }

        sb.append("(");

        dfs(cntLeft + 1, cntRight);

        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");

        dfs(cntLeft, cntRight + 1);

        sb.deleteCharAt(sb.length() - 1);
    }
}