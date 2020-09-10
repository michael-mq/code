package Algorithm.LeetCode.LeetCode_278_First_Bad_Version;

public class Solution {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // because when we have found bad version
                // we have to include it
                // it might be the first one
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean isBadVersion(int n) {
        return n == 2 || n == 3;
    }


    public static void main(String[] args) {
        Solution foo = new Solution();

        System.out.println(foo.firstBadVersion(2));
        System.out.println(foo.firstBadVersion(3));
    }
}
