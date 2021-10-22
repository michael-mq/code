package Algorithm.LeetCode.LeetCode_1299_Replace_Elements_with_Greatest_Element_on_Right_Side;

class Solution_MyOwn {
    public int[] replaceElements(int[] arr) {
        int[] max = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;

                continue;
            }

            if (max[0] <= i) {
                max[1] = 0;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max[1]) {
                        max[1] = arr[j];
                        max[0] = j;
                    }
                }
            }

            arr[i] = max[1];
        }

        return arr;
    }
}
