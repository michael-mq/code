package Algorithm.LeetCode.LeetCode_315_Count_Of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_DivideConquer {
//        解题思路：
//        1 - 把原数组的每一个元素 1）从左到右，2）放在新数组里排序 之后，
//        2 - 每个元素在插入到新的排序数组里的index，代表了：1)比它小的，2)原先在它右边的 元素的个数
//        * 关键就是要 1）得到，2）并记住 每个元素被 "inserted into" 在新的排序的数组里的index
//        * 用 二分查找 来找到该元素字新的排序数组里的位置
//
//        初始状态：
//        原数组为：[5,2,6,1]
//        排序数组：[]
//        结果数组：[]
//
//        第一轮：
//        原数组为：[5,2,6]
//        排序数组：[1]
//        插入的下标为 0，记入结果数组：[0,0,0,0]
//                                        ^
//
//        第二轮：
//        原数组为：[5,2]
//        排序数组：[1,6]
//        插入的下标为 1，记入结果数组：[0,0,1,0]
//                                      ^
//        第三轮：
//        原数组为：[5]
//        排序数组：[1,2,6]
//        插入的下标为 1，记入结果数组：[0,1,1,0]
//                                    ^
//        第四轮：
//        原数组为：[]
//        排序数组：[1,2,5,6]
//        插入的下标为 2，记入结果数组：[2,1,1,0]
//                                  ^
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }

        int len = nums.length;

        if (len == 0) {
            return new ArrayList<>();
        }

        if (len == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        List<Integer> sortedArray = new ArrayList<>();
        Integer[] result = new Integer[len];

        for (int i = len - 1; i >= 0; i--) {
            int left = 0, right = sortedArray.size();

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (sortedArray.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            // when left = right
            sortedArray.add(left, nums[i]);
            result[i] = left;
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        Solution_DivideConquer solution_bruteForce = new Solution_DivideConquer();

        System.out.println(solution_bruteForce.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
