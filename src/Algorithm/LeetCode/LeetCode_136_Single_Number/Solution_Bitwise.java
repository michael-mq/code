package Algorithm.LeetCode.LeetCode_136_Single_Number;

//a ^ b ^ a = b

public class Solution_Bitwise {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution1 = new Solution_Bitwise();

        long startTime = System.nanoTime();

        System.out.println(solution1.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution1.singleNumber(new int[]{4, 1, 2, 1, 2}));

        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);

    }
}
