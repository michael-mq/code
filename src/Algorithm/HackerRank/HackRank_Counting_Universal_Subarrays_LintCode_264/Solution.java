package Algorithm.HackerRank.HackRank_Counting_Universal_Subarrays_LintCode_264;

import java.util.Stack;

// https://www.jiuzhang.com/solution/counting-universal-subarrays/
public class Solution {
    /**
     * @param array: An given array.
     * @return: Return the number of "universal" subarrays.
     */
    public int subarrays(int[] array) {
        // write your code here.
        return countUniversal(2, array) + countUniversal(4, array);
    }

    public int countUniversal(int left, int[] A) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (left == A[i]) {
                stack.add(i);
            } else {
                if (!stack.isEmpty()) {
                    cnt++;
                    stack.pop();
                }

                if (i < n - 1 && A[i + 1] == left) {
                    stack.clear();
                }
            }
        }

        return cnt;
    }
}
