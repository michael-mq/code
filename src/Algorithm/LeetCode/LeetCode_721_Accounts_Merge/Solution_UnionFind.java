package Algorithm.LeetCode.LeetCode_721_Accounts_Merge;

import java.util.*;

class Solution_UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++){
                emailToName.put(account.get(i), name);

                if (!emailToID.containsKey(account.get(i))) {
                    emailToID.put(account.get(i), id++);
                }

                dsu.union(emailToID.get(account.get(1)), emailToID.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();

        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
        }

        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }

        return new ArrayList(ans.values());
    }
}

class DSU {
    int[] parent;

    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
