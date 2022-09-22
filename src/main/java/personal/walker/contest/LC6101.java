package personal.walker.contest;

import personal.walker.Solution;

public class LC6101 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0, j = 0; i < grid.length && j < grid[0].length; i++, j++) {
            if (grid[i][j] == 0) {
                return false;
            }
        }
        for (int i = 0, j = grid[0].length - 1; i < grid.length && j >= 0; i++, j--) {
            if (grid[i][j] == 0) {
                return false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j || (grid.length - i - 1) == j) {
                    continue;
                }
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}