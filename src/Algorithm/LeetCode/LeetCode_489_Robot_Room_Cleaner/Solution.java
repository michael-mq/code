package Algorithm.LeetCode.LeetCode_489_Robot_Room_Cleaner;


import java.util.HashSet;
import java.util.Set;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

class Pair<T, F> {
    private T left;
    private F right;

    public Pair(T left, F right) {
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair<>(row, col));
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int newDirection = (d + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newDirection);
                goBack();
            }

            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
}
