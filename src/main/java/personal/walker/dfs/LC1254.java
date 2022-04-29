package personal.walker.dfs;

import personal.walker.Solution;
import personal.walker.Util;

public class LC1254 implements Solution {
    @Override
    public void runTestCases() {
        closedIsland(Util.convertTwoDimensionToIntegerArray("[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0]]"));
    }

    /**
     * @param grid
     * @return
     */

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, i, j, visited) > 0) {
                        System.out.printf("point is %d:%d \n",i,j);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public void unionFind(int[][] grid,int i,int j){

    }
    public void findParent(){

    }
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length - 1 || j >= grid[0].length - 1 || i == 0 || j == 0) {
            return -1;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        if (i == 2 && j == 5){
            System.out.println("");
        }
        int directionResult = 1;
        for (int count = 0; count < dir.length; count++) {
            int in = i + dir[count][0];
            int jn = j + dir[count][1];
            if (grid[in][jn] == 0 && dfs(grid, in, jn, visited) < 0) {
                directionResult = -1;
            }
        }
        return directionResult;
    }
}
