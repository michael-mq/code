package Algorithm.LeetCode.LeetCode_167_Two_Sum_II_Input_Array_Is_Sorted;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] answer = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                answer = new int[]{++left, ++right};
                break;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}