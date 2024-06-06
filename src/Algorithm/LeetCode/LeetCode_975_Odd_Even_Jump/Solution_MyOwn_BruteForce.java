package Algorithm.LeetCode.LeetCode_975_Odd_Even_Jump;

class Solution_MyOwn_BruteForce_TimeOut {
    public int oddEvenJumps(int[] arr) {
        int res = 0;
        boolean[] shouldBreak = new boolean[1];

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                res++;
                break;
            }

            int index = i;

            while (index < arr.length) {
                shouldBreak[0] = false;
                index = oddJump(arr, index, res, shouldBreak);
                if (shouldBreak[0]) {
                    break;
                }

                if (index == arr.length - 1) {
                    res++;
                    break;
                }

                shouldBreak[0] = false;
                index = evenJump(arr, index, res, shouldBreak);
                if (shouldBreak[0]) {
                    break;
                }

                if (index == arr.length - 1) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    private int oddJump(int[] arr, int i, int res, boolean[] shouldBreak) {
        int smallest = Integer.MAX_VALUE;
        int index = i;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] <= arr[j]) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    index = j;
                }
            }
        }

        if (index == i) {
            shouldBreak[0] = true;
        }

        return index;
    }

    private int evenJump(int[] arr, int i, int res, boolean[] shouldBreak) {
        int largest = Integer.MIN_VALUE;
        int index = i;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] >= arr[j]) {
                if (arr[j] > largest) {
                    largest = arr[j];
                    index = j;
                }
            }
        }

        if (index == i) {
            shouldBreak[0] = true;
        }

        return index;
    }
}