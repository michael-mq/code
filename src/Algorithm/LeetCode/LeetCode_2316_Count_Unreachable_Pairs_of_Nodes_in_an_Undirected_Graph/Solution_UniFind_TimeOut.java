package Algorithm.LeetCode.LeetCode_2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph;

class Solution_UniFind_TimeOut {
    public long countPairs(int n, int[][] edges) {
        UniFind uf = new UniFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!uf.isConnected(i, j)) {
                    res++;
                }
            }
        }

        return res;
    }
}