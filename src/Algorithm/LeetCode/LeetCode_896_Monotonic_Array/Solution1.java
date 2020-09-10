package Algorithm.LeetCode.LeetCode_896_Monotonic_Array;

public class Solution1 {
    public boolean isMonotonic(int[] A) {
        // Only when both false;
        return isIncreasing(A) || isDecreasing(A);
    }

    boolean isIncreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }

        return true;
    }

    boolean isDecreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
