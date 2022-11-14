package Algorithm.LeetCode.LeetCode_1122_Relative_Sort_Array;

import java.util.*;

// https://leetcode.cn/problems/relative-sort-array/solutions/483863/shu-zu-de-xiang-dui-pai-xu-by-leetcode-solution/comments/666104
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : arr1) {
            list.add(num);
        }

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) && map.containsKey(y)) {
                return map.get(x) - map.get(y);
            }

            if (map.containsKey(x) && !map.containsKey(y)) {
                return -1;
            }

            if (!map.containsKey(x) && map.containsKey(y)) {
                return 1;
            }

            return x - y;
        });

//        Collections.sort(list, (x, y) -> {
//            if (map.containsKey(x) || map.containsKey(y)) {
//                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
//            }
//
//            return x - y;
//        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }
}