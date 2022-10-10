package Algorithm.LeetCode.LeetCode_10_05_Sparse_Array_Search_LCCI;

class Solution {
    public int findString(String[] words, String s) {
        int start = 0, end = words.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            while (mid > start && words[mid].equals("")) {
                mid--;
            }

            if (words[mid].compareTo(s) == 0) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (words[start].equals(s)) {
            return start;
        }

        if (words[end].equals(s)) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        //                 0     1   2   3   4      5   6    7     8   9    10    11  12
        String s = "ta";

        System.out.println(solution.findString(words, s));
    }
}