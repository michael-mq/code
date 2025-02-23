package Algorithm.LeetCode.LeetCode_2345_Finding_the_Number_of_Visible_Mountains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int visibleMountains(int[][] peaks) {
        List<int[]> intervals = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        // 转换为区间表示，并统计相同区间的数量
        for (int[] peak : peaks) {
            int left = peak[0] - peak[1];
            int right = peak[0] + peak[1];
            intervals.add(new int[]{left, right});
            String key = left + "," + right;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        // 按左边界升序排序，若左边界相同，则按右边界降序排序
        intervals.sort((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int visibleCount = 0;
        int curRight = Integer.MIN_VALUE;

        // 遍历区间
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];

            // 如果完全被覆盖（right <= curRight），则跳过
            if (right <= curRight) {
                continue;
            }

            // 只统计出现次数为 1 的区间
            if (countMap.get(left + "," + right) == 1) {
                visibleCount++;
            }

            // 更新当前最大右边界
            curRight = right;
        }

        return visibleCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] peaks1 = {{2, 2}, {6, 3}, {5, 4}};
        int[][] peaks2 = {{1, 2}, {2, 1}, {3, 3}, {4, 1}};

        System.out.println(sol.visibleMountains(peaks1)); // 输出: 2
        System.out.println(sol.visibleMountains(peaks2)); // 输出: 2
    }
}