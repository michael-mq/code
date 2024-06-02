package Algorithm.LeetCode.LeetCode_2402_Meeting_Rooms_III;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

//https://leetcode.cn/problems/meeting-rooms-iii/solutions/1799420/shuang-dui-mo-ni-pythonjavacgo-by-endles-ctwc/
//https://leetcode.cn/problems/meeting-rooms-iii/solutions/1799514/by-wangzhizhi-92xh/
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        var cnt = new int[n];
        // 当前还有哪些会议室可用
        PriorityQueue<Integer> idle = new PriorityQueue<>();

        for (var i = 0; i < n; ++i)
            idle.offer(i);

        // 当前在进行的会议的结束时间和占用的会议室号
        var using = new PriorityQueue<Pair<Long, Integer>>((a, b) -> !Objects.equals(a.getKey(), b.getKey()) ?
                Long.compare(a.getKey(), b.getKey()) : Integer.compare(a.getValue(), b.getValue()));

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (var m : meetings) {
            long st = m[0], end = m[1];

            // 如果现在有会议进行，并且有会议的时间早于当前会议的开始时间
            while (!using.isEmpty() && using.peek().getKey() <= st) {
                idle.offer(using.poll().getValue()); // 维护在 st 时刻空闲的会议室
            }

            int id;

            if (idle.isEmpty()) {
                var p = using.poll(); // 没有可用的会议室，那么弹出一个最早结束的会议室（若有多个同时结束的，会弹出下标最小的）
                end = end - st + p.getKey(); // 更新当前会议的结束时间
                id = p.getValue();
            } else
                id = idle.poll();

            ++cnt[id];
            using.offer(new Pair<>(end, id)); // 使用一个会议室
        }

        var ans = 0;

        for (var i = 0; i < n; ++i)
            if (cnt[i] > cnt[ans])
                ans = i;

        return ans;
    }
}
