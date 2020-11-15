package Algorithm.LeetCode.LeetCode_921_Minimum_Add_to_Make_Parentheses_Valid;

public class Solution_Greedy {
    public int minAddToMakeValid(String S) {
        // bal is the number of '('
        int ans = 0, bal = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }

            // if there is only ')'
            if (bal == -1) {
                ans++; // we have been missing a '(' in the front
                bal++; // reset bal to 0
            }
        }

        return ans + bal; // how many '(' we need to add + how many '(' left
    }
}
