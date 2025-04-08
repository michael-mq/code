package Algorithm.LeetCode.LeetCode_809_Expressive_Words;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/expressive-words/editorial
class Solution_MyOwn_ReWriting {
    public int expressiveWords(String s, String[] words) {
        rle R1 = new rle(s);
        List<Integer> c1 = R1.counts;
        int ans = 0;

        search:
        for (String w : words) {
            rle R2 = new rle(w);
            List<Integer> c2 = R2.counts;

            if (!R1.key.equals(R2.key)) {
                continue;
            }

            for (int i = 0; i < c1.size(); i++) {
                if (c1.get(i) != c2.get(i) && c1.get(i) < 3 || c1.get(i) < c2.get(i)) {
                    continue search;
                }
            }

            ans++;
        }

        return ans;
    }
}

class rle {
    String key = "";
    List<Integer> counts = new ArrayList<>();

    public rle(String S) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char c = S.charAt(0);

        for (int i = 1; i <= S.length(); i++) {
            if (i == S.length()) {
                sb.append(c);
                counts.add(count);
                break;
            }

            if (S.charAt(i) != S.charAt(i - 1)) {
                sb.append(c);
                counts.add(count);
                count = 1;
                c = S.charAt(i);
                continue;
            }

            count++;
        }

        key = sb.toString();
    }
}