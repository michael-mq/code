package Algorithm.LeetCode.LeetCode_1366_Rank_Teams_by_Votes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();

        int numOfMembers = votes[0].length();

        for (String members : votes) {
            for (int j = 0; j < members.length(); j++) {
                char member = members.charAt(j);
                int[] rankArr = map.getOrDefault(member, new int[numOfMembers]);
                rankArr[j]++;
                map.put(member, rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());

        list.sort((team1, team2) -> {
            int[] rank1 = team1.getValue();
            int[] rank2 = team2.getValue();

            for (int i = 0; i < numOfMembers; i++) {
                if (rank1[i] != rank2[i]) {
                    return rank2[i] - rank1[i];
                }
            }

            return team1.getKey() - team2.getKey();
        });

        return list
                .stream()
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));

    }
}
