package Algorithm.LeetCode.LeetCode_169_MajorityElement;

public class Solution_DivideConquer {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".

        // int leftCount = countInRange(nums, left, lo, hi);
        // int rightCount = countInRange(nums, right, lo, hi);

        // no need to count left or right from lo to hi
        // left or right can be counted on their own side
        int leftCount = countInRange(nums, left, lo, mid);
        int rightCount = countInRange(nums, right, mid + 1, hi);

        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        Solution_DivideConquer solution_hashMap_1 = new Solution_DivideConquer();

        System.out.println(solution_hashMap_1.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution_hashMap_1.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
