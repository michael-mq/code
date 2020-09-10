package Algorithm.LeetCode.LeetCode_896_Monotonic_Array;

public class Solution_MyOwn {
    public boolean isMonotonic(int[] A) {
        int len = A.length;

        if(len <= 1){
            return true;
        }

        boolean isIncrease = false;
        boolean isDecrease = false;

        for (int i = 0; i < len - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (isDecrease) {
                    return false;
                }
                isIncrease = true;
            } else if (A[i] > A[i + 1]) {
                if (isIncrease) {
                    return false;
                }

                isDecrease = true;
            }
        }

        return true;
    }
}
