package Algorithm.LeetCode.CN.Interview_16_21;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/sum-swap-lcci/solutions/959674/java-shu-xue-fang-fa-zhu-xing-zhu-shi-94-eksk/
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        // 记录两个数组的和
        int sum1 = 0, sum2 = 0;
        // 记录 array2 中的数都出现过哪些
        Set<Integer> container = new HashSet<>();

        for (int num : array1) {
            sum1 += num;
        }

        for (int num : array2) {
            container.add(num);
            sum2 += num;
        }

        // 求两个数组之差
        int diff = sum1 - sum2;
        // 如果不是偶数差值，那么直接返回空数组
        if (diff % 2 != 0) {
            return new int[]{};
        }

        diff /= 2;
        // 从 array2 中找到能和 array1 中 num 配对的数，如果找到了就直接返回，没找到就返回空数组。
        for (int num : array1) {
            if (container.contains(num - diff)) {
                return new int[]{num, num - diff};
            }
        }

        return new int[]{};
    }
}