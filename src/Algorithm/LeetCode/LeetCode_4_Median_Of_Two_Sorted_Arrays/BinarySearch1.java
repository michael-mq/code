// https://www.youtube.com/watch?v=ScCg9v921ns&t=642s
package Algorithm.LeetCode.LeetCode_4_Median_Of_Two_Sorted_Arrays;

public class BinarySearch1 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;

        if (lenA > lenB) {
            return findMedianSortedArrays(B, A);
        }

        if (lenA == 0) {
            return ((double) B[(lenB - 1) / 2] + (double) B[lenB / 2]) / 2;
        }

        int len = lenA + lenB;

        int A_startK = 0, A_endK = lenA;
        int cutA, cutB;

        while (A_startK <= A_endK) {
            cutA = (A_startK + A_endK) / 2;
            cutB = (len + 1) / 2 - cutA;

            double lA = cutA == 0 ? Integer.MIN_VALUE : A[cutA - 1];
            double lB = cutB == 0 ? Integer.MIN_VALUE : B[cutB - 1];
            double rA = cutA == lenA ? Integer.MAX_VALUE : A[cutA];
            double rB = cutB == lenB ? Integer.MAX_VALUE : B[cutB];

            if (lA > rB) {
                A_endK = cutA - 1;
            } else if (lB > rA) {
                A_startK = cutA + 1;
            } else {
                if (len % 2 == 0) {
                    return (Math.max(lA, lB) + Math.min(rA, rB)) / 2;
                } else {
                    return Math.max(lA, lB);
                }
            }
        }

        return -1;
    }
}
