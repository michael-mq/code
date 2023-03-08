package Algorithm.LeetCode.LeetCode_323_Number_of_Connected_Components_in_an_Undirected_Graph;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/solutions/516491/java-union-find-dfs-bfs-solutions-complexity-explain-clean-code/?orderBy=most_votes
class Solution_UnionFind_PathCompression_Size {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        int[] sizes = new int[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        for (int[] edge : edges) {
            int p1 = findParent(parents, edge[0]);
            int p2 = findParent(parents, edge[1]);

            if (p1 != p2) {
                if (sizes[p1] < sizes[p2]) {
                    parents[p1] = p2;
                    sizes[p2] += sizes[p1];
                } else {
                    parents[p2] = p1;
                    sizes[p1] += sizes[p2];

                }

                components--;
            }
        }

        return components;
    }

    private int findParent(int[] parents, int node) {
        if (node == parents[node]) {
            return node;
        }

        parents[node] = findParent(parents, parents[node]);

        return parents[node];
    }
}