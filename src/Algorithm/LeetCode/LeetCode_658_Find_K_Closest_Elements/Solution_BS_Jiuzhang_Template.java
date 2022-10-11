package Algorithm.LeetCode.LeetCode_658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

class Solution_BS_Jiuzhang_Template {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<Integer>();

        if (arr.length == 1) {
            ans.add(arr[0]);
            return ans;
        }

        int index = -1;
        int start = 0, end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start] == x) {
            index = start;
        } else if (arr[end] == x) {
            index = end;
        }

        int left, right;
        if (index == -1) {
            left = start;
            right = end;

            while (k-- > 0) {
                if (left < 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else if (x - arr[left] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            }
        } else {
            left = index - 1;
            right = index + 1;

            while (--k > 0) {
                if (left < 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else if (x - arr[left] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
