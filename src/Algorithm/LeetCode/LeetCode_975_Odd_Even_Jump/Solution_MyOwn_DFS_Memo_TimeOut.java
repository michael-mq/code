package Algorithm.LeetCode.LeetCode_975_Odd_Even_Jump;

class Solution_MyOwn_DFS_Memo_TimeOut {
    public int oddEvenJumps(int[] arr) {
        int[] memoOdd = new int[arr.length];
        int[] memoEven = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            memoOdd[i] = dfs(i, true, memoOdd, memoEven, arr);
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (memoOdd[i] == 1) {
                res++;
            }
        }

        return res;
    }

    private int dfs(int index, boolean isOdd, int[] memoOdd, int[] memoEven, int[] arr) {
        if (isOdd && memoOdd[index] != 0) {
            return memoOdd[index];
        }

        if (!isOdd && memoEven[index] != 0) {
            return memoEven[index];
        }

        if (index == arr.length - 1) {
            if (isOdd) {
                memoOdd[index] = 1;
            } else {
                memoEven[index] = 1;
            }

            return 1;
        }

        int next = isOdd ? oddJump(index, arr) : evenJump(index, arr);

        if (next == index) {
            if (isOdd) {
                memoOdd[index] = -1;
            } else {
                memoEven[index] = -1;
            }

            return -1;
        }

        return dfs(next, !isOdd, memoOdd, memoEven, arr);
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