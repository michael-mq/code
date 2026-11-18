package Algorithm.LeetCode.LeetCode_139_Word_Break;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_DFS_Memo_MyOwn {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        int len = s.length();

        if (len == 0) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) {
                    map.put(s, true);

                    return true;
            }
        }

        map.put(s, false);

        return false;
    }
}