package Algorithm.LeetCode.LeetCode_1570_Dot_Product_of_Two_Sparse_Vectors;

import java.util.HashMap;
import java.util.Map;

class SparseVector_HashMap {
    Map<Integer, Integer> map;

    SparseVector_HashMap(int[] nums) {
        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector_HashMap vec) {
        Map<Integer, Integer> vecMap = vec.map;
        int result = 0;

        for (int key : map.keySet()) {
            if (vecMap.containsKey(key)) {
                result += map.get(key) * vecMap.get(key);
            }
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);