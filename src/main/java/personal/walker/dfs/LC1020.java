package personal.walker.dfs;

import personal.walker.Solution;

public class LC1020 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1;j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int partResult = dfs(grid, i, j, visited);
                    if (partResult > 0){
                        result += partResult;
                    }
                }
            }
        }
        return result;
    }

    int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i <= 0 || j <= 0 || i >= grid.length - 1 || j >= grid[0].length - 1) {
            return -1;
        }
        visited[i][j] = true;
        int result = 1;
        boolean validate = true;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (grid[ni][nj] == 1 && !visited[ni][nj]) {
                int partResult = dfs(grid, ni, nj, visited);
                if (partResult < 0) {
                    validate = false;
                }
                result += partResult;
            }
        }
        return validate ? result : -1;
    }
}

