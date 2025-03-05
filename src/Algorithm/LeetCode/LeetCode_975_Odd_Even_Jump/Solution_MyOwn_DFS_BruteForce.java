package Algorithm.LeetCode.LeetCode_975_Odd_Even_Jump;

class Solution_MyOwn_DFS_BruteForce {
    public int oddEvenJumps(int[] arr) {
        boolean[] resArr = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            resArr[i] = dfs(i, true, arr);
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (resArr[i]) {
                res++;
            }
        }

        return res;
    }

    private boolean dfs(int index, boolean isOdd, int[] arr) {
        if (index == arr.length - 1) {
            return true;
        }

        int next = isOdd ? oddJump(index, arr) : evenJump(index, arr);

        if (next == index) {
            return false;
        }

        return dfs(next, !isOdd, arr);
    }

    private int oddJump(int index, int[] arr) {
        int tmp = Integer.MAX_VALUE;
        int smallestIndex = index;

        for (int j = index + 1; j < arr.length; j++) {
            if (arr[index] <= arr[j]) {
                if (arr[j] < tmp) {
                    tmp = arr[j];
                    smallestIndex = j;
                }
            }
        }

        return smallestIndex;
    }

    private int evenJump(int index, int[] arr) {
        int tmp = Integer.MIN_VALUE;
        int largestIndex = index;

        for (int j = index + 1; j < arr.length; j++) {
            if (arr[index] >= arr[j]) {
                if (arr[j] > tmp) {
                    tmp = arr[j];
                    largestIndex = j;
                }
            }
        }

        return largestIndex;
    }
}