package Algorithm.Others.BinarySearch;

/*
使用条件
• 排序数组(30-40%是二分)
• 当面试官要求你找一个比O(n) 更小的时间复杂度算法的时候(99%)
• 找到数组中的一个分割位置，使得左半部分满足某个条件，右半部分不满足(100%)
• 找到一个最大/最小的值使得某个条件被满足(90%)
复杂度
• 时间复杂度：O(logn)
• 空间复杂度：O(1)
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        // corner case 处理
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        // 要点1: start + 1 < end - leave 1 or 2 in the end for final comparing
        while (start + 1 < end) {
            // 要点2：start + (end - start) / 2 - prevent stackoverflow issue
            int mid = start + (end - start) / 2;

            // 要点3：=, <, > 分开讨论，mid 不+1 也不-1
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }

            // 要点4: 循环结束后，单独处理start 和end
            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }
        }

        return -1;
    }
}
