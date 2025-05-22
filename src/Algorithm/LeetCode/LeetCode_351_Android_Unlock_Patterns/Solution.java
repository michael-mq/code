package Algorithm.LeetCode.LeetCode_351_Android_Unlock_Patterns;

class Solution {
    private int[][] jump;
    private boolean[] visited;

    public int numberOfPatterns(int m, int n) {
        jump = new int[10][10];

        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[1][9] = jump[9][1] =
                jump[2][8] = jump[8][2] =
                        jump[3][7] = jump[7][3] =
                                jump[4][6] = jump[6][4] = 5;

        visited = new boolean[10];

        int result = 0;

        for (int len = m; len <= n; len++) {
            result += backtrack(1, len - 1) * 4;
            result += backtrack(2, len - 1) * 4;
            result += backtrack(5, len - 1);
        }

        return result;
    }

    private int backtrack(int current, int remaining) {
        if (remaining == 0) {
            return 1;
        }

        visited[current] = true;

        int count = 0;

        for (int next = 1; next <= 9; next++) {
            if (!visited[next] && (jump[current][next] == 0 || visited[jump[current][next]])) {
                count += backtrack(next, remaining - 1);
            }
        }

        visited[current] = false;

        return count;
    }
}