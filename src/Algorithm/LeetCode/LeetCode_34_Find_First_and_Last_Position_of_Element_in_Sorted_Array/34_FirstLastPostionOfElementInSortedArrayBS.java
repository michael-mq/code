package Algorithm.LeetCode.LeetCode_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/duo-tu-yan-shi-34-zai-pai-xu-shu-zu-zhong-cha-zhao/
// O(log n)

class FirstLastPostionOfElementInSortedArrayBS_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int firstIndex = find(true, nums, target);
        int lastIndex = find(false, nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    //查找第一个和最后一个元素
    private int find(boolean isFindFirst, int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        //if和else if的逻辑跟正常的二分查找一样
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            }
            //找到目标值了，开始定位到第一个和最后一个位置
            else {
                //查找第一个和最后一个逻辑很类似，这里用一个变量标记
                //是查找第一个还是查找最后一个
                if (isFindFirst) {
                    //如果不满足条件，缩小右边界，继续往左边查找
                    if (mid > 0 && nums[mid] == nums[mid - 1]) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    //如果不满足条件，增大左边界，继续往右边查找
                    if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                        begin = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}

class FirstLastPostionOfElementInSortedArrayBS_34_Main {
    public static void main(String[] args) {
        FirstLastPostionOfElementInSortedArrayBS_34 foo = new FirstLastPostionOfElementInSortedArrayBS_34();

        System.out.println(Arrays.toString(foo.searchRange(new int[]{1, 2, 3, 4, 4, 4, 4, 5}, 4)));
    }
}
