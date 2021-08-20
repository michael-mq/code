package Algorithm.LeetCode.LeetCode_860_Lemonade_Change;

public class Solution_MyOwn {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2]; //0 -> 5, 1 -> 10, 2 -> 20

        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                if (money[0] == 0) {
                    return false;
                }
                money[1]++;
                money[0]--;
            } else {
                if (money[1] == 0 && money[0] < 3) {
                    return false;
                }

                if (money[0] == 0) {
                    return false;
                }

                if (money[1] > 0 && money[0] > 0) {
                    money[1]--;
                    money[0]--;
                } else if (money[1] == 0) {
                    money[0]--;
                    money[0]--;
                    money[0]--;
                }
            }
        }

        return true;
    }
}
