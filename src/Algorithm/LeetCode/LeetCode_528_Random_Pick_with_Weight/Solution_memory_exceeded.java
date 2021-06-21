package Algorithm.LeetCode.LeetCode_528_Random_Pick_with_Weight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Memory Limit Exceeded
class Solution_memory_exceeded {
    private int sum = 0;
    private Map<Integer, Integer> map = new HashMap<>();
    private Random random = new Random();
    private int[] w;

    public Solution_memory_exceeded(int[] w) {
        this.w = w;

        for (int n : w) {
            sum += n;
        }

        int number = 1;

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                map.put(number++, i);
            }
        }
    }

    public int pickIndex() {
        int randomNumber = random.nextInt(sum) + 1;
        return map.get(randomNumber);
    }

    public static void main(String[] args) {
        Solution_memory_exceeded obj = new Solution_memory_exceeded(new int[]{1, 3});
        System.out.println(obj.pickIndex());
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
