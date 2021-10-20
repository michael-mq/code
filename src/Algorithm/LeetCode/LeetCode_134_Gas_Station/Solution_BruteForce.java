package Algorithm.LeetCode.LeetCode_134_Gas_Station;

class Solution_BruteForce {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                if (isValid(i, gas, cost)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private boolean isValid(int index, int[] gas, int[] cost) {
        int tank = gas[index];
        int n = gas.length;

        for (int i = 1; i < n; i++) {
            index = (index + 1 + n) % n;
            tank = tank - cost[(index - 1 + n) % n];

            if (tank <= 0) {
                return false;
            }

            tank = tank + gas[index];
        }

        if (tank - cost[index] < 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_BruteForce solution = new Solution_BruteForce();
        System.out.println(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(solution.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(solution.canCompleteCircuit(new int[]{4, 5, 2, 6, 5, 3}, new int[]{3, 2, 7, 3, 2, 9}));
    }
}
