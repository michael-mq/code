package Algorithm.LeetCode.LeetCode_323_Number_of_Connected_Components_in_an_Undirected_Graph;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/solutions/516491/java-union-find-dfs-bfs-solutions-complexity-explain-clean-code/?orderBy=most_votes
class Solution_UnionFind_Simple {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int p1 = findParent(parents, edge[0]);
            int p2 = findParent(parents, edge[1]);

            if (p1 != p2) {
                parents[p2] = p1;
                components--;
            }
        }

        return components;
    }

    private int findParent(int[] parents, int node) {
        while (node != parents[node]) {
            node = parents[node];
        }

        return node;
    }
}