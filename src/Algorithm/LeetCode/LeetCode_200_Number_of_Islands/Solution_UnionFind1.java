package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

class Solution_UnionFind1 {
    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m * n];
            rank = new int[m * n];

            // Reduce dimension to 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        rank[i * n + j] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    parent[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }

                count--;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : directions) {
                        int row = i + d[0];
                        int col = j + d[1];

                        if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == '1') {
                            uf.union(i * n + j, row * n + col);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }
}


