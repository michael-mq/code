package Algorithm.LeetCode.LeetCode_885_Spiral_Matrix_III;

import java.util.Arrays;

// https://leetcode-cn.com/problems/spiral-matrix-iii/solution/dongge-de-jie-fa-si-lu-qing-xi-by-victor-gmmz/

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[][] around = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = r0, y = c0, num = 1, dir = 0;  //{x, y}为当前位置，num为当前查找的数字，dir为当前的方向
        int Left = c0 - 1, Right = c0 + 1, Upper = r0 - 1, Bottom = r0 + 1;  //四个方向的边界
        while (num <= R * C) {
            if (x >= 0 && x < R && y >= 0 && y < C) {  //{x， y}位置在矩阵中
                res[num - 1] = new int[]{x, y};
                num++;
            }
            if (dir == 0 && y == Right) {  //向右到右边界
                dir += 1;  //调转方向向下
                Right += 1;  //右边界右移
            } else if (dir == 1 && x == Bottom) {  //向下到底边界
                dir += 1;
                Bottom += 1;  //底边界下移
            } else if (dir == 2 && y == Left) {  //向左到左边界
                dir += 1;
                Left--;  //左边界左移
            } else if (dir == 3 && x == Upper) {  //向上到上边界
                dir = 0;
                Upper--;  //上边界上移
            }
            x += around[dir][0];   //下一个节点
            y += around[dir][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.spiralMatrixIII(1, 4, 0, 0)));
    }
}
