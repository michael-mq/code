package Algorithm.LeetCode.LeetCode_975_Odd_Even_Jump;

import java.util.TreeMap;
//https://leetcode.cn/problems/odd-even-jump/solutions/1026259/wa-pian-975-qi-ou-tiao-java-zhong-ji-bai-86ae
class Solution {
    public int oddEvenJumps(int[] arr) {
        int len = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();// 距离当前数值最近的数值 & 下标 (重复中最近)
        map.put(arr[len - 1], len - 1);// 最后一个值入备选集合
        Boolean[][] dp = new Boolean[len][2];// 0 从当前位置i,奇数步出发是否可以抵达最后一个格子 , 1是偶数步
        dp[len - 1][0] = true;// 最后一个格子,抵达则达成条件
        dp[len - 1][1] = true;// 最后一个格子,抵达则达成条件
        int ans = 1;
        for (int index = len - 2; index >= 0; index--) {// 倒着走,从后往前走
            Integer ceil = map.ceilingKey(arr[index]);// 找A[i] <= A[j],当前奇数步出发,是否有后续能接纳的位置
            Integer floor = map.floorKey(arr[index]);// A[i] >= A[j],当前偶数步出发,是否有后续能接纳的位置
            dp[index][0] = ceil != null && dp[map.get(ceil)][1];// ==null,后续没有格子,当前奇数步出发,不能抵达.否则取决于后续偶数步是否能抵达
            dp[index][1] = floor != null && dp[map.get(floor)][0];// 同上,给前面奇数步出发垫步用的,对于当前点没用.
            if (dp[index][0]) {// 起脚就是奇数,判断当前点,作为首发出发是否能抵达
                ans++;// 能就多一种方案
            }
            map.put(arr[index], index);// 当前点加入备选列表,给index--用.只能在当前阶段处理后加入,否则被当成后面的点,就错了.
        }
        return ans;
    }
}