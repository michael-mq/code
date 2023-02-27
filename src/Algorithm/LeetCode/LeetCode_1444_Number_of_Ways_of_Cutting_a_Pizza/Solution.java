package Algorithm.LeetCode.LeetCode_1444_Number_of_Ways_of_Cutting_a_Pizza;

// https://leetcode.jp/leetcode-1444-number-of-ways-of-cutting-a-pizza-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
class Solution {
    Integer memo[][][]; // 记忆数组

    public int ways(String[] pizza, int k) {
        char[][] arr = new char[pizza.length][pizza[0].length()];
        // 为了方便，先将pizza转化为二维字符数组
        for (int i = 0; i < pizza.length; i++) {
            String piz = pizza[i];
            arr[i] = piz.toCharArray();
        }
        // 初始化记忆数组
        memo = new Integer[arr.length][arr[0].length][k + 1];
        // 递归求解
        return help(arr, 0, 0, k);
    }

    // arr：披萨数组
    // row：当前开始行
    // col：当前开始列
    // k：剩余刀数
    int help(char[][] arr, int row, int col, int k) {
        // 切完所有刀后
        if (k == 1) {
            // 如果当前剩余披萨中含有苹果，返回true，反之返回false
            return hasApple(arr, row, arr.length - 1, col, arr[0].length - 1) ? 1 : 0;
        }
        // 如果记忆数组中存在当前解，返回记忆数组中的值
        if (memo[row][col][k] != null) return memo[row][col][k];
        // 当前递归返回结果
        long res = 0;
        // 分别循环横向每一种切法（上半部分存在1行，2行，3行。。。）
        for (int i = row; i < arr.length - 1; i++) {
            // 如果上半部分中有苹果
            if (hasApple(arr, row, i, col, arr[0].length - 1)) {
                // 将下半部分剩余披萨递归至子问题
                // 子问题的返回结果累加至当前返回结果
                res += help(arr, i + 1, col, k - 1);
            }
        }
        // 纵切同理
        for (int i = col; i < arr[0].length - 1; i++) {
            if (hasApple(arr, row, arr.length - 1, col, i)) {
                res += help(arr, row, i + 1, k - 1);
            }
        }
        // 将返回结果取余后转为int型
        int count = (int) (res % 1000000007);
        // 保存至记忆数组
        memo[row][col][k] = count;
        return count;
    }

    // 查看当前区域是否含有苹果
    boolean hasApple(char[][] arr, int rowT, int rowB, int colL, int colR) {
        for (int r = rowT; r <= rowB; r++) {
            for (int c = colL; c <= colR; c++) {
                if (arr[r][c] == 'A') return true;
            }
        }
        return false;
    }
}