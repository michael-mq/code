package Algorithm.LeetCode.LeetCode_744_Find_Smallest_Letter_Greater_Than_Target;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] == target) {
                start = mid;
            } else if (letters[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (letters[start] > target) {
            return letters[start];
        }

        if (letters[end] > target) {
            return letters[end];
        }

        return letters[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] letters = new char[]{'e' , 'e' , 'e' , 'k' , 'q' , 'q' , 'q' , 'v' , 'v' , 'y' };
        char target = 'e';

        System.out.println(solution.nextGreatestLetter(letters, target));
    }
}