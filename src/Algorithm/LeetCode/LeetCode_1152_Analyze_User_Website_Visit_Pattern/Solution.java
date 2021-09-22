package Algorithm.LeetCode.LeetCode_1152_Analyze_User_Website_Visit_Pattern;

import java.util.*;

class Pair {
    public int time;
    public String website;

    public Pair(int time, String website) {
        this.time = time;
        this.website = website;
    }
}

public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> userMap = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> websiteMap = new HashMap<>();
        String res = "";

        for (String userKey : userMap.keySet()) {
            List<Pair> pairs = userMap.get(userKey);

            pairs.sort((a, b) -> a.time - b.time);
            Set<String> set = new HashSet<>();

            for (int i = 0; i < pairs.size(); i++) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    for (int k = j + 1; k < pairs.size(); k++) {
                        String tuple = pairs.get(i).website + " " + pairs.get(j).website + " " + pairs.get(k).website;

                        if (!set.contains(tuple)) {
                            websiteMap.put(tuple, websiteMap.getOrDefault(tuple, 0) + 1);
                            set.add(tuple);
                        }

                        if (res.equals("") || websiteMap.get(res) < websiteMap.get(tuple) || (websiteMap.get(res).equals(websiteMap.get(tuple)) && res.compareTo(tuple) > 0)) {
                            res = tuple;
                        }
                    }
                }
            }
        }

        String[] resArray = res.split(" ");

        return new ArrayList<>(Arrays.asList(resArray));
    }

    public static void main(String[] args) {
        System.out.println("b".compareTo("a"));
    }
}
