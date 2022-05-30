package Algorithm.LeetCode.LeetCode_1570_Dot_Product_of_Two_Sparse_Vectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SparseVector_IndexValuePairs {
    List<int[]> pairs;

    SparseVector_IndexValuePairs(int[] nums) {
        pairs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector_IndexValuePairs vec) {
        List<int[]> vecPairs = vec.pairs;
        int result = 0;
        int i = 0, j = 0;

        while (i < pairs.size() && j < vecPairs.size()) {
            if (pairs.get(i)[0] == vecPairs.get(j)[0]) {
                result += pairs.get(i)[1] * vecPairs.get(j)[1];
                i++;
                j++;
            } else if (pairs.get(i)[0] > vecPairs.get(j)[0]) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);