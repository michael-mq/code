package Algorithm.LeetCode.LeetCode_896_Monotonic_Array;

public class Solution2 {
    public boolean isMonotonic(int[] A) {
        int store = 0;

        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i + 1]);

            if (c != 0) {
                if (store != 0 && c != store) {
                    return false;
                }

                store = c;
            }
        }

        return true;
    }
}
