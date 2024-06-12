package Algorithm.LeetCode.LeetCode_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/editorial/#approach-3-union-find
class Solution_UniFind {
    public long countPairs(int n, int[][] edges) {
        UniFind uf = new UniFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> components = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            components.merge(parent, 1, Integer::sum);
        }

        long res = 0;
        long remaining = n;

        for (int size : components.values()) {
            res += size * (remaining - size);
            remaining -= size;
        }

        return res;
    }
}

