package Algorithm.LeetCode.LeetCode_286_Walls_and_Gates;

class Solution_DFS_TimeOut {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (dis > rooms[i][j]) {
            return;
        }

        rooms[i][j] = dis;

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length) {
                dfs(rooms, x, y, dis + 1);
            }
        }
    }
}