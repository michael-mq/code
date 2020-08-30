package Algorithm.LeetCode.LeetCode_200_Number_of_Islands;

class Solution_UnionFind {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

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
                        count++;
                    }

                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }

            return find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[x] > rank[y]) {
                    parent[rootY] = rootX;
                } else if (rank[x] < rank[y]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }

                count--;
            }
        }

        public int getCount() {
            return count;
        }

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(grid);

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';

                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }

                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }

                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }

                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; ++i) {
            for (int c = 0; c < n; ++c) {
                if (grid[i][c] == '1') {
                    grid[i][c] = '0';
                    if (i - 1 >= 0 && grid[i - 1][c] == '1') {
                        uf.union(i * n + c, (i - 1) * n + c);
                    }
                    if (i + 1 < m && grid[i + 1][c] == '1') {
                        uf.union(i * n + c, (i + 1) * n + c);
                    }
                    if (c - 1 >= 0 && grid[i][c - 1] == '1') {
                        uf.union(i * n + c, i * n + c - 1);
                    }
                    if (c + 1 < n && grid[i][c + 1] == '1') {
                        uf.union(i * n + c, i * n + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        Solution_UnionFind foo = new Solution_UnionFind();

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(foo.numIslands(grid));

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(foo.numIslands(grid));
    }
}
