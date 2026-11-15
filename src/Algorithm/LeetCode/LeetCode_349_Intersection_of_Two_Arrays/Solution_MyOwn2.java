package Algorithm.LeetCode.LeetCode_349_Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_MyOwn2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        List<Integer> res = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            while (p1 > 0 && p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) {
                    p1++;
            }

            while (p2 > 0 && p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) {
                p2++;
            }

            if (nums1[p1] == nums2[p2]) {
                res.add(nums1[p1]);
                p1++;
                p2++;

                while (p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) {
                    p1++;
                }

                while (p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) {
                    p2++;
                }
            } else if (nums1[p1] < nums2[p2]) {
                p1++;

                while (p1 < nums1.length && nums1[p1] == nums1[p1 - 1]) {
                    p1++;
                }
            } else {
                p2++;

                while (p2 < nums2.length && nums2[p2] == nums2[p2 - 1]) {
                    p2++;
                }
            }
        }

        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}